package com.basset_back.dominio.ports.out;

import com.basset_back.dominio.aggretes.dto.Category;

import java.util.Optional;

public interface CategoryServOut {

    Optional<Category> createCategory(Category category);

    Optional<Category> updateCategoryByName(Category category);

    void deleteCategoryByName(String nameCategory);

    Optional<Category> searchCategoryByName(String nameCategory);

}
