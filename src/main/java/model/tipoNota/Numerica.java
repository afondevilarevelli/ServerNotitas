package model.tipoNota;

import com.google.gson.annotations.SerializedName;


public class Numerica extends Nota {
    
	@SerializedName("value")
	private double value;
	@SerializedName("id")
	private int id;
	@SerializedName("created_at")
	private String created_at;
	@SerializedName("update_at")
	private String update_at;
	
	public Numerica(int i) {
		this.value = i;
	}
	
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


	public double getNota() {
		return value;
	}

	public void setNota(double nota) {
		this.value = nota;
	}



	@Override
	public boolean aprobada() {

		return value >= 6;
	}

	@Override
	public String value() {
		return Double.toString(this.value);
	}




}
