package br.com.credito.comercio.api.services;

import br.com.credito.comercio.api.entities.Empresa;
import net.bytebuddy.asm.Advice;

import java.util.Optional;

public interface EmpresaService {

    /**
    * Return the empresa by cnpj
     * @paran cnpj
     * @return Optionial<empresa>
     */
    Optional<Empresa> findByCnpj(String cnpj);
    /**
     * Save the empresa in database
     * @param empresa
     * @return empresa
     */

    Empresa save(Empresa empresa);
}
