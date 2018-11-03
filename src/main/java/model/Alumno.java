package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.Entity;
import org.uqbar.commons.utils.Observable;
import org.uqbar.commons.utils.Transactional;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("serial")
@Transactional
@Observable
public class Alumno extends Entity {

	@SerializedName("first_name")
	private String first_name;
	@SerializedName("code")
	private int code;
	@SerializedName("last_name")
	private String last_name;
	@SerializedName("github_user")
	private String github_user;
	@SerializedName("assignments")
	private List<Asignacion> assignments = new ArrayList<>();
	
	
	
	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
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


	
	public Alumno(String unNom, String ape, int leg, String userGit) {
		this.first_name = unNom;
		this.last_name = ape;
		this.code = leg;
		this.github_user = userGit;
		this.assignments = getAssignments();
	}

	public boolean mismoLegajo(int unLeg) {

		return this.getCode() == unLeg;
	}

}
