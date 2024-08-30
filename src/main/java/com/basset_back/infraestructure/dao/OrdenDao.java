package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Orden;
import org.springframework.data.repository.CrudRepository;

public interface OrdenDao  extends CrudRepository<Orden,Long> {

}
