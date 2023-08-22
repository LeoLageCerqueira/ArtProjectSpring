/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.demo.controller;

import com.example.demo.StorageService.StorageService;
import com.example.demo.client.ArtworksClient;
import com.example.demo.model.Artworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ArtworksController {
    
    @Autowired
    private StorageService storageService;
    @Autowired
    private ArtworksClient artworksClient;
    
    
    @RequestMapping("/read-artworks")
    public String showReadArtworks(Model model) {
        model.addAttribute("artworks", artworksClient.findAll());
        return "readartworks";
    }
    @RequestMapping("/create-artwork")
    public String showCreateUser(Model model) {
        model.addAttribute("command", new Artworks());
        return "createartwork";
    }

    @RequestMapping(value = "/create-artwork", method = RequestMethod.POST)
            public String createUser(@RequestParam("id") Integer id,
                                    @RequestParam ("name") String name,
                                    @RequestParam("price") float price, 
                                    @RequestParam("photo") MultipartFile photo,
                                    @RequestParam("artist") String artist)
                                    
    {
        
            String file = storageService.store(photo);     
            
            artworksClient.addArtworks(id, name, price, file, artist);
                            
            return "redirect:/read-users";
    }
            
//        @RequestMapping(value = "/create-artwork", method = RequestMethod.POST)
//        public String createArtwork(@ModelAttribute("artwork") Artworks artwork) {
//        artworksClient.addArtwork(artwork); 
//        return "redirect:/read-artworks";
//    } 
            
    @RequestMapping(value = "/update-artworks/{id}")
    public String showUpdateArtwork(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", artworksClient.findArtworksBy(id));
        return "updateartworks";
    }

    @RequestMapping(value = "/update-artworks/{id}", method = RequestMethod.PUT)
    public String updateArtwork(@PathVariable int id, @ModelAttribute("artworks") Artworks artwork) {
        artworksClient.update(id, artwork);
        return "redirect:/read-artworks";
    }
    @RequestMapping(value = "/delete-artworks/{id}")
    public String deleteArtwork(@PathVariable int id) {
        artworksClient.delete(id);
        return "redirect:/read-artworks";
    }
    
}
