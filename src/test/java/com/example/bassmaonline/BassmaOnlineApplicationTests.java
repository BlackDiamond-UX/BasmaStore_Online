package com.example.bassmaonline;

import com.example.bassmaonline.Reposotory.CategoriesReposotory;
import com.example.bassmaonline.entity.CategoriesEntity;
import com.example.bassmaonline.service.CategoriesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BassmaOnlineApplicationTests {

    @Autowired
    CategoriesReposotory categoriesReposotory;

//    @Autowired
//    CategoriesReposotory categoriesReposotory1;

    @Autowired
    CategoriesService categoriesService;


    @Test
    public void SaveCategories()
    {

//        CategoriesEntity categoriesEntity=new CategoriesEntity("t-shirt","img");
//        when(categoriesReposotory.save(categoriesEntity)).thenReturn(categoriesEntity);
//        assertEquals(categoriesEntity,categoriesService.createCategories(categoriesEntity));

        CategoriesEntity categoriesEntity=new CategoriesEntity("t-shirt","img");
        categoriesService.createCategories(categoriesEntity);
//        assertEquals(true,categoriesService.createCategories(categoriesEntity));

    }


    @Test
    public void DeleteCategories()
    {

        categoriesService.deleCategories(Long.valueOf(9));
       assertEquals(null,  categoriesService.getCategoriesById(Long.valueOf(9)));






    }





}
