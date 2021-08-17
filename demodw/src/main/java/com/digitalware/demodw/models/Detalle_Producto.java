package com.digitalware.demodw.models;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name = "Detalle_Producto")
@Table(name = "\"Detalle_Productos\"", schema = "public")
public class Detalle_Producto implements Serializable {
    
//    Columnas
    @Id
    @Column(name = "id", insertable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "producto", insertable = true, nullable = false, updatable = true)
    @JsonBackReference("producto") // Indico que es la referencia de retorno(evitando ciclo infinito)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "material", insertable = true, nullable = false, updatable = true)
    @JsonBackReference("material")
    private Material material;
    
    @ManyToOne
//    @JsonBackReference// Indico que es la referencia de retorno(evitando ciclo infinito)
    @JoinColumn(name = "factura", insertable = true, updatable = false)
    private Detalle_Factura factura;
    
    @Column(name = "cantidad", insertable = true, nullable = false, updatable = false)
    private int cantidad;
    
    @Column(name = "total")
    private double total;
    
    @Column
    private int idProducto;
    
    @Column
    private int idMaterial;
    
    @Column
    private String nombreMaterial;
    
    
//    Constructor

    public Detalle_Producto() {
    }

    public Detalle_Producto(Producto producto, Material material, int cantidad) {
        this.producto = producto;
        this.material = material;
        this.cantidad = cantidad;
    }

//    Getters & Setters

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }
    
    public Detalle_Factura getFactura() {
        return factura;
    }

    public void setFactura(Detalle_Factura factura) {
        this.factura = factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    
}
