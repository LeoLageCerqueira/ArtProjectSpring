/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package br.edu.infnet.ArtProjectArtworkService.controller;

import br.edu.infnet.ArtProjectArtworkService.Model.Artworks;
import br.edu.infnet.ArtProjectArtworkService.service.ArtworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import br.edu.infnet.ArtProjectArtworkService.client.UserClient;
import br.edu.infnet.ArtProjectArtworkService.Model.Artworks;
import br.edu.infnet.ArtProjectArtworkService.Model.User;
import br.edu.infnet.ArtProjectArtworkService.service.StorageService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author leola
 */
@RestController
public class ArtworkController {
    private final ArtworkService artworkService;
    private final UserClient userClient;
    private final StorageService storageService;

    public ArtworkController(ArtworkService artworkService, UserClient userClient, StorageService storageService) {
        this.artworkService = artworkService;
        this.userClient = userClient;
        this.storageService = storageService;
    }


    
//    @RequestMapping(method=RequestMethod.POST, value="/artworks")
//    public void addArtwork(@RequestParam("name") String name,
//                            @RequestParam("price") float price, 
//                            @RequestParam("photo") MultipartFile photo,
//                            @RequestParam("artist")String artist){
//        String art = storageService.store(photo);
//        User user = userClient.findUserBy(artist);
//        
//        artworkService.addArtwork(new Artworks(name, price, art, user));
//    }
     @RequestMapping(method=RequestMethod.POST, value="/artworks")
    public void addArtwork(@RequestParam("name") String name,
                            @RequestParam("price") float price, 
                            @RequestParam("photo") String photo,
                            @RequestParam("artist")String artist){
//        String art = storageService.store(photo);
        User user = userClient.findUserBy(artist);
        
        artworkService.addArtwork(new Artworks(name, price, artist, user));
    }
    @RequestMapping(method=RequestMethod.GET, value="/artworks")
    public List<Artworks> findAll(){
        return artworkService.findAll();
    }
    @RequestMapping(method=RequestMethod.GET, value="/artworks/{id}")
    public Artworks findArtwork(@PathVariable Integer id){
        return artworkService.findById(id);
    }    
    
    @RequestMapping(method=RequestMethod.DELETE, value="/artworks/{id}")
    public void delete(@PathVariable Integer id){
        artworkService.delete(id);             
    }
    @RequestMapping(method=RequestMethod.PUT, value="/artworks/{id}")
    public void update(@PathVariable Integer id,
                            @RequestParam("name") String name,
                            @RequestParam("price") float price, 
                            @RequestParam("photo") String photo,
                            @RequestParam("artist")String artist){
        
//        String art = storageService.store(photo);
        User user = userClient.findUserBy(artist);
        
        artworkService.addArtwork(new Artworks(name, price, photo, user));
        
    }
                            
}    
    

