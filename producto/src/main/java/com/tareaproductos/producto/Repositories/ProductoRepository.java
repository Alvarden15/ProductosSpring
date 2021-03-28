package com.tareaproductos.producto.Repositories;

import com.tareaproductos.producto.Models.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer> {
    
}
