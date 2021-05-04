package com.example.bassmaonline.Reposotory;

import com.example.bassmaonline.entity.PicturesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicturesReposotory  extends JpaRepository<PicturesEntity,Long> {
    PicturesEntity findByIdPict(Long id);
}
