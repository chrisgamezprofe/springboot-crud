package com.vacantesupb.empresa.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "tbl_vacantes")
public class Vacante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "titulo",length = 100,nullable = false)
    private String titulo;

    @Column(name = "descripcion",length = 100,nullable = false,columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "requisitos",length = 100,nullable = false,columnDefinition = "TEXT")
    private String requisitos;

    @Column(name = "ubicacion",length = 100,nullable = false)
    private String ubicacion;

    @Column(name = "salario",nullable = false)
    private float salario;

    @Column(name = "termino",nullable = false)
    private float termino;

    @Column(name = "nota",nullable = true,columnDefinition = "TEXT")
    private float nota;

    @Column(name = "remoto",nullable = false)
    private boolean remoto;

    @Column(name = "fecha_publicacion",nullable = false)
    private Timestamp fecha_publicacion;

    @Column(name = "fecha_cierre",nullable = true)
    private Timestamp fecha_cierre;

    //Muchas vacantes x una empresa
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Empresa empresa;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getTermino() {
        return termino;
    }

    public void setTermino(float termino) {
        this.termino = termino;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public boolean isRemoto() {
        return remoto;
    }

    public void setRemoto(boolean remoto) {
        this.remoto = remoto;
    }

    public Timestamp getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Timestamp fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public Timestamp getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Timestamp fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Vacante() {
    }

    public Vacante(long id, String titulo, String descripcion, String requisitos, String ubicacion, float salario, float termino, float nota, boolean remoto, Timestamp fecha_publicacion, Timestamp fecha_cierre, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
        this.ubicacion = ubicacion;
        this.salario = salario;
        this.termino = termino;
        this.nota = nota;
        this.remoto = remoto;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_cierre = fecha_cierre;
        this.empresa = empresa;
    }
}
