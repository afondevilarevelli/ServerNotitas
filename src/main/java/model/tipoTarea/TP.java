package model.tipoTarea;

import org.uqbar.commons.utils.Observable;

import model.tipoNota.EnumConceptual;

@Observable
public class TP  {
	EnumConceptual calificacion;

	public EnumConceptual getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(EnumConceptual calificacion) {
		this.calificacion = calificacion;
	}

	

}
