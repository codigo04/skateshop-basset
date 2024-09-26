package com.basset_back.infraestructure.mapper;

import com.basset_back.dominio.aggretes.dto.ItemsCar;
import com.basset_back.infraestructure.entity.ItemsCarrito;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CarsItemPkMapper.class})
public interface ItemsCarMaper {


    @Mapping(source = "idPk", target = "idPrimarykey")
    @Mapping(source = "cantidad", target = "amount")


    ItemsCar toItemsCar(ItemsCarrito itemsCarrito);


    @InheritInverseConfiguration
    ItemsCarrito  toItemsCarrito(ItemsCar itemsCar);

}
