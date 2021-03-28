package com.tareaproductos.producto.Controllers;

import com.tareaproductos.producto.Repositories.ProductoRepository;
import com.tareaproductos.producto.Models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    
    @Autowired
    private ProductoRepository repository;

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Producto>> listaProducto(){
        List<Producto> productos = repository.findAll();
        return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}",produces = {"application/json"})
    public ResponseEntity<Producto> obtenerProducto(@PathVariable("id") int id){
        var producto = repository.findById(id);
        if(!producto.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Producto>(producto.get(),HttpStatus.OK);
    }

    @PostMapping(produces = {"application/json"})
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto product){
        var producto =repository.save(product);
        repository.flush();
        return new ResponseEntity<Producto>(producto,HttpStatus.OK);
    }

    @PutMapping(value = "/{id}",produces = {"application/json"})
    public ResponseEntity<Producto> actualizarProducto(
        @PathVariable("id") int id, 
        @RequestBody Producto product)
        {
        var producto =repository.findById(id);
        if(!producto.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        var modificado = producto.get();
        modificado.setNombre(product.getNombre());
        modificado.setPrecio(product.getPrecio());

        repository.save(modificado);
        return new ResponseEntity<Producto>(modificado,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}",produces = {"application/json"})
    public ResponseEntity<Producto> eliminarProducto(@PathVariable("id") int id){
        var producto =repository.findById(id);
        if(!producto.isPresent())
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        repository.deleteById(id);
        return new ResponseEntity<Producto>(producto.get(),HttpStatus.OK);
    }
}
