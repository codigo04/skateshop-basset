package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.dto.Category;
import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.dominio.ports.in.CategoryServIn;
import com.basset_back.dominio.ports.out.CategoryServOut;
import com.basset_back.dominio.ports.out.ProductServOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorySerImpl implements CategoryServIn {


    @Autowired
    CategoryServOut categoryServOut;
    @Autowired
    ProductServOut productServOut;



    @Override
    public Optional<Category> createCategory(Category category) {

        return categoryServOut.createCategory(category);
    }

    @Override
    public Optional<Category> updateCategoryByName(Category category) {

        return categoryServOut.updateCategoryByName(category);
    }

    @Override
    public void deleteCategoryByName(String nameCategory) {

        Optional<List<Product>> productosExistentes = productServOut.searchProductByCategory(nameCategory);

        if (!productosExistentes.isPresent()) return;

        productosExistentes.get().forEach(product -> productServOut.updateCategoriProductDefault(product.getProductId()));

        categoryServOut.deleteCategoryByName(nameCategory);

    }


    @Override
    public Optional<Category> searchCategoryByName(String nameCategory) {
        Optional<Category> category = categoryServOut.searchCategoryByName(nameCategory);
        if (category.isPresent()) return category;

        return Optional.empty();
    }
}
