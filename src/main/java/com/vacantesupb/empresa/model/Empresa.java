package com.vacantesupb.empresa.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_empresas")
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "nit",unique = true,length = 14,nullable = false)
    private String nit;

    @Column(name = "nombre",length = 100,nullable = false)
    private String nombre;

    @Column(name = "ciudad",length = 100,nullable = false)
    private String ciudad;

    @Column(name = "imagen_logo",nullable = true,columnDefinition = "TEXT")
    private String imagen_logo;

    @Column(name = "telefono",length = 15,nullable = false)
    private String telefono;

    @Column(name = "correo",length = 60,nullable = false)
    private String correo;
    @Column(name = "token",length = 60,columnDefinition = "TEXT")
    private String token;

    private boolean verificada;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(String imagen_logo) {
        this.imagen_logo = imagen_logo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isVerificada() {
        return verificada;
    }

    public void setVerificada(boolean verificada) {
        this.verificada = verificada;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Empresa() {
    }

    public Empresa(long id, String nit, String nombre, String ciudad, String imagen_logo, String telefono, String correo, boolean verificada) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.imagen_logo = imagen_logo;
        this.telefono = telefono;
        this.correo = correo;
        this.verificada = verificada;
    }
}
