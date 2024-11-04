package com.basset_back.aplication.Controller;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.aggretes.request.SingUpRequest;
import com.basset_back.dominio.ports.in.UserServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;


@RequestMapping("/api/v1/usuarios")
@RestController
public class UserController {

    @Autowired
    UserServIn userServIn;


    @PostMapping("/update/user/{numDoc}")
    public void updateUser(@PathVariable("numDoc")long numDoc, @RequestBody  User user){

        userServIn.updateUser(numDoc,user);
    }


    @GetMapping("/search/users")
    public List<User> getUsers(){
        return userServIn.searchUsers();
    }


    @GetMapping("/search/user/{nameUser}")
    public User getUser(@PathVariable String nameUser) throws UserPrincipalNotFoundException {
        Optional<User> optionalUser = userServIn.searchUserByNombre(nameUser);

        return optionalUser.orElseThrow(() -> new UserPrincipalNotFoundException("Usuario no encontrado con el nombre: " + nameUser));
    }

    @GetMapping("/search/user/doc/{numDoc}")
    public ResponseEntity<User> getUserByNumDoc(@PathVariable("numDoc") String numDoc){
          Optional<User> user = userServIn.searchUserByNumeroDoc(numDoc);

          if(user.isPresent()){
              return ResponseEntity.ok(user.get());
          }else {
              return ResponseEntity.notFound().build();
          }
    }


    


}


