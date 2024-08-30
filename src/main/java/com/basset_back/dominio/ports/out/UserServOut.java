package com.basset_back.dominio.ports.out;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.infraestructure.entity.Usuario;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserServOut {


   Optional<User> createUser(User user);

   Optional<User> createAmin(User user);

   void deleteUser(String dniUser);
   Optional<User> updateUser(User user);

   Optional<User> searchUserByNombre(String nombre);
   Optional<User> searchUserByNumeroDoc(String documento);

}
