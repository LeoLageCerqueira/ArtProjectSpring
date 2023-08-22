/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package br.edu.infnet.cep.controllers;

import br.edu.infnet.cep.client.AddressClient;
import br.edu.infnet.cep.models.Address;
import br.edu.infnet.cep.models.User;
import br.edu.infnet.cep.services.AddressService;
import br.edu.infnet.cep.services.StorageService;
import br.edu.infnet.cep.services.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author leola
 */
@RestController
public class UserController {
    
    private final UserService userService;
    private final AddressService addressService;
    private final AddressClient addressClient;
    private final StorageService storageService;

    public UserController(UserService userService, AddressService addressService, AddressClient addressClient, StorageService storageService) {
        this.userService = userService;
        this.addressService = addressService;
        this.addressClient = addressClient;
        this.storageService = storageService;
    }

   
    

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public void addUser(@RequestParam("nome") String nome,
                            @RequestParam("email") String email, 
                            @RequestParam("telefone") String telefone,
                            @RequestParam("cep") String cep,
                            @RequestParam("fileUrl") String fileUrl)
    {
        
//        String file = storageService.store(fileUrl);
        
        Address a = addressClient.SearchAddressBy(cep);
        
        addressService.addAddress(a);        
      
        userService.addUser(new User(nome, email, telefone, cep, fileUrl, a) );
    }
    

    
    @RequestMapping(method=RequestMethod.GET, value="/users")
    public List<User> findAll(){
        return userService.findAll();
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/users/{email}")
    public User findById(@PathVariable String email){
        return userService.findById(email);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/users/{email}")
    public void delete(@PathVariable String email){
        userService.delete(email);
             
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/users/{email}")
    public void update(@RequestParam("nome") String nome, 
                            @PathVariable String email,
                            @RequestParam("telefone") String telefone,
                            @RequestParam("cep") String cep,
                            @RequestParam("fileUrl") String fileUrl)
    {
        
//        String file = storageService.store(fileUrl);
        
        Address a = addressClient.SearchAddressBy(cep);
        
        addressService.addAddress(a);        
      
        userService.addUser(new User(nome, email, telefone, cep, fileUrl, a) );
    }
    
}
//                            @RequestParam("nome") String nome, 
//                            @RequestParam("telefone") String telefone,
//                            @RequestParam("cep") String cep,
//                            @RequestParam("fileUrl") String fileUrl){
//        
//        Address a = addressClient.SearchAddressBy(cep);
//        
//        addressService.addAddress(a);
//        
//      
//        userService.addUser(new User(email, nome, telefone, cep, fileUrl, a) );
//        
//    }
//}


