package com.basset_back.infraestructure.mapper;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.infraestructure.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings({
            @Mapping(source = "idUsuario",target = "userId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellido",target = "lastname"),
            @Mapping(source = "gmail",target = "gmail"),
            @Mapping(source = "contrasena",target = "password"),
            @Mapping(source = "tipoDoc",target = "typeDoc"),
            @Mapping(source = "numeroDoc",target = "numberDoc")
    })
    User toUser(Usuario usuario);
    List<User> toUser(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);
}
