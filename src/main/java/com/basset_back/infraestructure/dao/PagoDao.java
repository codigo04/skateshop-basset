package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Pago;
import org.springframework.data.repository.CrudRepository;

public interface PagoDao extends CrudRepository<Pago,Long> {
}
