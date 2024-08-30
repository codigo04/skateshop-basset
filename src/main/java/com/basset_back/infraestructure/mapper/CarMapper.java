package com.basset_back.infraestructure.mapper;

import com.basset_back.dominio.aggretes.dto.Car;
import com.basset_back.infraestructure.entity.Carrito;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {


     @Mappings({
             @Mapping(source = "idCarrito",target = "idCar"),
             @Mapping(source = "idUsuario",target = "idUsur"),
             @Mapping(source = "fechaCreacion",target = "dateCreation"),
             @Mapping(source = "usuario",target = "user")
     })

    Car toCar(Carrito carrito);
    List<Car> toList(List<Carrito> carritoList);

    @InheritInverseConfiguration
    Carrito toCarrito(Car car);
}
