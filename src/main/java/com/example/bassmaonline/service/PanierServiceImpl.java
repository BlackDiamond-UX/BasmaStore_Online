package com.example.bassmaonline.service;

import com.example.bassmaonline.Reposotory.PanierReposotory;
import com.example.bassmaonline.entity.PanierEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanierServiceImpl implements PanierService{

    @Autowired
    PanierReposotory panierReposotory;
    @Override
    public PanierEntity createPanier(PanierEntity panierEntity) {
        return panierReposotory.save(panierEntity);
    }

    @Override
    public PanierEntity getPanierById(Long id) {
        return panierReposotory.findByIdpanier(id);
    }

    @Override
    public PanierEntity updatePanier(Long id, PanierEntity panierEntity) {
        panierEntity.setIdpanier(id);
        return panierReposotory.save(panierEntity);
    }

    @Override
    public void deletePanier(Long id) {


        try {

            PanierEntity panierEntity=panierReposotory.findByIdpanier(id);
            panierReposotory.delete(panierEntity);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<PanierEntity> getAllPanier() {
        return panierReposotory.findAll();
    }
}
