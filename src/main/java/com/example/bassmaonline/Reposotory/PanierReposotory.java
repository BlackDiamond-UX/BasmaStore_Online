package com.example.bassmaonline.Reposotory;

import com.example.bassmaonline.entity.PanierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierReposotory extends JpaRepository<PanierEntity,Long> {
    PanierEntity findByIdpanier(Long id);
}
