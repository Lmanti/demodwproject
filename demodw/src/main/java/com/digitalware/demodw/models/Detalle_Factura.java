package com.digitalware.demodw.models;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Detalle_Factura")
@Table(name = "\"Detalle_Facturas\"", schema = "public")
public class Detalle_Factura implements Serializable {
    
    // Columnas
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
//    @JsonBackReference// Indico que es la referencia de retorno(evitando ciclo infinito)
    @JoinColumn(name = "consecutivo_item_factura", insertable = true, nullable = false, updatable = false)
    private Detalle_Factura consecutivo_item_factura;
    
    @ManyToOne
//    @JsonBackReference// Indico que es la referencia de retorno(evitando ciclo infinito)
    @JoinColumn(name = "codigo_producto_factura", insertable = true, nullable = false, updatable = false)
    private Producto codigo_producto_factura;
    
    @Column(name = "cantidad_producto_factura", insertable = true, updatable = true, nullable = false)
    private int cantidad_producto_factura;
    
    @Column(name = "valor_unitario_producto", updatable = false, insertable = false)
    private double valor_unitario_producto = codigo_producto_factura != null ? codigo_producto_factura.getPrecioUnitario() : 0.0;
    
    @Column(name = "valor_unitario_producto", updatable = false, insertable = false)
    private double total_producto_factura = valor_unitario_producto * cantidad_producto_factura;
    
    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Detalle_Factura getConsecutivo_item_factura() {
        return consecutivo_item_factura;
    }

    public void setConsecutivo_item_factura(Detalle_Factura consecutivo_item_factura) {
        this.consecutivo_item_factura = consecutivo_item_factura;
    }

    public Producto getCodigo_producto_factura() {
        return codigo_producto_factura;
    }

    public void setCodigo_producto_factura(Producto codigo_producto_factura) {
        this.codigo_producto_factura = codigo_producto_factura;
    }

    public int getCantidad_producto_factura() {
        return cantidad_producto_factura;
    }

    public void setCantidad_producto_factura(int cantidad_producto_factura) {
        this.cantidad_producto_factura = cantidad_producto_factura;
    }

    public double getValor_unitario_producto() {
        return valor_unitario_producto;
    }

    public void setValor_unitario_producto(double valor_unitario_producto) {
        this.valor_unitario_producto = valor_unitario_producto;
    }

    public double getTotal_producto_factura() {
        return total_producto_factura;
    }

    public void setTotal_producto_factura(double total_producto_factura) {
        this.total_producto_factura = total_producto_factura;
    }
    
    
}
