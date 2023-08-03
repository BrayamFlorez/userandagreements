package com.timod.userandagreements.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "convenios")
public class ConvenioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cupon;
    private String convenio;
    private String alias;
    private String descuento;
    private String tiendas;
    private Date vigencia;

    // Constructor vacío (requerido por JPA)
    public ConvenioModel() {
    }

    // Constructor con parámetros para crear objetos Convenio
    public ConvenioModel(String cupon, String convenio, String alias, String descuento, String tiendas, Date vigencia) {
        this.cupon = cupon;
        this.convenio = convenio;
        this.alias = alias;
        this.descuento = descuento;
        this.tiendas = tiendas;
        this.vigencia = vigencia;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCupon() {
        return cupon;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getTiendas() {
        return tiendas;
    }

    public void setTiendas(String tiendas) {
        this.tiendas = tiendas;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    // toString() para facilitar la depuración y el registro
    @Override
    public String toString() {
        return "Convenio [id=" + id + ", cupon=" + cupon + ", convenio=" + convenio +
               ", alias=" + alias + ", descuento=" + descuento +
               ", tiendas=" + tiendas + ", vigencia=" + vigencia + "]";
    }
}
