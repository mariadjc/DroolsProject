package drools.symptoms;

import java.io.Serializable;
import java.util.Objects;

public class Speciality implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String speciality;
	
	public Speciality(String speciality) {
		super();
		this.speciality = speciality;
	}
	
	public Speciality(Integer id, String speciality) {
		super();
		this.id = id;
		this.speciality = speciality;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
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
		Speciality other = (Speciality) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Speciality [id=" + id + ", speciality=" + speciality + "]";
	}
	
	

}
