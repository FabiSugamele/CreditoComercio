package br.com.credito.comercio.api.controllers;

import br.com.credito.comercio.api.dtos.EmpresaDto;
import br.com.credito.comercio.api.entities.Empresa;
import br.com.credito.comercio.api.response.Response;
import br.com.credito.comercio.api.services.EmpresaService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/pj")
@CrossOrigin(origins = "*")
@NoArgsConstructor
public class EmpresaController {

    private static final Logger log = LoggerFactory.getLogger(EmpresaController.class);

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Response<EmpresaDto>> cadastro (@Valid @RequestBody EmpresaDto empresaDto,
                                                          BindingResult result) throws NoSuchAlgorithmException {
        log.info("Iniciando cadastro da empresa {}", empresaDto);
        Response<EmpresaDto> response = new Response<>();
        checaSeEmpresaExiste(empresaDto, result);
        Empresa empresa = this.convertDtoParaEmpresa(empresaDto);

        if(result.hasErrors()) {
            log.error("Erro ao validar dados de cadastro PJ {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        this.empresaService.save(empresa);
        response.setData(this.convertEmpresaToDto(empresa));
        return ResponseEntity.ok(response);
    }

    private void checaSeEmpresaExiste(EmpresaDto empresaDto, BindingResult result) {
        this.empresaService.findByCnpj(empresaDto.getCnpj())
                .ifPresent(empresa -> result.addError(new ObjectError("empresa", "Empresa já existe")));
    }

    private Empresa convertDtoParaEmpresa(EmpresaDto empresaDto) {
        Empresa empresa = new Empresa();
        empresa.setCnpj(empresaDto.getCnpj());
        empresa.setNome(empresaDto.getNome());

        return empresa;

    }

    private EmpresaDto convertEmpresaToDto(Empresa empresa) {
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setCnpj(empresa.getCnpj());
        empresaDto.setNome(empresa.getNome());
        empresaDto.setId(empresa.getId());

        return empresaDto;

    }
}
