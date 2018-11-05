package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.tipoNota.Nota;



import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

@Observable
@Entity
@Table(name = "asignaciones")
public class Asignacion {
	@SerializedName("id")
	@Id @GeneratedValue
	private int id;
	@SerializedName("title")
	private String title;
	@SerializedName("description")
	private String descripcion;
	@SerializedName("grades")
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_asignacion")
	private List<Nota> grades = new ArrayList<Nota>();
    private String estado;
	


	public Asignacion(List<Nota> notas,String nombre,String description) {
		this.title = nombre;
		this.descripcion = description;
		this.grades = notas;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String nombre) {
		this.title = nombre;
	}

	public List<Nota> getGrades() {
		return grades;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public void  validarEstado() {
		
		 if(this.grades.get(grades.size() - 1).estaAprobada())
		 {
		  setEstado("Aprobado");
		 }
		 else
		 {
		 setEstado("No Aprobado"); 
		 }
	}
		
		
	public String getUltimaNota() {
		if(this.grades.isEmpty())
		{
			throw new RuntimeException("No hay notas cargadas");
		}
		else
		{
			return  this.grades.get(grades.size() - 1).value();
		}
	}


	@Override
	public String toString() {
		return "Asignacion [id=" + id + ", title=" + title + ", descripcion=" + descripcion + ", grades=" + grades
				+ ", estado=" + estado + "]";
	}

}