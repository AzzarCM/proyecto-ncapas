package com.uca.capas.proyecto.domain;


import javax.persistence.*;
import java.util.List;

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
    private List<CatalogoCE> catalogoCEList;

    @OneToMany(mappedBy = "municipio", fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;

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

    public List<CatalogoCE> getCatalogoCEList() {
        return catalogoCEList;
    }

    public void setCatalogoCEList(List<CatalogoCE> catalogoCEList) {
        this.catalogoCEList = catalogoCEList;
    }

    //private Departamento departamento;
}
