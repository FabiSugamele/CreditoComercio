package br.com.credito.comercio.api.services;

import br.com.credito.comercio.api.entities.Empresa;
import br.com.credito.comercio.api.entities.Voucher;

public interface VoucherService {

    /**
     * Save the voucher
     * @param voucher
     * @return Voucher
     */
   Voucher save(Voucher voucher);

    /**
     * Find by Empresa
     */
    Voucher findByEmpresaId(int empresaId);

}
