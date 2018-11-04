package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Transactional;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
@Transactional
@Table(name = "alumnos")
public class Alumno extends Entity {

	@SerializedName("first_name")
	private String first_name;
	@SerializedName("legajo")
	private int legajo;
	@SerializedName("last_name")
	private String last_name;
	@SerializedName("github_user")
	private String github_user;
	@SerializedName("assignments")
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_alumno")
	private List<Asignacion> assignments = new ArrayList<>();
	
	public Alumno(String unNom, String ape, int leg, String userGit) {
		this.first_name = unNom;
		this.last_name = ape;
		this.legajo = leg;
		this.github_user = userGit;
		this.assignments = getAssignments();
	}	
	
	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public int getLegajo() {
		return legajo;
	}



	public void setLegajo(int code) {
		this.legajo = code;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
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


	public boolean mismoLegajo(int unLeg) {

		return this.legajo == unLeg;
	}

}
