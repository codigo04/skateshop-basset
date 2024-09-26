package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.ports.in.UserServIn;
import com.basset_back.dominio.ports.out.UserServOut;
import com.basset_back.infraestructure.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServImpl implements UserServIn {


    @Autowired
    UserServOut userServOut;


    @Override
    public List<User> searchUsers() {
        return userServOut.searchUsers();
    }

    @Override
    public Optional<User> createUser(User user) {
        return userServOut.createUser(user);
    }

    @Override
    public void deleteUser(String dniUser) {

        userServOut.deleteUser(dniUser);
    }



    @Override
    public Optional<User> updateUser(long numDoc,User user) {

        return Optional.of(userServOut.updateUser(numDoc,user).get());
    }

    @Override
    public Optional<User> searchUserByNombre(String nombre) {
        Optional<User> user =   userServOut.searchUserByNombre(nombre);

        return user;
    }

    @Override
    public Optional<User> searchUserByNumeroDoc(String documento) {
        return Optional.of(userServOut.searchUserByNumeroDoc(documento).get());
    }
}
