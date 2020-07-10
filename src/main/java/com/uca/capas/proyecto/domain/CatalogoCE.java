package com.uca.capas.proyecto.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(schema = "public", name = "catalogo_ce")
public class CatalogoCE {
    @Id
    @Column(name = "id_catce")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCentroEscolar;

    @NotEmpty(message = "el campo nombre no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 150 caracteres", max = 150)
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_municipio")
    private Municipio municipio;

    @OneToMany(mappedBy = "institucion", fetch = FetchType.EAGER)
    private Set<Expediente> expedienteList;

    public CatalogoCE() {
    }

    public Integer getIdCentroEscolar() {
        return idCentroEscolar;
    }

    public void setIdCentroEscolar(Integer idCentroEscolar) {
        this.idCentroEscolar = idCentroEscolar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getEstadoDelegate() {
        if (this.estado == null) return "";
        else
            return estado ? "Activo" : "Inactivo";
    }

    public Set<Expediente> getExpedienteList() {
        return expedienteList;
    }

    public void setExpedienteList(Set<Expediente> expedienteList) {
        this.expedienteList = expedienteList;
    }
}
