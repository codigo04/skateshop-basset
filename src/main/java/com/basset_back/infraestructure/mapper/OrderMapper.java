package com.basset_back.infraestructure.mapper;



import com.basset_back.dominio.aggretes.dto.Order;
import com.basset_back.infraestructure.entity.Orden;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "idOrden",target = "idOrder"),
            @Mapping(source = "idUsuario",target = "idUser"),
            @Mapping(source = "precioTotal",target = "totalPrice"),
            @Mapping(source = "estado",target = "estate"),
            @Mapping(source = "fechaCreacion",target = "dateCreation"),
            @Mapping(source = "usuario",target = "user"),
            @Mapping(source = "itemsOrdens",target = "itemsOrders")


    })


    Order toOrder(Orden orden);
    List<Order> toOrders(List<Orden> ordens);

    @InheritInverseConfiguration
    Orden toOrden(Order order);

}
