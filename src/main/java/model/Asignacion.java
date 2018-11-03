package model;


import java.util.ArrayList;
import java.util.List;

import model.tipoNota.Nota;



import org.uqbar.commons.utils.Observable;

import com.google.gson.annotations.SerializedName;

@Observable
public class Asignacion {
	@SerializedName("id")
	private int id;
	@SerializedName("title")
	private String title;
	@SerializedName("description")
	private String descripcion;
	@SerializedName("grades")
	private List<Nota> grades = new ArrayList<Nota>();
    private String estado;
	


	public Asignacion(int id,List<Nota> notas,String nombre,String description) {
		this.title = nombre;
		this.descripcion = description;
		this.grades = notas;
		this.id = id;

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
		
		 if(this.grades.get(grades.size() - 1).aprobada())
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