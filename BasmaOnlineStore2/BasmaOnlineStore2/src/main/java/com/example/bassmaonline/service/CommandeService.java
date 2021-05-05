package com.example.bassmaonline.service;

import com.example.bassmaonline.entity.CategoriesEntity;
import com.example.bassmaonline.entity.CommandeEntity;

import java.util.List;

public interface CommandeService {


  CommandeEntity createCommande(CommandeEntity commandeEntity);

  CommandeEntity getCommandeByOrderId(Long orderId);

  CommandeEntity updateCommande(Long orderId, CommandeEntity commandeEntity);

  void deleteCommande(Long orderId);

  List<CommandeEntity> getCommande();

}











