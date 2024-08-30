package com.basset_back.infraestructure.adapters;

import com.basset_back.dominio.ports.out.CarServOut;
import com.basset_back.infraestructure.dao.CarritoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarAdapter implements CarServOut {



    @Autowired
    CarritoDao carritoDao;







}
