package com.basset_back.dominio.impl;

import com.basset_back.dominio.aggretes.Enum.Roles;
import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.aggretes.request.SingInRequest;
import com.basset_back.dominio.aggretes.request.SingUpRequest;
import com.basset_back.dominio.aggretes.response.AuthenticationResponse;
import com.basset_back.dominio.ports.in.AuthenticationServ;
import com.basset_back.dominio.ports.out.UserServOut;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServImpl implements AuthenticationServ {

    @Autowired
    UserServOut userServOut;

    @Transactional
    @Override
    public User singUpUser(SingUpRequest singUpRequest) {
        return createAndSaveUser(singUpRequest, Roles.USER);
    }


    @Transactional
    @Override
    public User singUpAdmin(SingUpRequest singUpRequest) {
        return createAndSaveUser(singUpRequest, Roles.ADMIN);
    }

    @Override
    public AuthenticationResponse singnin(SingInRequest singInRequest) {
        //por imlementar
        return null;
    }


    private User createAndSaveUser(SingUpRequest singUpRequest, Roles role) {

        User user = new User.UserBuilder()
                .name(singUpRequest.getName())
                .lastname(singUpRequest.getLastName())
                .gmail(singUpRequest.getGmail())
                .password(singUpRequest.getPassword())
                .numberDoc(singUpRequest.getNumberDoc())
                .build();


        if (role.name().equals(Roles.ADMIN.name())) {
            return userServOut.createAmin(user).get();
        } else {
            return userServOut.createUser(user).get();
        }

    }


}
