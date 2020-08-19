package br.com.credito.comercio.api.repositories;

import br.com.credito.comercio.api.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface VoucherRepository extends JpaRepository<Voucher, Integer> {
    @Transactional(readOnly = true)
    Voucher findByEmpresaId(int empresaId);
}
