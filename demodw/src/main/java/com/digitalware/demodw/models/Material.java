package com.digitalware.demodw.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Material")
@Table(name = "\"Materiales\"", schema = "public")
public class Material implements Serializable {
    
    
//    Columnas
    @Id
    @Column(name = "codigo_material", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("codigo_material")
    private int codigo_material;
    
    @Column(name = "descripcion_material", nullable = false)
    @JsonProperty("descripcion_material")
    private String descripcion_material;
    
    @Column(name = "precio_material", nullable = false)
    @JsonProperty("precio_material")
    private double precio_material;
    
    @JsonManagedReference("material")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "material")
    private List<Detalle_Producto> lista_material;
    
//    Constructor
    
    public Material() {
        
    }

    public Material(String descripcion_material, double precio_material) {
        this.descripcion_material = descripcion_material;
        this.precio_material = precio_material;
    }
    
//    Getters & Setters

    public List<Detalle_Producto> getLista_material() {
        return lista_material;
    }

    public void setLista_material(List<Detalle_Producto> lista_material) {
        this.lista_material = lista_material;
    }

    public int getCodigo_material() {
        return codigo_material;
    }

    public void setCodigo_material(int codigo_material) {
        this.codigo_material = codigo_material;
    }

    public String getDescripcion_material() {
        return descripcion_material;
    }

    public void setDescripcion_material(String descripcion) {
        this.descripcion_material = descripcion;
    }

    public double getPrecio_material() {
        return precio_material;
    }

    public void setPrecio_material(double precio) {
        this.precio_material = precio;
    }
    
}
