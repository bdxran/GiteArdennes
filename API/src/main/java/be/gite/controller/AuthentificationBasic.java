package be.gite.controller;

public class AuthentificationBasic {
    private String message; 

    public AuthentificationBasic(String message) { 
        this.message = message; 
    }

    public String getMessage() { 
        return message; 
    }

    public void setMessage(String message) { 
        this.message = message; 
    }

    @Override 
    public String toString() { 
        return String.format("Authentification [message=%s]", message); 

    } 
}