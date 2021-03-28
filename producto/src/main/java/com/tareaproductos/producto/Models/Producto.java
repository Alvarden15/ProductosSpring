package com.tareaproductos.producto.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int Id;

    private String Nombre;

    private double Precio;

    public Producto(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public Producto(int id, String nombre, double precio) {
        Id = id;
        Nombre = nombre;
        Precio = precio;
    }

}
