package com.example.bassmaonline.service;

import com.example.bassmaonline.entity.CategoriesEntity;

import java.util.List;

public interface CategoriesService {

    CategoriesEntity createCategories(CategoriesEntity categoriesEntity);
    CategoriesEntity getCategoriesById(Long id);
    CategoriesEntity updateCategories(Long id,CategoriesEntity categoriesEntity);
    void deleCategories(Long id);
    List<CategoriesEntity> getCategories();
}
