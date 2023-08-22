/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.client;

import com.example.demo.model.User;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author leola
 */

    @FeignClient(url="http://localhost:8081", name="CEPTP1") 
    public interface UserClient {
    
    @GetMapping("users/{email}")
    User findUserBy(@PathVariable String email);
    
    
    @DeleteMapping("/users/{email}")
    void delete(@PathVariable String email);
    
//    @PutMapping("/users/{email}")
//    User update(@PathVariable String email, User user);
    
    @RequestMapping(method=RequestMethod.PUT, value="/users")
    public void update(@RequestParam("nome") String nome,
                       @PathVariable String email,                                        
                       @RequestParam("telefone") String telefone,
                       @RequestParam("cep") String cep,
                       @RequestParam("fileUrl") String fileUrl);

        
    @RequestMapping(method=RequestMethod.GET, value="/users")
    public List<User> findAll();
    

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public void addUser(@RequestParam("nome") String nome,
                            @RequestParam("email") String email, 
                            @RequestParam("telefone") String telefone,
                            @RequestParam("cep") String cep,
                            @RequestParam("fileUrl") String fileUrl);
//    {
//        
//       String file = storageService.store(fileUrl);
//        
//        Address a = addressClient.SearchAddressBy(cep);
//        
//        addressService.addAddress(a);        
//      
//        userService.addUser(new User(email, nome, telefone, cep, file, a) );
//    }
    
    //    @RequestMapping(method=RequestMethod.PUT, value="/users/{email}")
//    String update(@PathVariable String email, User user);
//                            @RequestParam("nome") String nome, 
//                            @RequestParam("telefone") String telefone,
//                            @RequestParam("cep") String cep,
//                            @RequestParam("fileUrl") MultipartFile fileUrl);

//    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
//    User addUser(@RequestBody User user);

//    @PostMapping("users/add")
//    String addUser(User user);
//    public void addUser(@RequestBody User user)
         
//    public void addArtwork(Artworks artwork){
//        repo.save(artwork);
//    }
//    
//    public void delete(Integer id){
//        repo.deleteById(id);
//    }
//    
//    public List<Artworks> findAll(){
//        return repo.findAll();
//    }
//    public Artworks findById(Integer id){
//        return repo.getById(id);
//    }
//    
//    public void update(Artworks a){
//        repo.save(a);
//    }
   

   

    

    
}

