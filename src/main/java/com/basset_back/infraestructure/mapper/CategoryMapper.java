package com.basset_back.infraestructure.mapper;


import com.basset_back.dominio.aggretes.dto.Category;
import com.basset_back.infraestructure.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "descripcion", target = "description")
    })

    Category toCategory(Categoria categoria);
    List<Category> toCategories(List<Categoria> categorias);
    @InheritInverseConfiguration
    Categoria toCategoria(Category category);


}
