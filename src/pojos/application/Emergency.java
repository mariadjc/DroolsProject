package pojos.application;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Emergency implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer code;
	private String date;
	private Integer severity;
	private String direction;
	private Protocol protocol;
	private Location location;
	//private Speciality speciality;
	
	public Emergency() {
		super();
		this.date = setDate();
		this.code = setCode();
	}
	
	public Emergency(Integer id) {
		super();
		this.id = id;
		this.date = setDate();
		this.code = setCode();
	}
	
	
	public Emergency(Integer id, Integer code, String date, Integer severity) {
		super();
		this.id = id;
		this.code = code;
		this.date = date;
		this.severity = severity;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

/*
	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
*/
	public Integer getSeverity() {
		return severity;
	}
	public void setSeverity(Integer severity) {
		this.severity = severity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}
	public Integer setCode() {
		Integer code = (int) (Math.random()*(999-0+1)+0);
		return code;
	}
	public String getDate() {
		return date;
	}
	public String setDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String regDate = formatter.format(date);
		return regDate;
	}
	
	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
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
		Emergency other = (Emergency) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Emergency [id=" + id + ", code=" + code + ", date=" + date + ", severity=" + severity + ", direction="
				+ direction + ", protocol=" + protocol + "]";
	}
	
	
	
	
}
