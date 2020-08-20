package br.com.credito.comercio.api.controllers;

import br.com.credito.comercio.api.dtos.VoucherDto;
import br.com.credito.comercio.api.entities.Voucher;
import br.com.credito.comercio.api.response.Response;
import br.com.credito.comercio.api.services.EmpresaService;
import br.com.credito.comercio.api.services.UsuarioService;
import br.com.credito.comercio.api.services.VoucherService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/voucher")
@CrossOrigin(origins = "*")
@NoArgsConstructor
public class VoucherController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private VoucherService voucherService;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Response<VoucherDto>> voucher (@Valid @RequestBody VoucherDto voucherDto,
                                                         BindingResult result) throws NoSuchAlgorithmException {

        log.info("Iniciando a criação do voucher {}", voucherDto);
        Response<VoucherDto> response = new Response<>();
        Voucher voucher = this.convertDtoParaVoucher(voucherDto);

        voucherService.save(voucher);
        response.setData(this.convertVoucherToDto(voucher));
        return ResponseEntity.ok(response);
    }

    public Voucher convertDtoParaVoucher(VoucherDto voucherDto) {
        Voucher voucher = new Voucher();
        voucher.setEmpresa(this.empresaService.findById(voucherDto.getEmpresaId()));
        voucher.setUsuario(this.usuarioService.findById(voucherDto.getUsuarioId()));
        voucher.setValor(voucherDto.getValor());
        return voucher;
    }

    public VoucherDto convertVoucherToDto(Voucher voucher) {
        VoucherDto voucherDto = new VoucherDto();
        voucherDto.setEmpresa(voucher.getEmpresa().getNome());
        voucherDto.setCliente(voucher.getUsuario().getNome());
        voucherDto.setValor(voucher.getValor());
        voucherDto.setEmpresaId(voucher.getEmpresa().getId());
        voucherDto.setUsuarioId(voucher.getUsuario().getId());
        return voucherDto;
    }
}
