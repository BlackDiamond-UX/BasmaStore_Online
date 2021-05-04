package com.example.bassmaonline.service;

import com.example.bassmaonline.entity.PanierEntity;

import java.util.List;

public interface PanierService {

    PanierEntity createPanier(PanierEntity panierEntity);

    PanierEntity getPanierById(Long id);
    PanierEntity updatePanier(Long id,PanierEntity panierEntity);
    void deletePanier(Long id);
    List<PanierEntity> getAllPanier();

}
