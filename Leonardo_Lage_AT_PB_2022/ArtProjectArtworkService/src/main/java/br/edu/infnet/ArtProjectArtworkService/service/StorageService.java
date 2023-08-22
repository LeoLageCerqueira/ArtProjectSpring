/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package br.edu.infnet.ArtProjectArtworkService.service;


import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author leola
 */
@Service
public class StorageService {

    private final Path root = Paths.get("artworks");

    public void init() {
      try {
        Files.createDirectory(root);
      } catch (IOException e) {
        throw new RuntimeException("Could not initialize folder for upload!");
      }
    }

    public String store(MultipartFile photo) {
      try {
        Path root = Paths.get("artworks");
        if (!Files.exists(root)) {
            init();
        }
        Files.copy(photo.getInputStream(), this.root.resolve(photo.getOriginalFilename()));
      } catch (Exception e) {
        throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
      }
      
      return Paths.get("uploads") + "/" + photo.getOriginalFilename();
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }
}
