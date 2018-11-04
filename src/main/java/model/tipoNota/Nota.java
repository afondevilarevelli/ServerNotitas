package model.tipoNota;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.google.gson.annotations.SerializedName;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Nota {
	@SerializedName("id")
	@Id @GeneratedValue
	private int id;
	
	@SerializedName("created_at")
	private String created_at;
	@SerializedName("updated_at")
	private String updated_at;
	
	public Nota() {
		this.created_at = LocalDate.now().toString();
		this.updated_at = LocalDate.now().toString();
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


	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	
	public abstract boolean estaAprobada();
    public abstract String value();
	
}
