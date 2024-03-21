package Tienda_MarianaUlateCampos.demo.dao;

import Tienda_MarianaUlateCampos.demo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository <Categoria, Long>{
    
}

