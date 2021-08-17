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

@Entity(name = "Cliente")
@Table(name = "\"Clientes\"", schema = "public")
public class Cliente implements Serializable {
    
//    Columnas
    @Id
    @Column(name = "codigo_cliente", insertable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo_cliente;
    
    @Column(name = "numero_Identificacion_cliente", nullable = false)
    private long numero_Identificacion_cliente;
    
    @Column(name = "tipo_Identificacion_cliente", nullable = false)
    private String tipo_Identificacion_cliente;
    
    @Column(name = "nombre_cliente", nullable = false)
    private String nombre_cliente;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "codigo_departamento_reside_cliente", insertable = true, nullable = false, updatable = false)
    private Departamento codigo_departamento_reside_cliente;
    
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "codigo_ciudad_reside_cliente", insertable = true, nullable = false, updatable = false)
    private Ciudad codigo_ciudad_reside_cliente;
    
    @Column(name = "direccion_cliente", nullable = false)
    private String direccion_cliente;
    
    @Column(name = "telefono_cliente", nullable = false)
    private String telefono_cliente;
    
    @Column(name = "foto_cliente", nullable = false)
    private String foto_cliente;
    
    
//    Getters & Setters

    public Departamento getCodigo_departamento_reside_cliente() {
        return codigo_departamento_reside_cliente;
    }

    public void setCodigo_departamento_reside_cliente(Departamento codigo_departamento_reside_cliente) {
        this.codigo_departamento_reside_cliente = codigo_departamento_reside_cliente;
    }

    public Ciudad getCodigo_ciudad_reside_cliente() {
        return codigo_ciudad_reside_cliente;
    }

    public void setCodigo_ciudad_reside_cliente(Ciudad codigo_ciudad_reside_cliente) {
        this.codigo_ciudad_reside_cliente = codigo_ciudad_reside_cliente;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public long getNumero_Identificacion_cliente() {
        return numero_Identificacion_cliente;
    }

    public void setNumero_Identificacion_cliente(long numero_Identificacion_cliente) {
        this.numero_Identificacion_cliente = numero_Identificacion_cliente;
    }

    public String getTipo_Identificacion_cliente() {
        return tipo_Identificacion_cliente;
    }

    public void setTipo_Identificacion_cliente(String tipo_Identificacion_cliente) {
        this.tipo_Identificacion_cliente = tipo_Identificacion_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getFoto_cliente() {
        return foto_cliente;
    }

    public void setFoto_cliente(String foto_cliente) {
        this.foto_cliente = foto_cliente;
    }
}
