package com.uca.capas.proyecto.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="catalogo_materias")
public class Catalogo_materias {

	@Id
	@GeneratedValue(generator="catalogo_materias_id_catmateria_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "catalogo_materias_id_catmateria_seq", sequenceName = "public.catalogo_materias_id_catmateria_seq", allocationSize = 1)
	@Column(name="id_catmateria")
	private Integer idCatmateria;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="estado")
	private Boolean estado;

	
	
	public Catalogo_materias() {
	}

	public Catalogo_materias(Integer id_catmateria, String nombre, Boolean estado) {
		super();
		this.idCatmateria = id_catmateria;
		this.nombre = nombre;
		this.estado = estado;
	}


	public Integer getId_catmateria() {
		return idCatmateria;
	}

	
	public void setId_catmateria(Integer id_catmateria) {
		this.idCatmateria = id_catmateria;
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

	public String getEstadoDelegate() {
		if (this.estado == null) return "";
		else
			return estado ? "Activo" : "Inactivo";
	}
	
	
}




















