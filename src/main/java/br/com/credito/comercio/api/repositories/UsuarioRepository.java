package br.com.credito.comercio.api.repositories;


import br.com.credito.comercio.api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Transactional(readOnly = true)
    Usuario findByEmail(String email);

    @Transactional(readOnly = true)
    Usuario findById(int id);

}
