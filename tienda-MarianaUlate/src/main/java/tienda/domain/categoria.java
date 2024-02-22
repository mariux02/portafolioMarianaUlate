/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/* esto es para el mapeo de las tablas, se hace con cada una de ellas */

/* estas son nuestra entities */
@Data
@Entity
@Table(name="categoria")
public class categoria implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id /* primary key de la base de datos */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public categoria() { /* constructor de la base que está vacio */
    }

    public categoria(String categoria, boolean activo) { /* constructor lleno que devuelve description y activo */
        this.descripcion = categoria;
        this.activo = activo;
    }
}