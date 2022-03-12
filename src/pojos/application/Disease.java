package pojos.application;

import java.io.Serializable;
import java.util.Objects;

public class Disease implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String disease;
	public enum Symptoms {CHEST_PRESSURE,FATIGUE,PAIN_EXTENDS_TO_LEFT_ARM,DISNEA,COLD_SWEAT};
	private Symptoms symptoms;
	
	public Disease(String disease) {
		super();
		this.disease = disease;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public Symptoms getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Symptoms symptoms) {
		this.symptoms = symptoms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disease other = (Disease) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Disease [id=" + id + ", disease=" + disease + "]";
	}
	
	

}
