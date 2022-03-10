package droolsexample;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collection;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.rule.Rule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


/**
 *
 * @author alberto.gildelafuent
 */
public class Example {

    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        execute(ks, kc);
    }

    public static void execute(KieServices ks, KieContainer kc) {
        // From the container, a session is created based on
        // its definition and configuration in the META-INF/kmodule.xml file
        KieSession ksession = kc.newKieSession("HelloWorldKS");

        // Once the session is created, the application can interact with it
        



        // To set up a ThreadedFileLogger, so that the audit view reflects events whilst debugging,
        // uncomment the next line
        // KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( ksession, "./helloworld", 1000 );
        // The application can insert facts into the session
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        
        KieBase kb = ksession.getKieBase();
        Collection<KiePackage> kiepks = kb.getKiePackages();
        System.out.println(kiepks);
        
        
        Rule r = kb.getRule("defaultpkg", "Hello World");
        //System.out.println(r);
        ksession.insert(message);

		System.out.println(r);
        // and fire the rules
        ksession.fireAllRules();
        
        System.out.println(message);

        // and then dispose the session
        ksession.dispose();
        
    }

}
