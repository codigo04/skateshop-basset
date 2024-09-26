package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.ItemsOrden;
import com.basset_back.infraestructure.entity.Orden;
import com.basset_back.infraestructure.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdenDao  extends CrudRepository<Orden,Long> {




}
