package br.com.credito.comercio.api.repositories;

import br.com.credito.comercio.api.entities.Empresa;
import br.com.credito.comercio.api.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    @Transactional(readOnly = true)
    Voucher findByEmpresaId(int empresaId);
}
