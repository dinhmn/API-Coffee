package com.dev.Coffee.Implements;

import com.dev.Coffee.entities.CategoriesEntities;
import com.dev.Coffee.model.Categories;
import com.dev.Coffee.repository.CategoriesRepository;
import com.dev.Coffee.services.CategoriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import com.github.slugify.Slugify;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private final CategoriesRepository categoriesRepository;

    public CategoriesServiceImpl(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Categories createCategories(Categories categories) {
        CategoriesEntities categoriesEntities = new CategoriesEntities();

        categories.setCreated_date(new Date());
        categories.setSeo(new Slugify().slugify(categories.getTitle()));
        BeanUtils.copyProperties(categories, categoriesEntities);

        categoriesRepository.save(categoriesEntities);
        return categories;
    }

    @Override
    public List<Categories> getAllCategories() {
        List<CategoriesEntities> categoriesEntities = categoriesRepository.findAll();
        List<Categories> categories = categoriesEntities
                .stream()
                .map(cat -> new Categories(
                        cat.getId(),
                        cat.getCategoriesName(),
                        cat.getTitle(),
                        cat.getSeo(),
                        cat.getDescription(),
                        cat.getStatus(),
                        cat.getCreated_by(),
                        cat.getUpdated_by(),
                        cat.getCreated_date(),
                        cat.getUpdated_date(),
                        cat.getProductEntities()
                        )).collect(Collectors.toList());
        return categories;
    }

    @Override
    public boolean deleteCategories(Long id) {
        CategoriesEntities categoriesEntities = categoriesRepository.findById(id).get();
        categoriesRepository.delete(categoriesEntities);
        return true;
    }

    @Override
    public Categories getCategories(Long id) {
        CategoriesEntities categoriesEntities = categoriesRepository.findById(id).get();
        Categories categories = new Categories();
        BeanUtils.copyProperties(categoriesEntities, categories);
        return categories;
    }

    @Override
    public Categories updateCategories(Long id, Categories categories) {
        CategoriesEntities categoriesEntities =
                categoriesRepository.findById(id).get();
        categoriesEntities.setCategoriesName(categories.getCategoriesName());
        categoriesEntities.setDescription(categories.getDescription());
        categoriesEntities.setTitle(categories.getTitle());
        categoriesEntities.setSeo(categories.getSeo());
        categoriesEntities.setStatus(categories.getStatus());
        categoriesEntities.setUpdated_date(categories.getCreated_date());
        categoriesEntities.setCreated_date(new Date());

        categoriesRepository.save(categoriesEntities);
        return categories;
    }



}
