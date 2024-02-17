package com.Tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data //SIGNIFICA QUE VAMOS A RECOLECTAR DATOS
@Entity  // UNA ENTIDAD, SIGINIFICA QUE VA TENER UNA TABLA RELACIONADA
@Table(name = "categoria")

public class Categoria implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.es el que realiza el AUTOINCREMENT

    @Id //id categoria es la llave de la tabla categoria.es algo que lo va identificar
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_categoria") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}