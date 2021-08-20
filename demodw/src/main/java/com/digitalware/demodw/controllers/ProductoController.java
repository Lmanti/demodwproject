package com.digitalware.demodw.controllers;

import com.digitalware.demodw.models.Producto;
import com.digitalware.demodw.services.ProductoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/producto")
public class ProductoController {
    
    ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    private ProductoService productoService;
    
    @RequestMapping(value="/listProducto", method = RequestMethod.GET)
    public List<Producto> listMaterial(){
          return productoService.listarProducto();
    }
    
    @RequestMapping(value="/saveProducto", method = RequestMethod.POST)
    public Boolean saveProducto(@RequestBody JsonNode node){
        Producto producto = mapper.convertValue(node, Producto.class);
        return productoService.agregarProducto(producto);
    }
    
    @RequestMapping(value="/updateProducto/{id}", method = RequestMethod.PUT)
    public Boolean updateMaterial(@PathVariable("id") int codigo_producto, @RequestBody JsonNode node) {
        Producto producto = mapper.convertValue(node, Producto.class);
        return productoService.modificarProducto(codigo_producto, producto);
    }
    
    @RequestMapping(value="/deleteProducto/{id}", method = RequestMethod.DELETE)
    public Boolean deleteMaterial(@PathVariable("id") int codigo_producto) {
        return productoService.borrarProducto(codigo_producto);
    }
}
