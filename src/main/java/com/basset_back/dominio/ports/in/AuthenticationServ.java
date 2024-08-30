package com.basset_back.dominio.ports.in;

import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.aggretes.request.SingInRequest;
import com.basset_back.dominio.aggretes.request.SingUpRequest;
import com.basset_back.dominio.aggretes.response.AuthenticationResponse;


public interface AuthenticationServ {
    User singUpUser(SingUpRequest singUpRequest);
    User singUpAdmin(SingUpRequest singUpRequest);
    AuthenticationResponse singnin(SingInRequest singInRequest);
}
