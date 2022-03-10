package pojos.application;

import java.io.Serializable;
import java.util.Objects;

public class Location implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String place;
	private Vehicle Vehicle;
    public enum Vehicle {AMBULANCE,HELICOPTER,BOAT};

	
	public Location(Integer id, String place, Vehicle Vehicle) {
		super();
		this.id = id;
		this.place = place;
		this.Vehicle = Vehicle.AMBULANCE;
	}
	
	public Location(String place, Vehicle Vehicle) {
		super();
		this.place = place;
		this.Vehicle = Vehicle.AMBULANCE;
	}

	public Location(String place) {
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

	public Vehicle getVehicle() {
		return Vehicle;
	}

	public void setVehicle(Vehicle Vehicle) {
		this.Vehicle = Vehicle;
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
		Location other = (Location) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Where [id=" + id + ", place=" + place + ", Vehicle=" + Vehicle + "]";
	}
	
	
	
}
