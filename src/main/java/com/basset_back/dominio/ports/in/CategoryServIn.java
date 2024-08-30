package com.basset_back.dominio.ports.in;

import com.basset_back.dominio.aggretes.dto.Category;

import java.util.Optional;

public interface CategoryServIn {

    Optional<Category> createCategory(Category category);

    Optional<Category> updateCategoryByName(Category category);

    void deleteCategoryByName(String nameCategory);

    Optional<Category> searchCategoryByName(String nameCategory);
}
