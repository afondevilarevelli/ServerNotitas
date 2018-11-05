package model.tipoNota;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

import com.google.gson.annotations.SerializedName;

@Entity
@DiscriminatorValue(value = "conceptual")
public class Conceptual  extends Nota {
	@SerializedName("value")
	@Enumerated
	private EnumConceptual value;	
	
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
