package br.com.credito.comercio.api.repositories;

import br.com.credito.comercio.api.entities.Empresa;
import br.com.credito.comercio.api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Transactional(readOnly = true)
    Usuario findByEmail(String email);
}
