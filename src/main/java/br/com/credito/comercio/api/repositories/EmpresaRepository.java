package br.com.credito.comercio.api.repositories;

import br.com.credito.comercio.api.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

    @Transactional(readOnly = true)
    Empresa findByCnpj(String cnpj);

    @Transactional(readOnly = true)
    Empresa findById(int id);
}
