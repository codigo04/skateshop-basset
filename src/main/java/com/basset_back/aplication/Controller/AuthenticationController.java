package com.basset_back.aplication.Controller;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.aggretes.request.SingInRequest;
import com.basset_back.dominio.aggretes.request.SingUpRequest;
import com.basset_back.dominio.impl.AuthenticationServImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthenticationController {


    @Autowired
    AuthenticationServImpl authenticationServ;

    @PostMapping("/create/user")
    public ResponseEntity<User> singUpUser(@RequestBody SingUpRequest singUpRequest){
        return   ResponseEntity.ok(authenticationServ.singUpUser(singUpRequest));
    }

    @PostMapping("/create/admin")
    public ResponseEntity<User>  singUpAdmin(@RequestBody SingUpRequest singUpRequest){
        return   ResponseEntity.ok(authenticationServ.singUpAdmin(singUpRequest));
    }



}
