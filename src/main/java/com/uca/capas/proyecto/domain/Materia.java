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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(schema="public", name="materia")
public class Materia {

	@Id
	@GeneratedValue(generator="materia_id_materia_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "materia_id_materia_seq", sequenceName = "public.materia_id_materia_seq", allocationSize = 1)
	@Column(name="id_materia")
	private Integer id_materia;
	
	 @ManyToOne(fetch= FetchType.LAZY)
	 @JoinColumn(name="id_catmateria")
	 private Catalogo_materias id_catmateria;
	
	@NotNull(message="No puede estar vacio")
	@Min(value=2005, message="No puede ingresar un año antes del 2005")  
    @Max(value=2020, message="No puede ingresar un año después del 2020")  
	@Column(name="anio")
	private Integer anio;
	
	//Combobox 01,02,03
	@NotNull(message="No puede estar vacio")
	@Column(name="ciclo")
	private Integer ciclo;
	
	@NotNull(message="No puede estar vacio")
	@Min(value=0, message="La nota no puede ser menor a 0")  
    @Max(value=10, message="La nota no puede ser mayor a 10")  
	@Column(name="nota")
	private Float nota;
	
	
	@NotNull(message="No puede estar vacio")
	@Column(name="id_estudiante")
	private Integer id_estudiante;
	
	
	@Column(name="resultado")
	private String resultado;
	

	public Materia() {
	}
	
	

	
	public Integer getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public Integer getId_materia() {
		return id_materia;
	}

	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
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


	public Catalogo_materias getId_catmateria() {
		return id_catmateria;
	}



	public void setId_catmateria(Catalogo_materias id_catmateria) {
		this.id_catmateria = id_catmateria;
	}

	
	
	
	
	
	
}
