package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioDao extends CrudRepository<Usuario,Long> {

    Optional<Usuario> findByNombre(String nombre);
    Optional<Usuario> findByNumeroDoc(String documento);
    void deleteByNumeroDoc(String documento);  //falta implementar
    boolean existsByNumeroDoc(String documento); //falta implementar
}
