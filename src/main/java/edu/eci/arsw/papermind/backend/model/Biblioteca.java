package edu.eci.arsw.papermind.backend.model;

import java.util.Date;
import javax.persistence.*;

@Entity //Una entidad es un objeto, elemento o ‘cosa’ con atributos particulares que lo distinguen. Por ejemplo, este podría ser un ‘user
@Table(name = "bibliotecas")
public class Biblioteca {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)//El valor de esta PK es generada automáticamente con esta anotación
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "date_created")
	private Date fecha_dateCreated;

	@Column(name = "fecha_modification")
	private Date fecha_modification;

	@Column(name = "description")
	private String description;

	public Biblioteca(){
		super();
	}

	public Biblioteca(String nombre, Date fecha_dateCreated, Date fecha_modification){
		super();
		this.nombre = nombre;
		this.fecha_dateCreated = fecha_dateCreated;
		this.fecha_modification = fecha_modification;
	}

	public Long getId_biblioteca() {
		return id;
	}

	public void setId_biblioteca(Long id_biblioteca) {
		this.id = id_biblioteca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_dateCreated() {
		return fecha_dateCreated;
	}

	public void setFecha_dateCreated(Date recreational) {
		this.fecha_dateCreated = recreational;
	}

	public Date getFecha_modification() {
		return fecha_modification;
	}

	public void setFecha_modification(Date fecha_modification) {
		this.fecha_modification = fecha_modification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
