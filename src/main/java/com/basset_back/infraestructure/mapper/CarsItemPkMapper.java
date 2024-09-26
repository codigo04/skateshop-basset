package com.basset_back.infraestructure.mapper;


import com.basset_back.dominio.aggretes.dto.CarsItemPK;
import com.basset_back.infraestructure.entity.CarritosItemPK;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarsItemPkMapper {

    @Mapping(source = "idCarrito", target = "idCar")
    @Mapping(source = "idProducto", target = "idProduct")
    CarsItemPK toCarsItemPk(CarritosItemPK carritosItemPK);

    @InheritInverseConfiguration
    CarritosItemPK toCarritosItemPk(CarsItemPK carsItemPK);

}
