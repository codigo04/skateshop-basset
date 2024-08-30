package com.basset_back.infraestructure.mapper;


import com.basset_back.dominio.aggretes.dto.Product;
import com.basset_back.infraestructure.entity.Producto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {


    @Mappings({
            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "descripcion",target = "description"),
            @Mapping(source = "precio",target = "price"),
            @Mapping(source = "stock",target = "stock"),
            @Mapping(source = "categoriaId",target = "categoryId"),
            @Mapping(source = "imagenUrl",target = "imgUrl"),
            @Mapping(source = "fechaCreacion",target = "dateCreation"),
            @Mapping(source = "categoria",target = "category")
    })


    Product toProduct(Producto producto);
    List<Product> toProductList(List<Producto> productos);

    @InheritInverseConfiguration
    Producto toProducto(Product product);

}
