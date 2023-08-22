/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package br.edu.infnet.cep.repository;

import br.edu.infnet.cep.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author leola
 */
public interface AddressRepository extends JpaRepository<Address, String> {
    
}
