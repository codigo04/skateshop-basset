package com.basset_back.dominio.ports.in;

import com.basset_back.dominio.aggretes.dto.Paymet;

public interface PaymetServIn {

    Paymet registerPaymetUser();
    Paymet updatePagoUser();
}
