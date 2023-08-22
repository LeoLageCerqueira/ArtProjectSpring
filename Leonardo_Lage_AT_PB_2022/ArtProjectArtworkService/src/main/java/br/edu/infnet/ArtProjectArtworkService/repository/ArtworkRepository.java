/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package br.edu.infnet.ArtProjectArtworkService.repository;

import br.edu.infnet.ArtProjectArtworkService.Model.Artworks;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author leola
 */
public interface ArtworkRepository extends JpaRepository<Artworks, Integer> {
    
}
