package model.tipoNota;

import com.google.gson.annotations.SerializedName;


public class Conceptual  extends Nota {
	@SerializedName("id")
	private int id;
	@SerializedName("value")
	EnumConceptual value;
	@SerializedName("created_at")
	private String created_at;
	@SerializedName("update_at")
	private String update_at;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getCreated_at() {
		return created_at;
	}

	public void getCreated_at(String nombre) {
		this.created_at = nombre;
	}


	public String getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(String update_at) {
		this.update_at = update_at;
	}


	public EnumConceptual getNota() {
		return value;
	}

	public void setNota(EnumConceptual nota) {
		this.value = nota;
	}

	public Conceptual(EnumConceptual not) {
	this.value = not;
	}

	@Override
	public boolean aprobada() {

		return value != EnumConceptual.MAL;
	}

	@Override
	public String value() {
		
		return value.name().toString();
	}



}
