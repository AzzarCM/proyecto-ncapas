package com.uca.capas.proyecto.domain;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "catalogo_ce")
public class CatalogoCE {
    @Id
    @Column(name = "id_catce")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCentroEscolar;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_municipio")
    private Municipio municipio;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
