package Tienda_MarianaUlateCampos.demo.dao;

import Tienda_MarianaUlateCampos.demo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    Usuario findByUsername(String username);
}
