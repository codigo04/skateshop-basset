package com.basset_back.infraestructure.adapters;

import com.basset_back.dominio.aggretes.Enum.Pagos;
import com.basset_back.dominio.aggretes.dto.Paymet;
import com.basset_back.dominio.ports.out.PaymetServOut;
import com.basset_back.infraestructure.dao.PagoDao;
import com.basset_back.infraestructure.entity.Pago;
import com.basset_back.infraestructure.mapper.PaymetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PaymetAdapter implements PaymetServOut {

    @Autowired
    PaymetMapper paymetMapper;

    @Autowired
    PagoDao pagoDao;


    @Override
    public Paymet registerPaymetUser(Paymet paymet) {

        Pago pago = pagoDao.save(paymetMapper.toPago(paymet));


        return paymetMapper.toPaymet(pago);
    }

    @Override
    public Paymet updatePagoUser(Paymet paymet) {

        Optional<Pago> pagoExist = pagoDao.findById(paymet.getIdPaymet());

        if(pagoExist.isPresent()){
            Pago newPago = pagoExist.get();

            newPago.setEstado(Pagos.COMPLETADO.name());

        }



        return null;
    }
}
