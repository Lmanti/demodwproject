package com.digitalware.demodw.service;

import com.digitalware.demodw.models.Material;
import com.digitalware.demodw.repository.MaterialRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
    
    @Autowired
    private MaterialRepository materialRepository;
    
    public List<Material> listarMaterial() {
        return materialRepository.findAll();
    }
    
    public ResponseEntity<Material> buscarPorId(int id) {
        Optional<Material> material = materialRepository.findById(id);
        if (material.isPresent()) {
            return new ResponseEntity<>(material.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    public Boolean agregarMaterial(Material material) {
        try {
            materialRepository.save(material);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
    public ResponseEntity<Material> modificarMaterial(int id , Material info) {
        Optional<Material> material = materialRepository.findById(id);
        if (material.isPresent()) {
            Material _material = material.get();
            _material.setDescripcion_material(info.getDescripcion_material());
            _material.setPrecio_material(info.getPrecio_material());
            return new ResponseEntity<>(materialRepository.save(_material), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    public Boolean borrarMaterial(int id) {
        try {
            materialRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
