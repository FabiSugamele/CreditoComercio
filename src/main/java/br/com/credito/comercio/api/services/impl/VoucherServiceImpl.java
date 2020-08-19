package br.com.credito.comercio.api.services.impl;

import br.com.credito.comercio.api.entities.Empresa;
import br.com.credito.comercio.api.entities.Voucher;
import br.com.credito.comercio.api.repositories.UsuarioRepository;
import br.com.credito.comercio.api.repositories.VoucherRepository;
import br.com.credito.comercio.api.services.VoucherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {

    private static final Logger log = LoggerFactory.getLogger(VoucherServiceImpl.class);

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public Voucher save(Voucher voucher) {
        log.info("Voucher salvo{}", voucher);
        return this.voucherRepository.save(voucher);
    }

    @Override
    public Voucher findByEmpresaId(int empresaId) {
        return findByEmpresaId(empresaId);
    }
}
