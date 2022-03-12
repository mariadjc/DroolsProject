/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drools.displayVehicle;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

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
        
        Location w1 = new Location("Home");
        Location w2 = new Location("Transit");
        Location w3 = new Location("Work place");
        Location w4 = new Location("Mountain");
        Location w5 = new Location("Beach");
         
        System.out.println(w1);
    	
    	ksession.insert(w1);
    	
    	ksession.fireAllRules();
        
        System.out.println("AFTER");
        
        System.out.println(w1);
        
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
