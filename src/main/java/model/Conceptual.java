package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value = "conceptual")
public class Conceptual  extends Nota {
	@Enumerated
	private EnumConceptual value;	
	
	public Conceptual() {}
	
	public Conceptual(EnumConceptual not) {
		super();
		this.value = not;
	}

	public EnumConceptual getNota() {
		return value;
	}

	public void setNota(EnumConceptual nota) {
		this.value = nota;
	}

	@Override
	public boolean estaAprobada() {
		return value != EnumConceptual.MAL && value != EnumConceptual.REGULAR_MENOS;
	}

	@Override
	public String value() {	
		return value.name().toString();
	}



}
