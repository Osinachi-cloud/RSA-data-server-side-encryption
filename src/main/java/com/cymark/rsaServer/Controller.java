package com.cymark.rsaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @GetMapping("getSecretMessage")
    public String getMessage(){
         String message = "Cymarck dev";
         try{
             EncryptionManager manager = new EncryptionManager();
             manager.initFromStrings();
             return manager.encrypt(message);
         }catch (Exception e){
             throw new RuntimeException(e.getMessage());
         }
    }

}
