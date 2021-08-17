package com.digitalware.demodw.models;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
//import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;

@Entity(name = "Encabezado_Factura")
@Table(name = "\"Encabezado_Facturas\"", schema = "public")
public class Encabezado_Factura implements Serializable {
    
    // Columnas
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_factura", insertable = false, updatable = false)
    private int numero_factura;
    
    @Column(name = "direccion_factura", nullable = false)
    private String direccion_factura;
    
    @Column(name = "telefono_factura", nullable = false)
    private String telefono_factura;
    
    private double total_factura; //FALTA POR MODIFICAR
    
    private enum tipo_factura { Operacional, No_operracional, Venta_directa };
//    private tipo_factura tipo_factura;
    
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "codigo_departamento", insertable = true, nullable = false, updatable = false)
    private Departamento codigo_departamento;
    
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "codigo_ciudad", insertable = true, nullable = false, updatable = false)
    private Ciudad codigo_ciudad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consecutivo_item_factura")
    private List<Detalle_Factura> detalles_factura;
    
    // Getter & Setters

    public List<Detalle_Factura> getDetalles_factura() {
        return detalles_factura;
    }

    public void setDetalles_factura(List<Detalle_Factura> detalles_factura) {
        this.detalles_factura = detalles_factura;
    }

    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String getDireccion_factura() {
        return direccion_factura;
    }

    public void setDireccion_factura(String direccion_factura) {
        this.direccion_factura = direccion_factura;
    }

    public String getTelefono_factura() {
        return telefono_factura;
    }

    public void setTelefono_factura(String telefono_factura) {
        this.telefono_factura = telefono_factura;
    }

    public double getTotal_factura() {
        return total_factura;
    }

    public void setTotal_factura(double total_factura) {
        this.total_factura = total_factura;
    }

    public Departamento getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(Departamento codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public Ciudad getCodigo_ciudad() {
        return codigo_ciudad;
    }

    public void setCodigo_ciudad(Ciudad codigo_ciudad) {
        this.codigo_ciudad = codigo_ciudad;
    }
    
    
}
