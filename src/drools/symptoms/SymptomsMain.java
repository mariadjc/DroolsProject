package drools.symptoms;

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

		KieSession ksession = kc.newKieSession("specialityKS");
		
		// DO WE NEED TO CONSIDER A CLASS SPECIALITY AND ASSOCIATE DIFFERENT ENUMS FOR DISEASE AND SYMPTOMS?????
			// BECAUSE WE ARE NOT REALLY DOING ANYTHING WITH THEM JUST ASSOCIATING TO SPECIALITY
		
		Speciality sp1 = new Speciality("Cardiology");
		Speciality sp2 = new Speciality("Toxicology");
		Speciality sp3 = new Speciality("Neurology");
		Speciality sp4 = new Speciality("Traumatology");
		Speciality sp5 = new Speciality("Oncology");
		Speciality sp6 = new Speciality("Other");   // Esta es aún cuestionable
		
		Disease d1 = new Disease("Heart attack");
		//AÑADIR AQUI ALGUNOS DISEASES DE EJEMPLO (O TODOS SI LO QUIERES DEJAR YA HECHO)
		
		Symptom s1 = new Symptom("Chest pain");
		
		ksession.insert(s1);
		ksession.insert(d1);
		ksession.insert(sp1);
		
		ksession.dispose();
		
		
		
		
		
	}
}
