package com.example.bassmaonline.service;


import com.example.bassmaonline.Reposotory.CategoriesReposotory;
import com.example.bassmaonline.Reposotory.CommandeReposotory;
import com.example.bassmaonline.entity.CategoriesEntity;
import com.example.bassmaonline.entity.CommandeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class CommandeServiceImp implements CommandeService {
    @Autowired
    CommandeReposotory commandeReposotory;

    @Override
    public CommandeEntity createCommande(CommandeEntity commandeEntity) {
            return commandeReposotory.save(commandeEntity);
    }

    @Override
    public CommandeEntity getCommandeByOrderId(Long orderId) {
        return commandeReposotory.findByOrderId(orderId);
    }

    @Override
    public CommandeEntity updateCommande(Long orderId, CommandeEntity commandeEntity) {

        commandeEntity.setOrderId(orderId);
        return commandeReposotory.save(commandeEntity);
    }
     //categoriesEntity.setIdCat(id);
       // return  categoriesReposotory.save(categoriesEntity);
    @Override
    public void deleteCommande(Long orderId) {
        try {
            CommandeEntity commandeEntity=commandeReposotory.findByOrderId(orderId);
            commandeReposotory.delete(commandeEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<CommandeEntity> getCommande() {
        return null;
    }




    }


