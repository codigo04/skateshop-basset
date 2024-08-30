package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.ports.in.UserServIn;
import com.basset_back.dominio.ports.out.UserServOut;
import com.basset_back.infraestructure.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServImpl implements UserServIn {


    @Autowired
    UserServOut userServOut;



    @Override
    public void deleteUser(String dniUser) {

        userServOut.deleteUser(dniUser);
    }



    @Override
    public Optional<User> updateUser(User user) {

        return Optional.of(userServOut.updateUser(user).get());
    }

    @Override
    public Optional<User> searchUserByNombre(String nombre) {

        return Optional.of(userServOut.searchUserByNombre(nombre).get());
    }

    @Override
    public Optional<User> searchUserByNumeroDoc(String documento) {
        return Optional.of(userServOut.searchUserByNumeroDoc(documento).get());
    }
}
