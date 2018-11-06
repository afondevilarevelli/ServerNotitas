package model;

import java.util.ArrayList;
import java.util.List;

import servicios.AlumnoService;

public class MainPrueba {

	public static void main(String[] args) {
		List<Nota> notas = new ArrayList<Nota>();
		Numerica n1 = new Numerica(Double.valueOf(7));
		Conceptual n2 = new Conceptual(EnumConceptual.BIEN);
		notas.add(n1);
		notas.add(n2);
		
		Asignacion asig1 = new Asignacion( notas,"TP diseño","hacer algo re piola");
		Alumno al = new Alumno("Antonio", "Fondevila", "contra", 1595490, "afondevilarevelli");
		al.addAsignacion(asig1);
		
		AlumnoService.persistirAlumno(al);


	}

}
