package com.basset_back.aplication.Controller;


import com.basset_back.dominio.aggretes.dto.Category;
import com.basset_back.dominio.ports.in.CategoryServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    CategoryServIn categoryServIn;


    @PostMapping("/categori/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Optional<Category> createdCategory = categoryServIn.createCategory(category);

        if (createdCategory.isPresent()) {
            return new ResponseEntity<>(createdCategory.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/categori/update")
    public ResponseEntity<Category> updateCategoryByName(@RequestBody Category category) {
        Optional<Category> updateCategoryByName = categoryServIn.updateCategoryByName(category);

        if (updateCategoryByName.isPresent()) {
            return ResponseEntity.ok(updateCategoryByName.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }


    @DeleteMapping("/categori/delete/{nameCategory}")
    public void deleteCategoryByName(@PathVariable("nameCategory") String nameCategory) {
        categoryServIn.deleteCategoryByName(nameCategory);

    }
}
