package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolDao extends JpaRepository<Rol,Long> {

    Optional<Rol> findByNombreRol(String rol);
}
