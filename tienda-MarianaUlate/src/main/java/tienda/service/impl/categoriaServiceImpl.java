/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.service.impl;

/* services son para lógica */

//traemos una lista de cosas
import tienda.dao.categoriaDao;
import tienda.domain.categoria;
import tienda.service.categoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class categoriaServiceImpl implements categoriaService {
    
    //conecta directamente con la BD que se presenta con Dao
    @Autowired
    private categoriaDao categoriaDao;
    
    //se lee los datos de la BD (todavia no se escribe en la BD)
    @Override
    @Transactional(readOnly=true)
    public List<categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        //en la lista hay los objetos de la categoria
        return lista;
    }
}