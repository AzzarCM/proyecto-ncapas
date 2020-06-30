package com.uca.capas.proyecto.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(schema = "public", name = "municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_municipio")
    private Integer idMunicipio;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy="municipio",fetch= FetchType.EAGER)
    private Set<CatalogoCE> catalogoCEList;

    @OneToMany(mappedBy = "municipio", fetch = FetchType.EAGER)
    private Set<Usuario> usuarioList;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_departamento")
    private Departamento departamento;

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<CatalogoCE> getCatalogoCEList() {
        return catalogoCEList;
    }

    public void setCatalogoCEList(Set<CatalogoCE> catalogoCEList) {
        this.catalogoCEList = catalogoCEList;
    }

    public Set<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(Set<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
