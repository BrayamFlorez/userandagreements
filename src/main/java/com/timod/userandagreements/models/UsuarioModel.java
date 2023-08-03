package com.timod.userandagreements.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private Date fechaNacimiento;

    

    // Constructor vacío (requerido por JPA)
    public UsuarioModel() {
    }

    // Constructor con parámetros para crear objetos Usuario
    public UsuarioModel(String nombre, String apellido, String tipoDocumento, String numeroDocumento, String direccion, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

  
    // toString() para facilitar la depuración y el registro
    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido +
               ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento +
               ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento + "]";
    }
}
