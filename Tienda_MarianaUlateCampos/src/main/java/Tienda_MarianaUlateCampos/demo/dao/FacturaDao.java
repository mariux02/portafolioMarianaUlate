package Tienda_MarianaUlateCampos.demo.dao;

import Tienda_MarianaUlateCampos.demo.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long> {
}