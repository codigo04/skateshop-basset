package com.basset_back.aplication.Controller;

import com.basset_back.dominio.aggretes.request.SingUpRequest;
import com.basset_back.dominio.ports.in.UserServIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/usuarios")
@RestController
public class UserController {

    @Autowired
    UserServIn userServIn;

    @GetMapping("/inUp")
    public String createUsuario(@RequestBody SingUpRequest singUpRequest){

     return "hola cris";
    }

}
