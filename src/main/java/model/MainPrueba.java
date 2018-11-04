package model;

import java.util.ArrayList;
import java.util.List;

import model.tipoNota.Conceptual;
import model.tipoNota.EnumConceptual;
import model.tipoNota.Nota;
import model.tipoNota.Numerica;
import servicios.Session;

public class MainPrueba {

	public static void main(String[] args) {
		List<Nota> notas = new ArrayList<Nota>();
		Numerica n1 = new Numerica(Double.valueOf(7));
		Conceptual n2 = new Conceptual(EnumConceptual.BIEN);
		notas.add(n1);
		notas.add(n2);
		
		Asignacion a1 = new Asignacion( notas,"TP diseño","hacer algo re piola");
		Alumno al = new Alumno("Antonio", "Fondevila", 1595490, "afondevilarevelli");
		
		Session.beginTransaction();
		try {
			Session.getSession().persist(a1);			
			Session.commitTransaction();
		}catch(Exception e) {
			Session.rollbackTransaction();
		}


	}

}
