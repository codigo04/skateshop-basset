package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;




public interface CarritoDao extends JpaRepository<Carrito,Long> {



}
