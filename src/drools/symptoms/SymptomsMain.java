package drools.symptoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class SymptomsMain {
	
	public static void main(String[] args) {
		
		KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        execute(ks, kc);
		
	}
	
	public static void execute(KieServices ks, KieContainer kc) {

		KieSession ksession = kc.newKieSession("symptomsKS");
		
		Emergency u = new Emergency();
    	u.setId(0);
        
	    Patient p = new Patient("John","Tudor","Male", "Child", true,false,"23355");
			p.setId(0);
		u.setPatient(p);
		
		
		Protocol p1 = new Protocol(0,"Go to Urgencies unit for valoration",Protocol.Type.SHIPMENT);
		Protocol p2 = new Protocol(1,"Connect to oxygen supply",Protocol.Type.INPLACE);
		Protocol p3 = new Protocol(2,"Take paracetamol",Protocol.Type.ADVICE);
		Protocol p4 = new Protocol(3,"Connect to oxygen supply + Inject subcutaneous antipyretic medication",Protocol.Type.SHIPMENT);
		Protocol p5 = new Protocol(4,"Make appointment with doctor for further evaluation + Take medication and consider changes in status",Protocol.Type.ADVICE);
		Protocol p6 = new Protocol(5,"Connect catheter + intravenous antifluid and pain medicaments",Protocol.Type.INPLACE);
		
		List<Protocol> protocol_list = new ArrayList<>();
		protocol_list.add(p1);
		protocol_list.add(p2);
		protocol_list.add(p3);
		protocol_list.add(p4);
		protocol_list.add(p5);
		protocol_list.add(p6);
		u.setProtocol_list(protocol_list);

		Location w1 = new Location(0,"Home");
        Location w2 = new Location(1,"Transit");
        Location w3 = new Location(2,"Work place");
        Location w4 = new Location(3,"Mountain");
        Location w5 = new Location(4,"Beach");
        u.setLocation(w1);
        
		
		Specialty sp1 = new Specialty(0,"Cardiology");
		Specialty sp2 = new Specialty(1,"Toxicology");
		Specialty sp3 = new Specialty(2,"Neurology");
		Specialty sp4 = new Specialty(3,"Traumatology");
		Specialty sp5 = new Specialty(4,"Oncology");
		Specialty sp6 = new Specialty(5,"Other");   // Esta es aún cuestionable
		
		List<Disease> cardio_diseases = new ArrayList<>();
		Disease cardio1 = new Disease(0,"Heart attack");
		Disease cardio2 = new Disease(1,"Heart failure");
		Disease cardio3 = new Disease(2,"Hipertensive crisis");
		Disease cardio4 = new Disease(3,"Ictus");
		Disease cardio5= new Disease(4,"Syncope");
		
		
	// Several cases for same Disease because some symptoms differ
		List<Disease> onco_diseases = new ArrayList<>();
		Disease onco1_1 = new Disease(0,"Colon cancer");
		Disease onco1_2 = new Disease(1,"Colon cancer");
		Disease onco2_1 = new Disease(2,"Prostate_cancer");
		Disease onco2_2 = new Disease(3,"Prostate_cancer");
		Disease onco3_1 = new Disease(4,"Lung cancer");
		Disease onco3_2 = new Disease(5,"Lung cancer");
		Disease onco4_1 = new Disease(6,"Breast cancer");
		Disease onco4_2 = new Disease(7,"Breast cancer");
		Disease onco5_1= new Disease(8,"Leukemia");
		Disease onco5_2= new Disease(9,"Leukemia");
		
		List<Disease> other_diseases = new ArrayList<>();
		Disease other1 = new Disease(0,"Unknown (not urgent)");
		Disease other2 = new Disease(1,"Unknown (urgent)");
		
		
			
		// CARDIOLOGY

		String cardio_symp1 = "Chest pressure/Fatigue/Pain extends to the left arm/Disnea/Cold sweat";
		List<String> cardio_list_1 = Arrays.asList(cardio_symp1.split("/"));
		List<String> cardio_symptoms_list1 =  new ArrayList<String>(cardio_list_1); 
			// This allows to remove or add symptoms to the list of Strings (USEFUL FOR THE APPLICATION, NOT THE RULES)
		
		String cardio_symp2 = "Phlegm/Swelling/Faints/Fatigue/Heart palpitations";
		List<String> cardio_list_2 = Arrays.asList(cardio_symp2.split("/"));
		List<String> cardio_symptoms_list2 =  new ArrayList<String>(cardio_list_2); 
		
		cardio1.setSymptomsList(cardio_symptoms_list1);
			cardio_diseases.add(cardio1);
		cardio2.setSymptomsList(cardio_symptoms_list2);
			cardio_diseases.add(cardio2);
			cardio_diseases.add(cardio3);
			cardio_diseases.add(cardio4);
			cardio_diseases.add(cardio5);
		
		//sp1.getDisease_list().get(0);  //---> Corresponds to heart attack
		
		
		// TOXICOLOGY

		// NEUROLOGY

		// TRAUMATOLOGY
		
		// ONCOLOGY

			// ---------> COLON CANCER
		String onco_symp1_1 = "Constipation/Heart palpitations/Fever/Diarrhea/Pain/General malaise";
		List<String> onco_list_1_1 = Arrays.asList(onco_symp1_1.split("/"));
		List<String> onco_symptoms_list1_1 =  new ArrayList<String>(onco_list_1_1); 
		
		String onco_symp1_2 = "Constipation/Insomnia/Heart palpitations/Fever/Diarrhea/Vomits/Pain/General malaise";
		List<String> onco_list_1_2 = Arrays.asList(onco_symp1_2.split("/"));
		List<String> onco_symptoms_list1_2 =  new ArrayList<String>(onco_list_1_2); 
		
			// ---------> PROSTATE CANCER
		String onco_symp2_1 = "Dysuria/Fatigue/Pain/Fluid retention";
		List<String> onco_list_2_1 = Arrays.asList(onco_symp2_1.split("/"));
		List<String> onco_symptoms_list2_1 =  new ArrayList<String>(onco_list_2_1); 
		
		String onco_symp2_2 = "Dysuria/Fatigue/Pain/Fluid retention/Blood in urine";
		List<String> onco_list_2_2 = Arrays.asList(onco_symp2_2.split("/"));
		List<String> onco_symptoms_list2_2 =  new ArrayList<String>(onco_list_2_2); 
		
			// ---------> LUNG CANCER

		String onco_symp3_1 = "Chest pain/Fatigue/Fever/General malaise";
		List<String> onco_list_3_1 = Arrays.asList(onco_symp3_1.split("/"));
		List<String> onco_symptoms_list3_1 =  new ArrayList<String>(onco_list_3_1); 
		
		String onco_symp3_2 = "Chest pain/Fatigue/Fever/General malaise/Severe blood sputum";
		List<String> onco_list_3_2 = Arrays.asList(onco_symp3_2.split("/"));
		List<String> onco_symptoms_list3_2 =  new ArrayList<String>(onco_list_3_2); 
		
			// ---------> BREAST CANCER		
		
		String onco_symp4_1 = "Pain/Breast inflamation/Nipple discharge";
		List<String> onco_list_4_1 = Arrays.asList(onco_symp4_1.split("/"));
		List<String> onco_symptoms_list4_1 =  new ArrayList<String>(onco_list_4_1); 
		
		String onco_symp4_2 = "Pain/Breast inflamation/Nipple discharge/Skin ulcer";
		List<String> onco_list_4_2 = Arrays.asList(onco_symp4_2.split("/"));
		List<String> onco_symptoms_list4_2 =  new ArrayList<String>(onco_list_4_2); 
		
			// ---------> LEUKEMIA
		
		String onco_symp5_1 = "Fever/Severe infection/Pain/Fatigue/Sweating";
		List<String> onco_list_5_1 = Arrays.asList(onco_symp5_1.split("/"));
		List<String> onco_symptoms_list5_1 =  new ArrayList<String>(onco_list_5_1); 
		
		String onco_symp5_2 = "Fever/Pain/Fatigue/Sweating";
		List<String> onco_list_5_2 = Arrays.asList(onco_symp5_2.split("/"));
		List<String> onco_symptoms_list5_2 =  new ArrayList<String>(onco_list_5_2); 
		
		
		
		onco1_1.setSymptomsList(onco_symptoms_list1_1);
			onco_diseases.add(onco1_1);
		onco1_2.setSymptomsList(onco_symptoms_list1_2);
			onco_diseases.add(onco1_2);
		onco2_1.setSymptomsList(onco_symptoms_list2_1);
			onco_diseases.add(onco2_1);
		onco2_2.setSymptomsList(onco_symptoms_list2_2);
			onco_diseases.add(onco2_2);	
		onco3_1.setSymptomsList(onco_symptoms_list3_1);
			onco_diseases.add(onco3_1);
		onco3_2.setSymptomsList(onco_symptoms_list3_2);
			onco_diseases.add(onco3_2);	
		onco4_1.setSymptomsList(onco_symptoms_list4_1);
			onco_diseases.add(onco4_1);
		onco4_2.setSymptomsList(onco_symptoms_list4_2);
			onco_diseases.add(onco4_2);	
		onco5_1.setSymptomsList(onco_symptoms_list5_1);
			onco_diseases.add(onco5_1);
		onco5_2.setSymptomsList(onco_symptoms_list5_2);
			onco_diseases.add(onco5_2);	
			
		sp5.setDisease_list(onco_diseases);
				
		
		
		// OTHER
		
		String other_symp1 = "Fever/Fatigue/Sweating";
		List<String> other_list_1 = Arrays.asList(other_symp1.split("/"));
		List<String> other_symptoms_list1 =  new ArrayList<String>(other_list_1); 
			// This allows to remove or add symptoms to the list of Strings (USEFUL FOR THE APPLICATION, NOT THE RULES)
		
		String other_symp2 = "Fever/Pain/Fatigue/Sweating";
		List<String> other_list_2 = Arrays.asList(other_symp2.split("/"));
		List<String> other_symptoms_list2 =  new ArrayList<String>(other_list_2); 
		
		other1.setSymptomsList(other_symptoms_list1);
			other_diseases.add(cardio1);
		other2.setSymptomsList(other_symptoms_list2);
			other_diseases.add(cardio2);
		
		sp6.setDisease_list(other_diseases);
		
		
			
		// To compare the list of symptoms avoiding the order ----> Needed for the interface NOT rules
	/*
		Collections.sort(list_1);
		Collections.sort(symptoms_list);
		System.out.println(list_1.equals(symptoms_list));
	*/
		
		//System.out.println("BEFORE\n" + sp5.getDisease_list().get(0) + "\n\n");
		
		
		
	// STEPS
	// 1. WE SPECIFY THE SPECIALITY
		u.setSpecialty(sp5);
		
	// 2. WE SPECIFY THE SYMPTOMS OF THIS CASE (NOT THE OVERALL FROM ABOVE)
		// In this case I will choose the ones from 'onco_symptoms_list5_2' that correspond to index 9 of the disease_list
		
		Disease select = sp5.getDisease_list().get(9);  //We do this to only specify a single symptom list associated to 1 RULE and 1 DISEASE
		u.setDisease(select);
		
		ksession.insert(u);
		
		ksession.fireAllRules();
		//System.out.println("AFTER\n" +  sp5.getDisease_list().get(0));
		System.out.println("AFTER\n" +  u);
		
		ksession.dispose();
		
		
		
		
		
	}
	
}
