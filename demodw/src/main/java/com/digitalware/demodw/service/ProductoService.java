package com.digitalware.demodw.service;

import com.digitalware.demodw.models.Detalle_Producto;
import com.digitalware.demodw.models.Material;
import com.digitalware.demodw.models.Producto;
import com.digitalware.demodw.repository.DetalleProductoRepository;
import com.digitalware.demodw.repository.MaterialRepository;
import com.digitalware.demodw.repository.ProductoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private MaterialRepository materialRepository;
    
    @Autowired
    private DetalleProductoRepository detalle;
    
    public List<Producto> listarProducto() {
        try {
            return productoRepository.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
        
    }
    
    public ResponseEntity<Producto> buscarPorId(int id) {
        Optional<Producto> material = productoRepository.findById(id);
        if (material.isPresent()) {
            return new ResponseEntity<>(material.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    public Boolean agregarProducto(Producto producto) {
        try {
            productoRepository.save(producto);
            for (int i : producto.getMateriales()) {
                Optional<Material> auxiliar = materialRepository.findById(i);
                Material prueba = auxiliar.get();
                Detalle_Producto _detalle = new Detalle_Producto();
                _detalle.setProducto(producto);
                _detalle.setMaterial(prueba);
                _detalle.setCantidad(5);
                _detalle.setTotal(_detalle.getCantidad() * prueba.getPrecio_material());
                _detalle.setIdMaterial(prueba.getCodigo_material());
                _detalle.setIdProducto(producto.getCodigo_producto());
                _detalle.setNombreMaterial(prueba.getDescripcion_material());
                detalle.save(_detalle);
            }
            
            return true;
        }
        catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public ResponseEntity<Producto> modificarProducto(int id , Producto info) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto _producto = producto.get();
            _producto.setDescripcion_producto(info.getDescripcion_producto());
            _producto.setImpuesto_producto(info.getImpuesto_producto());
            _producto.setMateriales(info.getMateriales());
            productoRepository.save(_producto);
            return new ResponseEntity<>(productoRepository.save(_producto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    public Boolean borrarProducto(int id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
