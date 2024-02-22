/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tienda.service;

import tienda.domain.categoria;
import java.util.List;

public interface categoriaService {
    
    // Se obtiene un listado de categorias en un List
    
    // estoy dicieno que el service si o si tiene una lista de categorias, que viene de Dao que viene de la BD
    public List<categoria> getCategorias(boolean activos);
 
}
