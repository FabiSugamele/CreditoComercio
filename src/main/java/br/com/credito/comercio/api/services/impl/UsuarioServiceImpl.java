package br.com.credito.comercio.api.services.impl;

import br.com.credito.comercio.api.entities.Usuario;
import br.com.credito.comercio.api.repositories.UsuarioRepository;
import br.com.credito.comercio.api.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        log.info("Salvando a usuario{}", usuario);
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        log.info("Find by email: {}", email);
        return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
    }
}
