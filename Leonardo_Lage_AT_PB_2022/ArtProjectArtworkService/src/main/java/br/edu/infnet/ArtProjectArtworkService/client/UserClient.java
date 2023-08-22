/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.infnet.ArtProjectArtworkService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.edu.infnet.ArtProjectArtworkService.Model.User;
/**
 *
 * @author leola
 */
@FeignClient(url="http://localhost:8081", name="CEPTP1") 
public interface UserClient {
    
    @GetMapping("users/{email}")
    User findUserBy(@PathVariable String email);
    
}

