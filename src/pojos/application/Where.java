package pojos.application;

import java.io.Serializable;
import java.util.Objects;

public class Where implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String place;
	private Vehicule vehicule;
    public enum Vehicule {AMBULANCE,HELICOPTER,BOAT};

	
	public Where(Integer id, String place, Vehicule vehicule) {
		super();
		this.id = id;
		this.place = place;
		this.vehicule = vehicule;
	}
	
	public Where(String place, Vehicule vehicule) {
		super();
		this.place = place;
		this.vehicule = vehicule;
	}

	public Where(String place) {
		super();
		this.place = place;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
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
		Where other = (Where) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Where [id=" + id + ", place=" + place + ", vehicule=" + vehicule + "]";
	}
	
	
	
}
