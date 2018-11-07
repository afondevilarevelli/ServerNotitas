package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class MainPruebaParseo {
	
	//prueba del parseo de las asignaciones correcto
	public static void main(String[] args) {
		List<Nota> notas = new ArrayList<Nota>();
		Numerica n1 = new Numerica(Double.valueOf(7));
		Conceptual n2 = new Conceptual(EnumConceptual.BIEN);
		notas.add(n1);
		notas.add(n2);
		
		Asignacion asig1 = new Asignacion( notas,"TP algoritmos","hacer algo re piola");
		asig1.validarEstado();
		
		Gson gson = new Gson(); 
		String jsonAsignaciones = gson.toJson(asig1);
		
		System.out.println(jsonAsignaciones);

	}

}
