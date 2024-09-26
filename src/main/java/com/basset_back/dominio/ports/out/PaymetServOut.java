package com.basset_back.dominio.ports.out;

import com.basset_back.dominio.aggretes.dto.Paymet;

public interface PaymetServOut {

    Paymet registerPaymetUser(Paymet paymet);
    Paymet updatePagoUser(Paymet paymet);
}
