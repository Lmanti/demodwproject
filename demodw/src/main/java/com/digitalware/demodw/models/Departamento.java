package com.digitalware.demodw.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Departamento")
@Table(name = "\"Departamentos\"", schema = "public")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_departamento", insertable = false, updatable = false)
    private int codigo_departamento;
    
    @Column(name="descripcion_departamento", nullable = false)
    private String descripcion_departamento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
    private List<Ciudad> ciudades;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo_departamento_reside_cliente")
    private List<Cliente> clientes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo_departamento")
    private List<Encabezado_Factura> facturas;
    
//    Getters & Setters

    public List<Encabezado_Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Encabezado_Factura> facturas) {
        this.facturas = facturas;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getDescripcion_departamento() {
        return descripcion_departamento;
    }

    public void setDescripcion_departamento(String descripcion_departamento) {
        this.descripcion_departamento = descripcion_departamento;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
}
