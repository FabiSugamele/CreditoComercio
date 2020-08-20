package br.com.credito.comercio.api.services.impl;


import br.com.credito.comercio.api.entities.Empresa;
import br.com.credito.comercio.api.repositories.EmpresaRepository;
import br.com.credito.comercio.api.services.EmpresaService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@NoArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {
    private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Optional<Empresa> findByCnpj(String cnpj) {
        log.info("findByCnpj cnpj{}", cnpj);
        return Optional.ofNullable(this.empresaRepository.findByCnpj(cnpj));
    }

    @Override
    public Empresa findById(int id) {
        log.info("Find by id: {}", id);
        return this.empresaRepository.findById(id);
    }

    @Override
    public Empresa save (Empresa empresa) {
        log.info("Salvando a empresa{}", empresa);
        return this.empresaRepository.save(empresa);
    }
}
