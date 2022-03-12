package drools.symptoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import drools.symptoms.Disease;
import drools.symptoms.Specialty;

public class DisplayVehicle {

	/*
	 * First: A location is setted. This location is associated to a vehicle
	 * Secondly: After evaluation of the case and the severity:
	 * 
	 * 				severity 1,2,3 -> Ambulance (or other)
	 * 				severity 4,5 -> No vehicle display
	 */
	
    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        
        execute(ks, kc);
    }

    public static void execute(KieServices ks, KieContainer kc) {
    
        KieSession ksession = kc.newKieSession("vechicleKS");
        
        // THIS PART WORKS
        
        Location w1 = new Location(0,"Home");
        Location w2 = new Location(1,"Transit");
        Location w3 = new Location(2,"Work place");
        Location w4 = new Location(3,"Mountain");
        Location w5 = new Location(4,"Beach");
         
        Emergency u = new Emergency();
        Protocol prot = new Protocol(0,"info");
        	u.setId(0);
	        u.setLocation(w1);
	        u.setProtocol(prot);
	        u.setSeverity(3);
        Patient p = new Patient("John","Tudor","Male", "Child", true,false,"23355");
			p.setId(0);
		u.setPatient(p);
        
		
		
		Specialty sp5 = new Specialty(0,"Oncology");
		Disease onco1_1 = new Disease(0,"Colon cancer");
		List<Disease> onco_diseases = new ArrayList<>();
		String onco_symp1_1 = "Constipation/Heart palpitations/Fever/Diarrhea/Pain/General malaise";
		List<String> onco_list_1_1 = Arrays.asList(onco_symp1_1.split("/"));
		List<String> onco_symptoms_list1_1 =  new ArrayList<String>(onco_list_1_1); 
		onco1_1.setSymptomsList(onco_symptoms_list1_1);
		onco_diseases.add(onco1_1);
		sp5.setDisease_list(onco_diseases);
		
		u.setSpecialty(sp5);
		
		/*	// DON'T KNOW IF THIS IS POSSIBLE --> LEAVE IT (ask Alberto next week)
			// The finality of this is to apply directly all the rules for 1 emergency case to obtain the 'severity_case' evaluated!!
			 * 
			KieSession ksession2 = kc.newKieSession("symptomsKS");
			ksession2.insert(sp5);
			ksession2.fireAllRules();
			System.out.println("AFTER\n" + sp5);
			ksession2.dispose();
		 */
		
        System.out.println(u);
    	ksession.insert(u);
    	ksession.fireAllRules();
        
        System.out.println("AFTER");
        System.out.println(u);
        ksession.dispose();
        
        
        
        // THIS PART DOES NOT WORK
        /*
        Location w6 = new Location("Mountain");
        
        Protocol p = new Protocol("info", Protocol.Type.SHIPMENT);
        
        Emergency u = new Emergency();
	        u.setLocation(w6);
	        u.setProtocol(p);
	        u.setSeverity(3);
	        
	        Integer sev = u.getSeverity();
	        
	        
        if (p.getProtocolType() != null & sev<=3) { 
        	
        	System.out.println(u);
        	
        	ksession.insert(u);
        	
        	ksession.fireAllRules();
            
            System.out.println("AFTER");
            
            System.out.println(u);
            
            ksession.dispose();
        	
        } else {
	        
        	System.out.println(u);
        	
        	ksession.insert(u);
        	
        	ksession.fireAllRules();
            
            System.out.println("AFTER");
            
            System.out.println(u);
            
            ksession.dispose();
        }
        
      */   
    }

    
}
