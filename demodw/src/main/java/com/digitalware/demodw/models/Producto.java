package com.digitalware.demodw.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name = "Producto")
@Table(name = "\"Productos\"", schema = "public")
public class Producto implements Serializable {
    
//    Columnas
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codigo_producto", insertable = true, updatable = true)
    @JsonProperty("codigo_producto")
    private int codigo_producto;

    @Column(name="descripcion_producto", nullable=false)
    @JsonProperty("descripcion_producto")
    private String descripcion_producto;

    @Column(name = "fecha_creacion_producto", insertable = true, updatable = true)
    @JsonFormat(pattern = "dd/MM/YYYY")
    @JsonProperty("fecha_creacion_producto")
    private Date fecha_creacion_producto = new Date();

    @JsonProperty("impuesto_producto")
    @Column(name="impuesto_producto", nullable=false)
    private float impuesto_producto;
    
    @JsonManagedReference("producto")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Detalle_Producto> materia_prima;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo_producto_factura")
    private List<Detalle_Factura> lista_factura;
    
    @JsonProperty("materiales")
    private int[] materiales;
    
    
//    Constructor

    public Producto() {
    }

    public Producto(String descripcion_producto, float impuesto_producto) {
        this.descripcion_producto = descripcion_producto;
        this.impuesto_producto = impuesto_producto;
    }
    
//    Getters & Setters
    
    public void setMateriales(int[] materiales) {
        this.materiales = materiales;
    }
    
    public int[] getMateriales() {
        return materiales;
    }  
    
    public List<Detalle_Factura> getLista_factura() {
        return lista_factura;
    }
    
    public void setLista_factura(List<Detalle_Factura> lista_factura) {
        this.lista_factura = lista_factura;
    }

    public double getPrecioUnitario() {
        double acumulador = 0.0;
        for (Detalle_Producto detalle : materia_prima) {
            acumulador += detalle.getTotal();
        }
        return acumulador;
    }

    public List<Detalle_Producto> getMateria_prima() {
        return materia_prima;
    }

    public void setMateria_prima(List<Detalle_Producto> materia_prima) {
        this.materia_prima = materia_prima;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public Date getFecha_creacion_producto() {
        return fecha_creacion_producto;
    }

    public void setFecha_creacion_producto(Date fecha_creacion_producto) {
        this.fecha_creacion_producto = fecha_creacion_producto;
    }

    public float getImpuesto_producto() {
        return impuesto_producto;
    }

    public void setImpuesto_producto(float impuesto_producto) {
        this.impuesto_producto = impuesto_producto;
    }
}
