package com.basset_back.dominio.ports.in;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.infraestructure.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UserServIn {

    List<User> searchUsers();
    Optional<User> createUser(User user);
    void deleteUser(String dniUser);
    Optional<User> updateUser(long numDoc,User user);


    Optional<User> searchUserByNombre(String nombre);
    Optional<User> searchUserByNumeroDoc(String documento);
}
