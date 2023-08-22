/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.client;

import com.example.demo.model.Artworks;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author leola
 */
@FeignClient(url="http://localhost:8082", name="ArtProjectArtworkService")
public interface ArtworksClient {
    
    @GetMapping("artworks/{id}")
    Artworks findArtworksBy(@PathVariable Integer id);
    
    @GetMapping("/artworks")
    List <Artworks> findAll();
 
    @RequestMapping(method=RequestMethod.POST, value="/artworks")
    public void addArtworks(@RequestParam("id") Integer id,
                            @RequestParam("nome") String name, 
                            @RequestParam("preço") float price,
                            @RequestParam("foto") String photo,
                            @RequestParam("artista") String artist);
//    @PostMapping("/artworks")
//    Artworks addArtwork(Artworks artwork);
                
    @PutMapping("/artworks/{id}")
    Artworks update(@PathVariable int id, Artworks artworks);
    
    @DeleteMapping("/artworks/{id}")
    void delete(@PathVariable int id);
    
}
