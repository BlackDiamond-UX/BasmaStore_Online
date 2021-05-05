package com.example.bassmaonline.Reposotory;

import com.example.bassmaonline.entity.CommandeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public  interface CommandeReposotory extends JpaRepository<CommandeEntity, Long>  {
       CommandeEntity findByOrderId(Long orderId);


       @Query("SELECT r FROM CommandeEntity r WHERE r.adresse = :adresse ")
       List<CommandeEntity> getCommandeEntitiesByAdresse(@Param("adresse") String adresse);

}

