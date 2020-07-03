package com.uca.capas.proyecto.domain;


import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "public", name = "expediente")
public class Expediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Size(message = "El campo no debe contener mas de 250 caracteres", max = 250)
    @NotEmpty(message = "El campo nombres no debe estar vacio")
    @Column(name = "nombres")
    private String nombres;

    @NotEmpty(message = "El campo apellidos no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 250 caracteres", max = 250)
    @Column(name = "apellidos")
    private String apellidos;

    @NotEmpty(message = "El campo carnet de minoridad no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 9 caracteres", max = 9)
    @Column(name = "carne_min")
    private String carneMin;

    @NotNull(message = "El campo de la fecha no debe estar vacio")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @NotNull(message = "El campo edad no debe estar vacio")
    @Column(name = "edad")
    private Integer edad;

    @NotEmpty(message = "El campo direccion no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 200 caracteres", max = 200)
    @Column(name = "direccion")
    private String direccion;

    @NotEmpty(message = "El campo del telefono fijo no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 9 caracteres", max = 9)
    @Column(name = "tel_fijo")
    private String telFijo;

    @NotEmpty(message = "El campo del telefono movil no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 9 caracteres", max = 9)
    @Column(name = "tel_movil")
    private String telMovil;

   @NotEmpty(message = "El campo del nombre del padre no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 100 caracteres", max = 100)
    @Column(name = "nombre_padre")
    private String nombrePadre;

    @NotEmpty(message = "El campo del nombre de la madre no debe estar vacio")
    @Size(message = "El campo no debe contener mas de 100 caracteres", max = 100)
    @Column(name = "nombre_madre")
    private String nombreMadre;

    @Column(name = "institucion")
    private String institucion;

    @Transient
    public Float promedio;
    @Transient
    public Integer aprovadas;
    @Transient
    public Integer reprovadas;
/*
    @OneToMany(mappedBy="expediente",fetch= FetchType.EAGER)
    private List<Materia> materias;

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
*/

    public Float getPromedio() {
        return promedio;
    }

    public void setPromedio(Float promedio) {
        this.promedio = promedio;
    }

    public Integer getAprovadas() {
        return aprovadas;
    }

    public void setAprovadas(Integer aprovadas) {
        this.aprovadas = aprovadas;
    }

    public Integer getReprovadas() {
        return reprovadas;
    }

    public void setReprovadas(Integer reprovadas) {
        this.reprovadas = reprovadas;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCarneMin() {
        return carneMin;
    }

    public void setCarneMin(String carneMin) {
        this.carneMin = carneMin;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(String telMovil) {
        this.telMovil = telMovil;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Expediente(){}

    //@OneToMany(mappedBy="expediente",fetch= FetchType.EAGER)
    //private List<Materia> materias;

}
