package model.tipoTarea;


import model.tipoNota.Numerica;

import org.uqbar.commons.utils.Observable;

@Observable
public class Parcial  {
	Numerica calificacion;

	public Numerica getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Numerica calificacion) {
		this.calificacion = calificacion;
	}



}
