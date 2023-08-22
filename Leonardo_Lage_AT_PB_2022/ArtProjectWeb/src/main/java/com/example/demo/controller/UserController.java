package com.example.demo.controller;

import com.example.demo.StorageService.StorageService;
import com.example.demo.client.UserClient;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    @Autowired
    private UserClient userClient;
    @Autowired
    private StorageService storageService;
    

    @RequestMapping("/read-users")
    public String showReadUser(Model model) {
        model.addAttribute("users", userClient.findAll());
        return "readuser";
    }
    

    @RequestMapping("/create-user")
    public String showCreateUser(Model model) {
        model.addAttribute("command", new User());
        return "createuser";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
            public String createUser(@RequestParam("nome") String nome, 
                                    @RequestParam ("email") String email,                                   
                                    @RequestParam("telefone") String telefone,
                                    @RequestParam("cep") String cep,
                                    @RequestParam("fileUrl") MultipartFile fileUrl)
    {
        
            String file = storageService.store(fileUrl);     
            
            userClient.addUser(nome, email, telefone, cep, file);
                            
            return "redirect:/read-users";
            
            } 
            
    @RequestMapping(value = "/update-user/{email}")
    public String showUpdateUser(@PathVariable String email, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("command", userClient.findUserBy(email));
        return "updateuser";
    }

    @RequestMapping(value = "/update-user/{email}", method = RequestMethod.PUT)
    public String updateUser(@RequestParam("nome") String nome, 
                                    @PathVariable ("email") String email,                                   
                                    @RequestParam("telefone") String telefone,
                                    @RequestParam("cep") String cep,
                                    @RequestParam("fileUrl") MultipartFile fileUrl)
    {
        String file = storageService.store(fileUrl);
        userClient.update(nome, email, telefone, cep, file);
        return "redirect:/read-users";
    }
    
    @RequestMapping(value = "/delete-user/{email}")
    public String deleteUser(@PathVariable String email) {
        userClient.delete(email);
        return "redirect:/read-users";
    }
    

}
