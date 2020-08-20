package br.com.credito.comercio.api.services;

import br.com.credito.comercio.api.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {

    /**
     * Save the usuario
     * @param usuario
     * @return Usuario
     */
    Usuario save(Usuario usuario);

    /**
     * @paran nome
     * @return Usuario
     */
    Optional<Usuario> findByEmail(String email);

    /**
     * @param id
     * @return Optional<Usuario>
     */
    Usuario findById(int id);

}
