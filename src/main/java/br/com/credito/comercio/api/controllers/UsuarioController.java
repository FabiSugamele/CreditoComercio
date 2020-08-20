package br.com.credito.comercio.api.controllers;

import br.com.credito.comercio.api.dtos.LoginDto;
import br.com.credito.comercio.api.dtos.UsuarioDto;
import br.com.credito.comercio.api.entities.Empresa;
import br.com.credito.comercio.api.entities.Usuario;
import br.com.credito.comercio.api.response.Response;
import br.com.credito.comercio.api.services.UsuarioService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/pf")
@CrossOrigin(origins = "*")
@NoArgsConstructor
public class UsuarioController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Response<UsuarioDto>> cadastro (@Valid @RequestBody UsuarioDto usuarioDto,
                                                          BindingResult result) throws NoSuchAlgorithmException {
        log.info("Iniciando cadastro da usuario {}", usuarioDto);
        Response<UsuarioDto> response = new Response<>();
        checaSeUsuarioExiste(usuarioDto, result);
        Usuario usuario = this.convertDtoParaUsuario(usuarioDto);

        if(result.hasErrors()) {
            log.error("Erro ao validar dados de cadastro PF {}", result.getAllErrors());
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        this.usuarioService.save(usuario);
        response.setData(this.convertUsuarioToDto(usuario));
        return ResponseEntity.ok(response);
    }


    private void checaSeUsuarioExiste(UsuarioDto usuarioDto, BindingResult result) {
        this.usuarioService.findByEmail(usuarioDto.getEmail())
                .ifPresent(empresa -> result.addError(new ObjectError("usuario", "Usuário já existe")));
    }

    private Usuario convertDtoParaUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setNome(usuarioDto.getNome());

        return usuario;

    }

    private UsuarioDto convertUsuarioToDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setId(usuario.getId());

        return usuarioDto;

    }
}
