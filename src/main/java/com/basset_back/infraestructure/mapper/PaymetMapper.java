package com.basset_back.infraestructure.mapper;

import com.basset_back.dominio.aggretes.dto.Paymet;
import com.basset_back.infraestructure.entity.Pago;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring",uses = {OrderMapper.class})
public interface PaymetMapper {




    @Mappings({
            @Mapping(source = "idPago",target = "idPaymet"),
            @Mapping(source = "idOrden",target = "idOrder"),
            @Mapping(source = "monto",target = "amount"),
            @Mapping(source = "fechaPago",target = "datePaymet"),
            @Mapping(source = "estado",target = "estate"),
            @Mapping(source = "metodoPago",target = "methodPaymet"),
            @Mapping(source = "orden",target = "order")
    })
    Paymet toPaymet(Pago pago);
    List<Paymet> toPaymets(List<Pago> pagos);


    @InheritInverseConfiguration
    Pago toPago(Paymet paymet);
}
