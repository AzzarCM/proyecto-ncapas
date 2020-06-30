package com.uca.capas.proyecto.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(schema = "public", name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Size(message = "El campo no debe contener mas de 150 caracteres", max = 150)
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    @Column(name = "nombre")
    private String nombre;

    @Size(message = "El campo no debe contener mas de 150 caracteres", max = 150)
    @NotEmpty(message = "El campo apellido no debe estar vacio")
    @Column(name = "apellido")
    private String apellido;

    @NotNull(message = "El campo Fecha no puede quedar vacio")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;


    @Column(name = "edad")
    private Integer edad;

    @Size(message = "El campo no debe contener mas de 200 caracteres", max = 200)
    @NotEmpty(message = "El campo direccion no debe estar vacio")
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado")
    private Boolean estado;

    @Size(message = "El campo no debe contener mas de 30 caracteres", max = 30)
    @NotEmpty(message = "El campo username no debe estar vacio")
    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Size(message = "El campo no debe contener mas de 200 caracteres", max = 200)
    @NotEmpty(message = "El campo contrasenia no debe estar vacio")
    @Column(name = "contrasenia")
    private String contrasenia;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_municipio")
    private Municipio municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;


    public Usuario() { }

    public Integer getIdUsuario() { return idUsuario; }

    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public Date getFechaNacimiento() { return fechaNacimiento; }

    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public Integer getEdad() { return edad; }

    public void setEdad(Integer edad) { this.edad = edad; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Boolean getEstado() { return estado; }

    public void setEstado(Boolean estado) { this.estado = estado; }
    public String getNombre_usuario() { return nombre_usuario; }

    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }

    public String getContrasenia() { return contrasenia; }

    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public String getEstadoDelegate() {
        if (this.estado == null) return "";
        else
            return estado ? "Activo" : "Inactivo";
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
