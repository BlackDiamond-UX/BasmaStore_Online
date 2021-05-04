package com.example.bassmaonline.Reposotory;

import com.example.bassmaonline.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoriesReposotory extends JpaRepository<CategoriesEntity, Long> {
    CategoriesEntity findByIdCat(Long id);
}
