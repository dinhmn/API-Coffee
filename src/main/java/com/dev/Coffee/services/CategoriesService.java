package com.dev.Coffee.services;

import com.dev.Coffee.entities.CategoriesEntities;
import com.dev.Coffee.model.Categories;

import java.util.List;

public interface CategoriesService {
    Categories createCategories(Categories categories);

    List<Categories> getAllCategories();

    boolean deleteCategories(Long id);

    Categories getCategories(Long id);
    Categories updateCategories(Long id, Categories categories);
}
