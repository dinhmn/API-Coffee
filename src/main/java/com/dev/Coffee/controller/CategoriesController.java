package com.dev.Coffee.controller;

import com.dev.Coffee.model.Categories;
import com.dev.Coffee.services.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class CategoriesController {

    @Autowired
    private final CategoriesService categoriesService;


    @PostMapping("/category")
    public Categories createCategory(@RequestBody Categories categories){
        return  categoriesService.createCategories(categories);
    }

    @GetMapping("/category")
    public List<Categories> getAllCategory() {
        return categoriesService.getAllCategories();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Long id){
        boolean deleted = false;
        deleted = categoriesService.deleteCategories(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Categories> getCategoriesById(@PathVariable Long id){
        Categories categories = null;
        categories = categoriesService.getCategories(id);

        return ResponseEntity.ok(categories);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Categories> updateCategoriesById(@PathVariable Long id, @RequestBody Categories categories){
        categories = categoriesService.updateCategories(id, categories);

        return ResponseEntity.ok(categories);
    }

}
