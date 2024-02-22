/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.dao;

import tienda.domain.categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoriaDao extends JpaRepository <categoria,Long> {
    
}