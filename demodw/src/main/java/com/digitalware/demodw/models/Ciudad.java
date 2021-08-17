package com.digitalware.demodw.models;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Ciudad")
@Table(name = "\"Ciudades\"", schema = "public")
public class Ciudad implements Serializable {
    
    // Columnas
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_ciudad", insertable = false, updatable = false)
    private int codigo_ciudad;
    
    @Column(name="descripcion_ciudad", nullable = false)
    private String descripcion_ciudad;
    
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "departamento", insertable = true, nullable = false, updatable = false)
    private Departamento departamento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo_ciudad_reside_cliente")
    private List<Cliente> clientes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo_ciudad")
    private List<Encabezado_Factura> facturas;
    
//    Getters & Setters

    public List<Encabezado_Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Encabezado_Factura> facturas) {
        this.facturas = facturas;
    }

    public int getCodigo_ciudad() {
        return codigo_ciudad;
    }

    public void setCodigo_ciudad(int codigo_ciudad) {
        this.codigo_ciudad = codigo_ciudad;
    }

    public String getDescripcion_ciudad() {
        return descripcion_ciudad;
    }

    public void setDescripcion_ciudad(String descripcion_ciudad) {
        this.descripcion_ciudad = descripcion_ciudad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
