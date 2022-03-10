/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droolsexample.evaluation;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 *
 * @author alberto.gildelafuent
 */
public class Course {

    public static void main(String[] args) {

        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();
        
        KieSession ksession = kc.newKieSession("evaluationKS");
        
        Student s1 = new Student("S1", 6, 3.5f);
        Student s2 = new Student("S2", 4.5f, 4.5f);
        Student s3 = new Student("S3", 3, 7);
        Student s4 = new Student("S4", 6, 9);
        Student s5 = new Student("S5", 6, 1);
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        
        ksession.insert(s1);
        ksession.insert(s2);
        ksession.insert(s3);
        ksession.insert(s4);
        ksession.insert(s5);
        
        ksession.fireAllRules();
        
        System.out.println("AFTER");
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        
        ksession.dispose();
        
    }
}

