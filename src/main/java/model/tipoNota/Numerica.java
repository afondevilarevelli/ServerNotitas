package model.tipoNota;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "numerica")
public class Numerica extends Nota {
	private Double value;
	
	public Numerica(Double i) {
		super();
		this.value = i;
	}

	public Double getNota() {
		return value;
	}

	public void setNota(Double nota) {
		this.value = nota;
	}



	@Override
	public boolean estaAprobada() {
		return value >= 6;
	}

	@Override
	public String value() {
		return Double.toString(this.value);
	}




}
