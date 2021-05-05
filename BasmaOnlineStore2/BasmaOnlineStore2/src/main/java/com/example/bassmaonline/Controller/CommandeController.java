package com.example.bassmaonline.Controller;

import com.example.bassmaonline.entity.CategoriesEntity;
import com.example.bassmaonline.entity.CommandeEntity;
import com.example.bassmaonline.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;








@RestController
@RequestMapping("/Commande")
public  class  CommandeController{

    @Autowired
    CommandeService commandeService;


   //@GetMapping
   //public ResponseEntity<CommandeEntity> findCommandeByOrderId(@PathVariable Long orderId){
     //   CommandeEntity commande = CommandeService.getCommande(orderId);

       // return new ResponseEntity<CommandeEntity>(commande, HttpStatus.OK);
    //}
       //@GetMapping("/FormationById/{IdFormation}")
       //public  ResponseEntity<FormationEntity>getFormationById(@PathVariable Long IdFormation){
         //  FormationEntity formation = formationService.getFormation(IdFormation);


           //return new ResponseEntity<FormationEntity>(formation, HttpStatus.OK);
       //}

    @GetMapping
    public ResponseEntity<CommandeEntity> getAllCommandeByOrderId(@PathVariable Long orderId){
        CommandeEntity commande = commandeService.getCommandeByOrderId(orderId);
        return new ResponseEntity<CommandeEntity>(commande, HttpStatus.OK);
    }




    @PostMapping
    public ResponseEntity<CommandeEntity> createCommandeById(@RequestBody CommandeEntity commandeEntity) {
        CommandeEntity commandeEntity1 = commandeService.createCommande(commandeEntity);
        return new ResponseEntity<>(commandeEntity1,HttpStatus.CREATED);
    }
    @PutMapping(path = "/{IdCommande}")
    public ResponseEntity<CommandeEntity> updateCommandeById(@RequestBody CommandeEntity commandeEntity, @PathVariable Long orderId) {
        CommandeEntity commande = commandeService.updateCommande(orderId , commandeEntity);
        return new ResponseEntity<CommandeEntity>(commande, HttpStatus.ACCEPTED);

    }



    @DeleteMapping("/Removecat/{OrderId}")
    public ResponseEntity<CommandeEntity> removeCommandeById(@PathVariable Long orderId) {
        commandeService.deleteCommande(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}




