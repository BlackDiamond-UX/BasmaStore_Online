package com.example.bassmaonline.service;

import com.example.bassmaonline.Reposotory.PicturesReposotory;
import com.example.bassmaonline.entity.PicturesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicturesServiceImpl implements PicturesService{
    @Autowired
    PicturesReposotory picturesReposotory;
    @Override
    public PicturesEntity createPictures(PicturesEntity picturesEntity) {
        return picturesReposotory.save(picturesEntity);
    }

    @Override
    public PicturesEntity getPictures(Long id) {
        return picturesReposotory.findByIdPict(id);
    }

    @Override
    public PicturesEntity updatePictures(Long id, PicturesEntity picturesEntity) {
        picturesEntity.setIdPict(id);
        return picturesReposotory.save(picturesEntity);
    }

    @Override
    public void deletePictures(Long id) {

        try {
            PicturesEntity picturesEntity=picturesReposotory.findByIdPict(id);
            picturesReposotory.delete(picturesEntity);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<PicturesEntity> getAllPictures() {
        return picturesReposotory.findAll();
    }
}
