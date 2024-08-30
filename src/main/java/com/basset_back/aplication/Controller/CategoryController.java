package com.basset_back.aplication.Controller;


import com.basset_back.dominio.ports.in.CategoryServIn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    CategoryServIn categoryServIn;
}
