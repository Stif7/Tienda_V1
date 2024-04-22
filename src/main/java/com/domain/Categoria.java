/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "Categoria")

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Categoria")
    private long idCategoria;
    private String descripcion;
    private String  rutaImagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="idcategoria", updatable=false)
    List<Producto>productos;
    

    public Categoria() {
    }

    public Categoria(long idCategoria, String descripcion, String rutaImagen) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
    }


}