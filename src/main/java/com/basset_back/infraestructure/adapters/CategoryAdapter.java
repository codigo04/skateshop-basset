package com.basset_back.infraestructure.adapters;

import com.basset_back.dominio.aggretes.dto.Category;
import com.basset_back.dominio.ports.out.CategoryServOut;
import com.basset_back.infraestructure.dao.CategoriaDao;
import com.basset_back.infraestructure.entity.Categoria;
import com.basset_back.infraestructure.mapper.CategoryMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryAdapter implements CategoryServOut {


    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    public Optional<Category> createCategory(Category category) {
            Categoria categoria = categoriaDao.save(categoryMapper.toCategoria(category));
        return Optional.of(categoryMapper.toCategory(categoria));
    }

    @Override
    public Optional<Category> updateCategoryByName(Category category) {
        Optional<Categoria>  categoryExist =  categoriaDao.findCategoriaByNombre(category.getName());
        if (categoryExist.isPresent()) {
            Categoria newCategory = categoryExist.get();
            newCategory.setNombre(category.getName());
            newCategory.setDescripcion(category.getDescription());

         return Optional.of(categoryMapper.toCategory(categoriaDao.save(newCategory)));
        }

        return Optional.empty();
    }


    @Transactional
    @Override
    public void deleteCategoryByName(String nameCategory) {

             if(searchCategoryByName(nameCategory).isPresent()){
                categoriaDao.deleteByNombre(nameCategory);
             }

    }

    @Override
    public Optional<Category> searchCategoryByName(String nameCategory) {
        Optional<Categoria> categoria =  categoriaDao.findCategoriaByNombre(nameCategory);

        if (!categoria.isPresent()) return Optional.empty();

        return Optional.of(categoryMapper.toCategory(categoria.get()));
    }
}
