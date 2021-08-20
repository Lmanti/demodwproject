package com.digitalware.demodw.services;

import com.digitalware.demodw.models.Detalle_Producto;
import com.digitalware.demodw.models.Material;
import com.digitalware.demodw.models.Producto;
import com.digitalware.demodw.repositories.DetalleProductoRepository;
import com.digitalware.demodw.repositories.MaterialRepository;
import com.digitalware.demodw.repositories.ProductoRepository;
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
    
    public Boolean modificarProducto(int id , Producto info) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            Producto _producto = producto.get();
            _producto.setDescripcion_producto(info.getDescripcion_producto());
            _producto.setImpuesto_producto(info.getImpuesto_producto());
            _producto.setMateriales(info.getMateriales());
            productoRepository.save(_producto);
            for (Detalle_Producto object : _producto.getMateria_prima()) {
                detalle.deletesById(object.getId());
            }
            Optional<Producto> producto2 = productoRepository.findById(id);
            if (producto2.isPresent()) {
                Producto _producto2 = producto2.get();
                for (int x : _producto2.getMateriales()) {
                    Optional<Material> auxiliar2 = materialRepository.findById(x);
                    if (auxiliar2.isPresent()){
                        Material prueba2 = auxiliar2.get();
                        Detalle_Producto _detalle2 = new Detalle_Producto();
                        _detalle2.setProducto(_producto2);
                        _detalle2.setMaterial(prueba2);
                        _detalle2.setCantidad(10);
                        _detalle2.setTotal(_detalle2.getCantidad() * prueba2.getPrecio_material());
                        _detalle2.setIdProducto(_producto2.getCodigo_producto());
                        _detalle2.setIdMaterial(prueba2.getCodigo_material());
                        _detalle2.setNombreMaterial(prueba2.getDescripcion_material());
                        detalle.save(_detalle2);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean borrarProducto(int id) {
        try {
            Optional<Producto> producto = productoRepository.findById(id);
            if (producto.isPresent()) {
                Producto _producto = producto.get();
                for (Detalle_Producto object : _producto.getMateria_prima()) {
                    detalle.deletesById(object.getId());
                }
            }
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
