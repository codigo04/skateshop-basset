package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CategoriaDao  extends CrudRepository<Categoria, Long> {
        Optional<Categoria>  findCategoriaByNombre(String nombre);
        void deleteByNombre(String nombre);


}
