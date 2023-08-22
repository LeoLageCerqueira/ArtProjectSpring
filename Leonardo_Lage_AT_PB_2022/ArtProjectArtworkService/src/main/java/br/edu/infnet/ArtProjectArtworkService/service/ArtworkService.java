/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package br.edu.infnet.ArtProjectArtworkService.service;

import br.edu.infnet.ArtProjectArtworkService.repository.ArtworkRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.edu.infnet.ArtProjectArtworkService.Model.Artworks;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author leola
 */
@Service
@Transactional
public class ArtworkService {
    
    @Autowired
    private final ArtworkRepository repo;

    public ArtworkService(ArtworkRepository repo) {
        this.repo = repo;
    }
    
    public void addArtwork(Artworks artwork){
        repo.save(artwork);
    }
    
    public void delete(Integer id){
        repo.deleteById(id);
    }
    
    public List<Artworks> findAll(){
        return repo.findAll();
    }
    public Artworks findById(Integer id){
        return repo.getById(id);
    }
    
    public void update(Artworks a){
        repo.save(a);
    }
}

