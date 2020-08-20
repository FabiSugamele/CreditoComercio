package br.com.credito.comercio.api.controllers;

import br.com.credito.comercio.api.dtos.LoginDto;
import br.com.credito.comercio.api.dtos.UsuarioDto;
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
@RequestMapping("/login")
@CrossOrigin(origins = "*")
@NoArgsConstructor
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Response<LoginDto>> login (@Valid @RequestBody LoginDto loginDto,
                                                     BindingResult result) throws NoSuchAlgorithmException {
        log.info("Iniciando o login do usuário {}", loginDto);

        Response<LoginDto> response = new Response<>();
        Usuario usuario = this.convertDtoParaUsuario(loginDto);

        if(!logar(loginDto, result)) {
            log.error("Erro de login", result.getAllErrors());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        log.info("Usuário logado com sucesso {}", loginDto);
        response.setData(this.convertUsuarioToDto(usuario));
        return ResponseEntity.ok(response);

    }

    private boolean logar(LoginDto loginDto, BindingResult result) {
        return this.usuarioService.findByEmail(loginDto.getEmail()).isPresent();
    }

    private Usuario convertDtoParaUsuario(LoginDto loginDto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(loginDto.getEmail());

        return usuario;
    }

    private LoginDto convertUsuarioToDto(Usuario usuario) {
        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(usuario.getEmail());

        return loginDto;
    }
}
