package com.basset_back.infraestructure.mapper;

import com.basset_back.dominio.aggretes.dto.Role;
import com.basset_back.infraestructure.entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mappings({
            @Mapping(source ="idRol" ,target = "idRole"),
            @Mapping(source ="nombreRol" ,target = "nameRole")

    })
    Role toRole(Rol rol);

    @InheritInverseConfiguration
    Set<Rol> toRoles(Set<Role> roles);
}