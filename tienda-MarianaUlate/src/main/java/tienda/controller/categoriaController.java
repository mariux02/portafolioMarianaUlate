/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.controller;

import tienda.service.categoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/categoria") //se usa al API (es para el mapeo de datos)
public class categoriaController {
    
    @Autowired
    private categoriaService categoriaService; //trae todas las tablas y todo lo que mapeamos

    @GetMapping("/listado")
    public String inicio(Model model) { //recibe un modelo de tipo modelo
        var categorias = categoriaService.getCategorias(false); //obtener datos de este objeto 
        //var= tipo de variable
        //se usa el false para recibir un parametro, se puede poner true pero normalmente se usa false
        model.addAttribute("categorias", categorias); //con "categorias" es el nombre que yo le estoy dando para usar en las listas
        model.addAttribute("totalCategorias", categorias.size()); //metodo basico de java que trae esa lista, son size le pedimos el tamaño de esa lista
        return "/categoria/listado";//para poder entrar ya a la vista
    }
}
