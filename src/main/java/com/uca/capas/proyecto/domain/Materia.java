package com.uca.capas.proyecto.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public", name="materia")
public class Materia {

	@Id
	@GeneratedValue(generator="materia_id_materia_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "materia_id_materia_seq", sequenceName = "public.materia_id_materia_seq", allocationSize = 1)
	@Column(name="id_materia")
	private Integer id_materia;
	
	@NotNull(message="No puede estar vacio")
	@Column(name="id_catmateria")
	private Integer id_catmateria;
	
	
	private String nombre_mat;
	
	@NotNull(message="No puede estar vacio")
	@Size(message="Año desde el 2005 hasta la fecha", max=2020, min=2005)
	@Column(name="anio")
	private Integer anio;
	
	//Combobox 01,02,03
	@NotNull(message="No puede estar vacio")
	@Column(name="ciclo")
	private Integer ciclo;
	
	@NotNull(message="No puede estar vacio")
	@Size(message="Nota desde 0 hasta 10", max=10, min=0)
	@Column(name="nota")
	private Float nota;
	
	@Column(name="resultado")
	private String resultado;
	

	public Materia() {
	}
	
	

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}

	public Integer getId_catmateria() {
		return id_catmateria;
	}

	public void setId_catmateria(Integer id_catmateria) {
		this.id_catmateria = id_catmateria;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	public Float getNota() {
		return nota;
	}

	public void setNota(Float nota) {
		this.nota = nota;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	
	public String getNombre_mat() {
		
		return nombre_mat;
	}

	public void setNombre_mat(String nombre_mat) {
		this.nombre_mat = nombre_mat;
	}
	
	
	
	
}
