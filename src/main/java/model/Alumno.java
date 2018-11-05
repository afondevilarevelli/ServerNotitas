package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {
	@Id
	private int legajo;
	private String nombre;
	private String apellido;
	private String github_user;
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_alumno")
	private List<Asignacion> assignments = new ArrayList<>();
	
	public Alumno(String unNom, String ape, int leg, String userGit) {
		this.nombre = unNom;
		this.apellido = ape;
		this.legajo = leg;
		this.github_user = userGit;
		this.assignments = getAssignments();
	}	
	
	public String getNombre() {
		return this.nombre;
	}



	public void setNombre(String first_name) {
		this.nombre = first_name;
	}



	public int getLegajo() {
		return legajo;
	}



	public void setLegajo(int code) {
		this.legajo = code;
	}



	public String getApellido() {
		return this.apellido;
	}



	public void setApellido(String last_name) {
		this.apellido = last_name;
	}



	public String getGithub_user() {
		return github_user;
	}



	public void setGithub_user(String github_user) {
		this.github_user = github_user;
	}



	public List<Asignacion> getAssignments() {
		return assignments;
	}



	public void setAssignments(List<Asignacion> assignments) {
		this.assignments = assignments;
	}

	public void addAsignacion(Asignacion a) {
		this.assignments.add(a);
	}
	
	public void removeAsignacion(Asignacion a) {
		this.assignments.remove(a);
	}

	public boolean mismoLegajo(int unLeg) {

		return this.legajo == unLeg;
	}

}
