/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.infnet.cep.client;

import br.edu.infnet.cep.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url="https://viacep.com.br/ws/", name="cep")

public interface AddressClient {
    
    @GetMapping("{cep}/json/")
    Address SearchAddressBy(@PathVariable String cep);   
}
