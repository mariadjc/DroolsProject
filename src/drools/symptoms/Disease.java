package drools.symptoms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Disease implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String disease;
	private Integer severity_case;
	private List<String> symptomsList = new ArrayList<String>();
	
	public Disease(String disease) {
		super();
		this.disease = disease;
	}

	public Disease(Integer id, String disease) {
		super();
		this.id = id;
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

	public List<String> getSymptomsList() {
		return symptomsList;
	}

	public void setSymptomsList(List<String> symptomsList) {
		this.symptomsList = symptomsList;
	}

	public Integer getSeverity_case() {
		return severity_case;
	}

	public void setSeverity_case(Integer severity_case) {
		this.severity_case = severity_case;
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
		return "Disease [id=" + id + ", disease=" + disease + ", severity_case=" + severity_case + ", symptomsList="
				+ symptomsList + "]";
	}

	
	

}
