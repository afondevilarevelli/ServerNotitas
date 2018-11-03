package model.Repositories;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import org.uqbar.commons.utils.Observable;

import Request.RequestService;
import ui.windows.ErrorWindow;
import model.Alumno;

@Observable
public class AlumnosRepository {

	private static AlumnosRepository instance;
	private List<Alumno> alumnos = new ArrayList<Alumno>();

	public static AlumnosRepository getInstance() {
		if (instance == null) {
			instance = new AlumnosRepository();
		}
		return instance;
	}

	public Alumno search(int unLeg) {
        try{
		return this.alumnos.stream()
				.filter(alumno -> alumno.mismoLegajo(unLeg)).findFirst()
				.get();
		}
        catch (Exception e)
        {
        	String leg = Integer.toString(unLeg);
        	throw new ErrorWindow("No existe el alumno con legajo " + leg);
        	
        }

	}


	public void agregar(Alumno alu) {
		
		this.alumnos.add(alu);
	}

	public List<Alumno> all() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
