package com.example.bassmaonline.service;

import com.example.bassmaonline.entity.PicturesEntity;

import java.util.List;

public interface PicturesService {

    PicturesEntity createPictures(PicturesEntity picturesEntity);
    PicturesEntity getPictures(Long id);
    PicturesEntity updatePictures(Long id,PicturesEntity picturesEntity);
    void deletePictures(Long id);
    List<PicturesEntity> getAllPictures();

}
