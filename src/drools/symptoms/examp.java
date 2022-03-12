package drools.symptoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class examp {
	 public static void main(String[] args) {
		 
		Specialty sp1 = new Specialty("Cardiology_spe");
		Disease d1 = new Disease(0,"Heart attack");
		Disease d2 = new Disease(1,"Heart failure");
		Disease d3 = new Disease(2,"Hipertensive crisis");
		Disease d4 = new Disease(3,"Ictus");
		Disease d5 = new Disease(4,"Syncope");
		
		List<Disease> diseases = new ArrayList<>();
		
		String symp = "CHEST PRESSURE,FATIGUE,PAIN EXTENDS TO LEFT ARM,DISNEA,COLD SWEAT";
		List<String> list_1 = Arrays.asList(symp.split(","));
		List<String> symptoms_list =  new ArrayList<String>(list_1); 
			// This allows to remove or add symptoms to the list of Strings (USEFUL FOR THE APPLICATION, NOT THE RULES)
		
		d1.setSymptomsList(symptoms_list);
			diseases.add(d1);
			diseases.add(d2);
			diseases.add(d3);
			diseases.add(d4);
			diseases.add(d5);
		sp1.setDisease_list(diseases);
		
		System.out.println(sp1.getDisease_list().get(d1.getId()));
		System.out.println(sp1.getDisease_list().get(0).getDisease());
	}
}
