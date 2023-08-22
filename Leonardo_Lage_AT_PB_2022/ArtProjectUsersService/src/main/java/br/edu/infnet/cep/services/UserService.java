/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package br.edu.infnet.cep.services;

import br.edu.infnet.cep.models.User;
import br.edu.infnet.cep.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author leola
 */
@Service
@Transactional
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    public void addUser(User user){
        this.userRepo.save(user);
    }
    
    public List<User> findAll(){
        return userRepo.findAll();
    }
    
    public User findById(String email){
        return userRepo.getById(email);
    }
    
    public void delete(String email){
        userRepo.deleteById(email);
    }
    
    public void update(User user){
        userRepo.save(user);
    }

}
