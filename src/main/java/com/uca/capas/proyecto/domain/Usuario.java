package com.uca.capas.proyecto.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "El campo de la fecha no debe estar vacio")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @NotEmpty(message = "El campo edad no debe estar vacio")
    @Column(name = "edad")
    private Integer edad;

    @Size(message = "El campo no debe contener mas de 200 caracteres", max = 200)
    @NotEmpty(message = "El campo direccion no debe estar vacio")
    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado")
    private String estado;

    @Size(message = "El campo no debe contener mas de 30 caracteres", max = 30)
    @NotEmpty(message = "El campo username no debe estar vacio")
    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Size(message = "El campo no debe contener mas de 30 caracteres", max = 30)
    @NotEmpty(message = "El campo contrasenia no debe estar vacio")
    @Column(name = "contrasenia")
    private String contrasenia;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="id_municipio")
    private Municipio municipio;

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

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getNombre_usuario() { return nombre_usuario; }

    public void setNombre_usuario(String nombre_usuario) { this.nombre_usuario = nombre_usuario; }

    public String getContrasenia() { return contrasenia; }

    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
}
