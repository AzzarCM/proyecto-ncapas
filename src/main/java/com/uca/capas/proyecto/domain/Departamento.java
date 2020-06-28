package com.uca.capas.proyecto.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "public", name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer idMunicipio;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy="departamento",fetch= FetchType.EAGER)
    private List<Municipio> MunicipioList;
}
