/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package br.edu.infnet.cep.services;

import br.edu.infnet.cep.models.Address;
import br.edu.infnet.cep.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author leola
 */
@Service
@Transactional

public class AddressService {
    private final AddressRepository addressRepo;

    public AddressService(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }
    public void addAddress(Address address){
        this.addressRepo.save(address);
    }
    
}
