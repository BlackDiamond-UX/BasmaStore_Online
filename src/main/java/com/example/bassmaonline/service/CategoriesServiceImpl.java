package com.example.bassmaonline.service;

import com.example.bassmaonline.Reposotory.CategoriesReposotory;
import com.example.bassmaonline.entity.CategoriesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriesServiceImpl implements CategoriesService{


    @Autowired
    CategoriesReposotory categoriesReposotory;
    @Override
    public CategoriesEntity createCategories(CategoriesEntity categoriesEntity) {

        return  categoriesReposotory.save(categoriesEntity);

    }

    @Override
    public CategoriesEntity getCategoriesById(Long id) {
        return categoriesReposotory.findByIdCat(id);
    }

    @Override
    public CategoriesEntity updateCategories(Long id, CategoriesEntity categoriesEntity) {
        categoriesEntity.setIdCat(id);
        return  categoriesReposotory.save(categoriesEntity);
    }

    @Override
    public void deleCategories(Long id) {


        try {
            CategoriesEntity categoriesEntity=categoriesReposotory.findByIdCat(id);
            categoriesReposotory.delete(categoriesEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<CategoriesEntity> getCategories() {
        return categoriesReposotory.findAll();
    }
}
