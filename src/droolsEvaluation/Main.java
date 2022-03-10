/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droolsEvaluation;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import pojos.application.*;

public class Main {

    public static void main(String[] args) {


        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        KieSession ksession = kc.newKieSession("vechicleKS");
        
        //Urgency u1 = new Urgency();
        Location w1 = new Location("Indoors");
        
        //Patient p1 = new Patient(1);
        //Patient p2 = new Patient(2);
        
        /*Patient p2 = new Patient(2);
        Patient p3 = new Patient(3);
        Patient p4 = new Patient(4);
        Patient p5 = new Patient(5);*/
        
        //Symptom s1 = new Symptom ("chest pressure");
        
        System.out.println(w1);
        
        ksession.insert(w1);
        
        ksession.fireAllRules();
        
        System.out.println("AFTER");
        
        System.out.println(w1);
        
        ksession.dispose();
        
     
    
        
    }
}