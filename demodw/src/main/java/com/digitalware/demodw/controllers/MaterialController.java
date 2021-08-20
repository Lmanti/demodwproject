package com.digitalware.demodw.controllers;

import com.digitalware.demodw.models.Material;
import com.digitalware.demodw.services.MaterialService;
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
@RequestMapping(path="/material")
public class MaterialController {
    
    ObjectMapper mapper = new ObjectMapper();
    
    @Autowired
    private MaterialService materialService;
    
    @RequestMapping(value="/listMaterial", method = RequestMethod.GET)
    public List<Material> listMaterial(){
          return materialService.listarMaterial();
    }
    
    @RequestMapping(value="/listMaterial/{id}", method = RequestMethod.GET)
    public ResponseEntity<Material> buscarPorId(@PathVariable("id") int codigo_material) {
        return materialService.buscarPorId(codigo_material);
    }
    
    @RequestMapping(value="/saveMaterial", method = RequestMethod.POST)
    public Boolean saveMaterial(@RequestBody JsonNode node){
        Material material = mapper.convertValue(node, Material.class);
        return materialService.agregarMaterial(material);
    }
    
    @RequestMapping(value="/updateMaterial/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Material> updateMaterial(@PathVariable("id") int codigo_material, @RequestBody JsonNode node) {
        Material material = mapper.convertValue(node, Material.class);
        return materialService.modificarMaterial(codigo_material, material);
    }
    
    @RequestMapping(value="/deleteMaterial/{id}", method = RequestMethod.DELETE)
    public Boolean deleteMaterial(@PathVariable("id") int codigo_material) {
        return materialService.borrarMaterial(codigo_material);
    }
    
}
