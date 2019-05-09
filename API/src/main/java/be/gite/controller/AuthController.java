package be.gite.controller;

import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RestController;

import be.gite.controller.AuthentificationBasic; 

@RestController
@CrossOrigin
public class AuthController {
	
    @GetMapping(path = "/basicauth") 
    public AuthentificationBasic authentifie() { 
        return new AuthentificationBasic("Vous êtes identifié !"); 
    }     
}
