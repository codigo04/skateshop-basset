package com.basset_back.infraestructure.dao;

import com.basset_back.infraestructure.entity.ItemsOrden;
import com.basset_back.infraestructure.entity.OrdenItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsOrdenDao extends JpaRepository<ItemsOrden, OrdenItemPK> {
}
