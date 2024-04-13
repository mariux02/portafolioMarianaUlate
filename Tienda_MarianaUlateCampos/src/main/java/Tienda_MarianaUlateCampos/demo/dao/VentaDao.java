package Tienda_MarianaUlateCampos.demo.dao;

import Tienda_MarianaUlateCampos.demo.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDao extends JpaRepository <Venta,Long> {
}
