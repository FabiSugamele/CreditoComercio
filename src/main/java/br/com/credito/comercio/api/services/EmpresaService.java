package br.com.credito.comercio.api.services;

import br.com.credito.comercio.api.entities.Empresa;

import java.util.Optional;

public interface EmpresaService {

    /**
    * Return the empresa by cnpj
     * @paran cnpj
     * @return Optionial<empresa>
     */
    Optional<Empresa> findByCnpj(String cnpj);

    /**
     *
     * @param id
     * @return Optional<Empresa>
     */
    Empresa findById(int id);

    /**
     * Save the empresa in database
     * @param empresa
     * @return empresa
     */

    Empresa save(Empresa empresa);
}
