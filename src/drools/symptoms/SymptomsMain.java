package drools.symptoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import pojos.*;;

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
		
		ksession.insert(u);
		
		
		
		/*
		 * 
		 * REMEMBER: The following objects in the App will be added automatically from Database
		 * 
		 * */
		
		//OTHER
		Protocol p1 = new Protocol(0,"Go to Urgencies unit for valoration",Protocol.Type.SHIPMENT); 
		Protocol p2 = new Protocol(1,"Connect to oxygen supply",Protocol.Type.INPLACE);
		
		//ONCOLOGY
		Protocol p3 = new Protocol(2,"Take paracetamol",Protocol.Type.ADVICE);
		Protocol p4 = new Protocol(3,"Connect to oxygen supply + Inject subcutaneous antipyretic medication",Protocol.Type.SHIPMENT);
		Protocol p5 = new Protocol(4,"Make appointment with doctor for further evaluation + Take medication and consider changes in status",Protocol.Type.ADVICE); //OTHER
		Protocol p6 = new Protocol(5,"Connect catheter + intravenous antifluid and pain medicaments",Protocol.Type.INPLACE);
		
		//TOXICOLOGY
		Protocol p7 = new Protocol(6, "Connect to oxygen supply + Control vomits + If the person begins to have seizures, administer first aid for these cases",Protocol.Type.SHIPMENT);
		Protocol p8 = new Protocol(7, "Examine and monitor the person's airway, breathing, and pulse. Start artificial respiration and CPR, if necessary.",Protocol.Type.INPLACE);
		Protocol p9 = new Protocol(8, "If the person vomits, clear the airways + Wrap a piece of cloth around your fingers before cleaning your mouth and throat + DO NOT make the person vomit (only if indicated) + Keep the person comfortable. Turn onto her left side.",Protocol.Type.ADVICE);
		Protocol p10 = new Protocol(9, "Apply cold to the affected zone + Quick transportation to hospital",Protocol.Type.SHIPMENT);
		
		//TRAUMATOLOGY
		Protocol p11 = new Protocol(10, "Go to Urgencies unit for valoration + Possible surgery intervention or limb immobilization",Protocol.Type.ADVICE);
		Protocol p12 = new Protocol(11, "Keep the person comfortable + Turn her onto her left side and stay there while you get or wait for medical help",Protocol.Type.ADVICE);
		Protocol p13 = new Protocol(12, "Apply burn ointment and cold in the affected area",Protocol.Type.ADVICE);
		
		
		//NEUROLOGY
		Protocol p14 = new Protocol(13,"Keep the person comfortable + Give water + Ensure access to fresh air + Try to make the person calm", Protocol.Type.ADVICE); //ptsd, migraine
		Protocol p15 = new Protocol(14,"Make space among person + Clear hard or sharp objects + Don't try to stop the movements + Place the person on side to clear to airways", Protocol.Type.INPLACE);//epilepsy
		Protocol p16 = new Protocol(15,"The fastest way to hospital", Protocol.Type.SHIPMENT);//meningities, stroke
		
		//TRAUMA2
		
		Protocol p17 = new Protocol(16,"Surgery intervention valoration if the affection is deep + Avoid touching the affected zone + Apply cold", Protocol.Type.SHIPMENT);
		Protocol p18 = new Protocol(17,"Do not move the limb until a professional arrives + Clean and cover wounds + Apply cold + Bone repositioning by experts + immobilization + Evaluation if possible surgery (arthroscopy or open surgery).", Protocol.Type.INPLACE);
		
		// CARDIOLOGY
		Protocol p19 = new Protocol(18, "Measure constants +  Nitroglicerine + Reanimation", Protocol.Type.SHIPMENT); // heart attack
		Protocol p20 = new Protocol(19, "Measure constants +  Oxygen + Diuretics", Protocol.Type.SHIPMENT); // heart failure severe
		Protocol p21 = new Protocol(20, "Measure constants +  Oxygen", Protocol.Type.INPLACE); // heart failure light
		Protocol p22 = new Protocol(21, "Tension measure + calm the pacient + hipotensive drug", Protocol.Type.INPLACE); // hipertensive crisis
		Protocol p23 = new Protocol(22, "Head elevation + ECG + Tension measure + Neuroprotector drugs", Protocol.Type.SHIPMENT); // ictus
		Protocol p24 = new Protocol(23, "Leg lift + Hydration", Protocol.Type.ADVICE); // syncope 
		Protocol p25 = new Protocol(24, "Leg lift + Hydration + ECG + Recommend to make appointment with doctor for further evaluation", Protocol.Type.INPLACE); // syncope old people
	
		//TRAUMA3
		Protocol p26 = new Protocol(25,"Apl Apply cold to the affected zone + ointment if needed + and avoid infecttions", Protocol.Type.ADVICE);
		Protocol p27 = new Protocol(26,"Do not move the limb + clean and cover wounds + cold +repositioning the bone by experts + anti-inflammatories", Protocol.Type.ADVICE);
		Protocol p28 = new Protocol(27,"Rest + Elevation of the limb + gentle stretching + cold + bandage + compression", Protocol.Type.SHIPMENT);
		Protocol p29 = new Protocol(28,"Do not move the limb + clean and cover wounds + cold + repositioning of the bone by experts + immobilization and rehabilitation + anti-inflammatories +You may need surgery (Arthoscopy or open surgery) +  possible use of splint", Protocol.Type.SHIPMENT);
		Protocol p30 = new Protocol(29,"Immobilization  + casting", Protocol.Type.SHIPMENT);
		Protocol p31 = new Protocol(30,"Urgently transfer to the nearest hospital + avoid suffocation + assisted respiration if needed + surgery", Protocol.Type.SHIPMENT);
		Protocol p32 = new Protocol(31,"Immobilization of the area + oxygenation maintenance + surgical stabilization + symptomatic care + prevent secondary injuries + maintain high blood pressure + corticosteroids + analgesics", Protocol.Type.SHIPMENT);
		Protocol p33 = new Protocol(32,"Direct compression + when bleeding stops bandage + elevate affected part + tourniquet + cauterization of the wound", Protocol.Type.SHIPMENT);
		Protocol p34 = new Protocol(33,"Apply cold + see if the abdomen is rigid or tender + stop bleeding + transfer quickly to the nearest hospital + surgery", Protocol.Type.SHIPMENT);
		

		// p17 has same index as p14 -----> CHANGE THIS
		
		//neurology protocol
		
		

		
		//Include here more protocols from excel `add them to the correspondent list
		
		
		List<Protocol> protocol_list = new ArrayList<>();
		protocol_list.add(p1);
		protocol_list.add(p2);
		protocol_list.add(p3);
		protocol_list.add(p4);
		protocol_list.add(p5);
		protocol_list.add(p6);
		protocol_list.add(p7);
		protocol_list.add(p8);
		protocol_list.add(p9);
		protocol_list.add(p10);
		protocol_list.add(p11);
		protocol_list.add(p12);
		protocol_list.add(p13);
		protocol_list.add(p14);
		protocol_list.add(p15);
		protocol_list.add(p16);
		protocol_list.add(p17);
		protocol_list.add(p18);
		protocol_list.add(p19);
		protocol_list.add(p20);
		protocol_list.add(p21);
		protocol_list.add(p22);
		protocol_list.add(p23);
		protocol_list.add(p24);
		protocol_list.add(p25);
		protocol_list.add(p26);
		protocol_list.add(p27);
		protocol_list.add(p28);
		protocol_list.add(p29);
		protocol_list.add(p30);
		protocol_list.add(p31);
		protocol_list.add(p32);
		protocol_list.add(p33);
		protocol_list.add(p34);
		

		
		u.setProtocol_list(protocol_list);

		
		//LOCATIONS
		
		Location w1 = new Location(0,"Home");
        Location w2 = new Location(1,"Transit");
        Location w3 = new Location(2,"Work place");
        Location w4 = new Location(3,"Mountain");
        Location w5 = new Location(4,"Beach");
        u.setLocation(w5);
		
        //SPECIALITIES
		Specialty sp1 = new Specialty(0,"Cardiology");
		Specialty sp2 = new Specialty(1,"Toxicology");
		Specialty sp3 = new Specialty(2,"Neurology");
		Specialty sp4 = new Specialty(3,"Traumatology");
		Specialty sp5 = new Specialty(4,"Oncology");
		Specialty sp6 = new Specialty(5,"Other");   // Esta es a�n cuestionable
		
		// DISEASES
		
		
		// OTHER
		List<Disease> other_diseases = new ArrayList<>();
		Disease other1 = new Disease(0,"Unknown (not urgent)");
		Disease other2 = new Disease(1,"Unknown (urgent)");
		
		// CARDIO
		List<Disease> cardio_diseases = new ArrayList<>();
		Disease cardio1 = new Disease(0,"Heart attack");
		Disease cardio2 = new Disease(1,"Heart failure");
		Disease cardio3 = new Disease(2,"Heart failure");
		Disease cardio4 = new Disease(3,"Hipertensive crisis");
		Disease cardio5 = new Disease(4,"Ictus");
		Disease cardio6= new Disease(5,"Syncope");
		Disease cardio7= new Disease(6,"Syncope");
		
		
	// Several cases for same Disease because some symptoms differ
		
		// ONCO
		List<Disease> onco_diseases = new ArrayList<>();
		Disease onco1_1 = new Disease(0,"Colon cancer");
		Disease onco1_2 = new Disease(1,"Colon cancer");
		Disease onco2_1 = new Disease(2,"Prostate cancer");
		Disease onco2_2 = new Disease(3,"Prostate cancer");
		Disease onco3_1 = new Disease(4,"Lung cancer");
		Disease onco3_2 = new Disease(5,"Lung cancer");
		Disease onco4_1 = new Disease(6,"Breast cancer");
		Disease onco4_2 = new Disease(7,"Breast cancer");
		Disease onco5_1= new Disease(8,"Leukemia");
		Disease onco5_2= new Disease(9,"Leukemia");
		
		
		// NEURO
		List<Disease> neuro_diseases = new ArrayList<>();
		Disease neuro1 = new Disease(0, "Stroke");
		Disease neuro2 = new Disease(1, "Epilepsy");
		Disease neuro3 = new Disease(2,"Migraine");
		Disease neuro4 = new Disease(3,"Ptsd");
		Disease neuro5 = new Disease(4, "Meningities");
		
		
		// TOXIC
		List<Disease> toxic_diseases = new ArrayList<>();
		Disease tox1 = new Disease(0,"Food poisoning");
		Disease tox2 = new Disease(1,"Drugs");
		Disease tox3 = new Disease(2,"Hangover");
		Disease tox4 = new Disease(3,"Medicament allergy");
		
		//TRAUMA
		List<Disease> traum_diseases = new ArrayList<>();
		Disease traum1 = new Disease(0,"First Degree Burn");
		Disease traum2 = new Disease(1,"Second Degree Burn");
		Disease traum3 = new Disease(2,"Third Degree Burn");
		Disease traum4 = new Disease(3,"Acute Dislocation");
		Disease traum5 = new Disease(4,"Chronic Dislocation");
		Disease traum6 = new Disease(5,"First Degree Sprain");
		Disease traum7 = new Disease(6,"Second Degree Sprain");				
		Disease traum8 = new Disease(7,"Third Degree Sprain");
		Disease traum9 = new Disease(8,"Complete Fracture");
		Disease traum10 = new Disease(9,"Green Stem Fracture");
		Disease traum11 = new Disease(10,"Comminuted Fracture");
		Disease traum12 = new Disease(11,"Open Fracture");
		Disease traum13 = new Disease(12,"Mild Head Trauma");
		Disease traum14 = new Disease(13,"Complete Spinal Cord Injury");
		Disease traum15 = new Disease(14,"Internal Bleeding");
		Disease traum16 = new Disease(15,"External Bleeding");
		Disease traum17 = new Disease(16,"Venous Hemorrhage");
		Disease traum18 = new Disease(17,"Arterial Bleeding");
		Disease traum19 = new Disease(18,"First Degree Bruise");				
		Disease traum20 = new Disease(19,"Second Degree Bruise");
		Disease traum21 = new Disease(20,"Third Degree Bruise");
		
		
		
		
		//Include here more diseases in a lists of correspondent specialities

		
		
		// NOW   --------->  CREATE LISTS OF SYMPTOMS (SYMPLIFY IT TO THE MAXIMUM)
			
		// CARDIOLOGY
		
		//HEART ATTACK
		String cardio_symp1 = "Chest pressure/Fatigue/Pain extends to the left arm/Disnea/Cold sweat"; 
		List<String> cardio_list_1 = Arrays.asList(cardio_symp1.split("/"));
		List<String> cardio_symptoms_list1 =  new ArrayList<String>(cardio_list_1); 
			// This allows to remove or add symptoms to the list of Strings (USEFUL FOR THE APPLICATION, NOT THE RULES)
		
		//HEART FAILURE
		String cardio_symp2 = "Phlegm/Swelling/Faints/Fatigue/Heart palpitations";
		List<String> cardio_list_2 = Arrays.asList(cardio_symp2.split("/"));
		List<String> cardio_symptoms_list2 =  new ArrayList<String>(cardio_list_2); 
		
		String cardio_symp3 = "Swelling/Faints/Fatigue";
		List<String> cardio_list_3 = Arrays.asList(cardio_symp3.split("/"));
		List<String> cardio_symptoms_list3 =  new ArrayList<String>(cardio_list_3); 
		
		//HIPERTENSIVE CRISIS
		String cardio_symp4 = "Vomits/Pain/Disnea/Confusion";
		List<String> cardio_list_4 = Arrays.asList(cardio_symp4.split("/"));
		List<String> cardio_symptoms_list4 =  new ArrayList<String>(cardio_list_4); 
		
		//ICTUS
		String cardio_symp5 = "Sudden numbness/Paralysis/Confusion/Difficulty speaking or undestand/Loss of vision/Loss of balance /Pain";
		List<String> cardio_list_5 = Arrays.asList(cardio_symp5.split("/"));
		List<String> cardio_symptoms_list5 =  new ArrayList<String>(cardio_list_5);
		
		//SYNCOPE
		String cardio_symp6 = "Pale skin/Daze/Tunnel vision/Warmth sensation/Cold sweat";
		List<String> cardio_list_6 = Arrays.asList(cardio_symp6.split("/"));
		List<String> cardio_symptoms_list6 =  new ArrayList<String>(cardio_list_6);
	
		
		cardio1.setSymptomsList(cardio_symptoms_list1);
			cardio_diseases.add(cardio1);
		cardio2.setSymptomsList(cardio_symptoms_list2);
			cardio_diseases.add(cardio2);
		cardio3.setSymptomsList(cardio_symptoms_list3);
			cardio_diseases.add(cardio3);
		cardio4.setSymptomsList(cardio_symptoms_list4);
			cardio_diseases.add(cardio4);
		cardio5.setSymptomsList(cardio_symptoms_list5);
			cardio_diseases.add(cardio5);
		cardio6.setSymptomsList(cardio_symptoms_list6);
			cardio_diseases.add(cardio6);
		cardio7.setSymptomsList(cardio_symptoms_list6);
			cardio_diseases.add(cardio7);
			
		sp1.setDisease_list(cardio_diseases);
		
		//sp1.getDisease_list().get(0);  //---> Corresponds to heart attack
		
		
		// TOXICOLOGY

		// Food Poisoning
		String tox_symp1 = "Fever/Chills/Diarrhea/Pain/Nausea/Headache/Heart rate acceleration/Skin redness/Vomits/Paralysis";
		List<String> tox_list_1 = Arrays.asList(tox_symp1.split("/"));
		List<String> tox_symptoms_list1 = new ArrayList<String>(tox_list_1);

		// Drugs
		String tox_symp2 = "Negative Mood/Vomits/Hyperactivity/Phlegmaticy/Reddened Sclera";
		List<String> tox_list_2 = Arrays.asList(tox_symp2.split("/"));
		List<String> tox_symptoms_list2 = new ArrayList<String>(tox_list_2);

		// Hangover
		String tox_symp3 = "Fatigue/Headache/Loss of appetite/Diarrhea/Nausea/Vomits/Loss of appetite/Headache";
		List<String> tox_list_3 = Arrays.asList(tox_symp3.split("/"));
		List<String> tox_symptoms_list3 = new ArrayList<String>(tox_list_3);

		// Allergies for medicamente
		String tox_symp4 = "Vomits/Runny Nose/Itching/Hives/Swelling/Skin Rash/Shortness of breath";
		List<String> tox_list_4 = Arrays.asList(tox_symp4.split("/"));
		List<String> tox_symptoms_list4 = new ArrayList<String>(tox_list_4);

		
		tox1.setSymptomsList(tox_symptoms_list1);
		toxic_diseases.add(tox1);
		tox2.setSymptomsList(tox_symptoms_list2);
		toxic_diseases.add(tox2);
		tox3.setSymptomsList(tox_symptoms_list3);
		toxic_diseases.add(tox3);
		tox4.setSymptomsList(tox_symptoms_list4);
		toxic_diseases.add(tox4);

		sp2.setDisease_list(toxic_diseases);
			
			
		// NEUROLOGY
			
			String neuro_symp1 = "Headache/Loss of vision/Loss of balance /Difficulty speaking or undestand/Leg or arm weakness";
			List<String> neuro_list_1 = Arrays.asList(neuro_symp1.split("/"));
			List<String> neuro_symptoms_list1 =  new ArrayList<String>(neuro_list_1); 
			
			String neuro_symp2 = "Staring at one point/Muscle construction/Loss of consciousness/Staring at one point";
			List<String> neuro_list_2 = Arrays.asList(neuro_symp2.split("/"));
			List<String> neuro_symptoms_list2 =  new ArrayList<String>(neuro_list_2);
			
			String neuro_symp3 = "Vomits/Headache/Fatigue/Sensitivity to light, smell or sound/Thirst /Mood changes";
			List<String> neuro_list_3 = Arrays.asList(neuro_symp3.split("/"));
			List<String> neuro_symptoms_list3 =  new ArrayList<String>(neuro_list_3);
			
			
			String neuro_symp4 = "Headache/Nausea/Pain/Chest pain/Negative Mood/Profused sweating/Difficulty breathing/Avoidence of feelings, thoughts or places";
			List<String> neuro_list_4 = Arrays.asList(neuro_symp4.split("/"));
			List<String> neuro_symptoms_list4 =  new ArrayList<String>(neuro_list_4);
			
			
			String neuro_symp5 = "Headache/Seizures/Fever/Rash/Sleepiness/Vomits/Neck or joints pain/Light sensivity";
			List<String> neuro_list_5 = Arrays.asList(neuro_symp5.split("/"));
			List<String> neuro_symptoms_list5 =  new ArrayList<String>(neuro_list_5);
			
			
			neuro1.setSymptomsList(neuro_symptoms_list1);
			neuro_diseases.add(neuro1);
			neuro2.setSymptomsList(neuro_symptoms_list2);
			neuro_diseases.add(neuro2);
			neuro3.setSymptomsList(neuro_symptoms_list3);
			neuro_diseases.add(neuro3);
			neuro4.setSymptomsList(neuro_symptoms_list4);
			neuro_diseases.add(neuro4);
			neuro5.setSymptomsList(neuro_symptoms_list5);
			neuro_diseases.add(neuro5);
			
			sp3.setDisease_list(neuro_diseases);
			
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
				
		
		//TRAUMATOLOGY
			// ---------> First Degree Burn
		String traum_symp1 = "Afect Epidermis/ Pain on Contact / Hypersensitivity / Redness of the skin / Inflammation";
		List<String> traum_list_1 = Arrays.asList(traum_symp1.split("/"));
		List<String> traum_symptoms_list1 =  new ArrayList<String>(traum_list_1);

			// ---------> Second Degree Burn
		String traum_symp2 = "Afect Epidermis and Dermis / Intense Pain / Touch hyperesthesia / Inflammation / Red dotted on off-white background / Blisters";
		List<String> traum_list_2 = Arrays.asList(traum_symp2.split("/"));
		List<String> traum_symptoms_list2 =  new ArrayList<String>(traum_list_2);

			// ---------> Third Degree Burn
		String traum_symp3 = "Deep Dermis / Organs and nerves affected / Dry and hard skin / White / Do not fell pain";
		List<String> traum_list_3 = Arrays.asList(traum_symp3.split("/"));
		List<String> traum_symptoms_list3 =  new ArrayList<String>(traum_list_3);

			// ---------> Acute Dislocation
		String traum_symp4 = "Dislodged joint / First time / After Trauma";
		List<String> traum_list_4 = Arrays.asList(traum_symp4.split("/"));
		List<String> traum_symptoms_list4 =  new ArrayList<String>(traum_list_4);

			// ---------> Chronic Dislocation
		String traum_symp5 = "Dislodged joint / Degradation of the soft joint parts / Difficulty to mantain bone in place / Chronic conditions";
		List<String> traum_list_5 = Arrays.asList(traum_symp5.split("/"));
		List<String> traum_symptoms_list5 =  new ArrayList<String>(traum_list_5);

			// ---------> First Degree Sprain
		String traum_symp6 = "Ligament not broken / Pain / Inflammation / Limited movement / Instability";
		List<String> traum_list_6 = Arrays.asList(traum_symp6.split("/"));
		List<String> traum_symptoms_list6 =  new ArrayList<String>(traum_list_6);

			// ---------> Second Degree Sprain
		String traum_symp7 = "Parcial broken Ligament / Pain / Inflammation / Limited movement / Instability / Hematoma";
		List<String> traum_list_7 = Arrays.asList(traum_symp7.split("/"));
		List<String> traum_symptoms_list7 =  new ArrayList<String>(traum_list_7);

			// ---------> Third Degree Sprain
		String traum_symp8 = "Broken Ligament / Pain / Inflammation / Limited movement / Instability / Hematoma";
		List<String> traum_list_8 = Arrays.asList(traum_symp8.split("/"));
		List<String> traum_symptoms_list8 =  new ArrayList<String>(traum_list_8);

			// ---------> Complete Fracture
		String traum_symp9 = "Bone broken in two / Deformation of the area / Inflammation/ Hematoma / Incapacitty of movement / Desorientation / Loss of consciousness / numbness / tingle / Pain";
		List<String> traum_list_9 = Arrays.asList(traum_symp9.split("/"));
		List<String> traum_symptoms_list9 =  new ArrayList<String>(traum_list_9);

			// ---------> Green Stem Fracture
		String traum_symp10 = "Fractured bone / Inflammation/ Hematoma / Incapacitty of movement / Desorientation / Loss of consciousness / numbness / tingle / Pain";
		List<String> traum_list_10 = Arrays.asList(traum_symp10.split("/"));
		List<String> traum_symptoms_list10 =  new ArrayList<String>(traum_list_10);

			// ---------> Comminuted Fracture
		String traum_symp11 = "Fractured bone in more than 1 area / Inflammation/ Hematoma / Incapacitty of movement / Desorientation / Loss of consciousness / numbness / tingle / Pain";
		List<String> traum_list_11 = Arrays.asList(traum_symp11.split("/"));
		List<String> traum_symptoms_list11 =  new ArrayList<String>(traum_list_11);

			// ---------> Open Fracture
		String traum_symp12 = "Broken skin / Bleed / Fractured bone/ Inflammation/ Hematoma / Incapacitty of movement / Desorientation / Loss of consciousness / numbness / tingle / Pain";
		List<String> traum_list_12 = Arrays.asList(traum_symp12.split("/"));
		List<String> traum_symptoms_list12 =  new ArrayList<String>(traum_list_12);

			// ---------> Mild Head Trauma
		String traum_symp13 = "Head pain / Loss of consciousness < 30min/ Seizures / Pupil dilation / Confusion / React to stimulous / Able to move / Ringing in the ears / Memory impairment / Blurred vision / Behavior change / difficulty moving";
		List<String> traum_list_13 = Arrays.asList(traum_symp13.split("/"));
		List<String> traum_symptoms_list13 =  new ArrayList<String>(traum_list_13);

			// ---------> Complete Spinal Cord Injury
		String traum_symp14 = "Paralysis / Lose of musscle tone / loss of sensivility / Automatic dysfunction below affected area";
		List<String> traum_list_14 = Arrays.asList(traum_symp14.split("/"));
		List<String> traum_symptoms_list14 =  new ArrayList<String>(traum_list_14);

			// ---------> Internal Bleeding
		String traum_symp15 = "Internal damaged organs and vessels";
		List<String> traum_list_15 = Arrays.asList(traum_symp15.split("/"));
		List<String> traum_symptoms_list15 =  new ArrayList<String>(traum_list_15);

			// ---------> External Bleeding
		String traum_symp16 = "Syncope / hypovolemic shock / Anemia";
		List<String> traum_list_16 = Arrays.asList(traum_symp16.split("/"));
		List<String> traum_symptoms_list16 =  new ArrayList<String>(traum_list_16);

			// ---------> External Bleeding
        String traum_symp17 = "Dark red blood / easier to control than arterial ones / Dizziness / lightheadedness / extreme paleness / bleeding from the mouth or rectum";
        List<String> traum_list_17 = Arrays.asList(traum_symp17.split("/"));
        List<String> traum_symptoms_list17 =  new ArrayList<String>(traum_list_17);

			// ---------> Arterial Bleeding
        String traum_symp18 = "Abundant and intermittent discharge of blood brigth red / Dizziness / lightheadedness / extreme paleness / bleeding from the mouth or rectum";
        List<String> traum_list_18 = Arrays.asList(traum_symp18.split("/"));
        List<String> traum_symptoms_list18 =  new ArrayList<String>(traum_list_18);

			// ---------> First Degree Bruise
		String traum_symp19 = "Ecchymosis / Redness of the skin / Moderated pain / Inflammation / Hematoma / Not broken skin";
		List<String> traum_list_19 = Arrays.asList(traum_symp19.split("/"));
		List<String> traum_symptoms_list19 =  new ArrayList<String>(traum_list_19);

			// ---------> Second Degree Bruise
		String traum_symp20 = "Blood extravasation / Ecchymosis / Redness of the skin / Moderated pain / Inflammation / Hematoma / Not broken skin";
		List<String> traum_list_20 = Arrays.asList(traum_symp20.split("/"));
		List<String> traum_symptoms_list20 =  new ArrayList<String>(traum_list_20);

			// ---------> Third Degree Bruise
		String traum_symp21 = "Deep Organ and Tissues damage / Fractured / Broken larger vessels / Blood extravasation / Ecchymosis / Redness of the skin / Several pain / Inflammation / Hematoma / Not broken skin";
		List<String> traum_list_21 = Arrays.asList(traum_symp21.split("/"));
		List<String> traum_symptoms_list21 =  new ArrayList<String>(traum_list_21);

		traum1.setSymptomsList(traum_symptoms_list1);
		traum_diseases.add(traum1);
		traum2.setSymptomsList(traum_symptoms_list2);
		traum_diseases.add(traum2);
		traum3.setSymptomsList(traum_symptoms_list3);
		traum_diseases.add(traum3);
		traum4.setSymptomsList(traum_symptoms_list4);
		traum_diseases.add(traum4);
		traum5.setSymptomsList(traum_symptoms_list5);
		traum_diseases.add(traum5);
		traum6.setSymptomsList(traum_symptoms_list6);
		traum_diseases.add(traum6);
		traum7.setSymptomsList(traum_symptoms_list7);
		traum_diseases.add(traum7);
		traum8.setSymptomsList(traum_symptoms_list8);
		traum_diseases.add(traum8);
		traum9.setSymptomsList(traum_symptoms_list9);
		traum_diseases.add(traum9);
		traum10.setSymptomsList(traum_symptoms_list10);
		traum_diseases.add(traum10);
		traum11.setSymptomsList(traum_symptoms_list11);
		traum_diseases.add(traum11);
		traum12.setSymptomsList(traum_symptoms_list12);
		traum_diseases.add(traum12);
		traum13.setSymptomsList(traum_symptoms_list13);
		traum_diseases.add(traum13);
		traum14.setSymptomsList(traum_symptoms_list14);
		traum_diseases.add(traum14);
		traum15.setSymptomsList(traum_symptoms_list15);
		traum_diseases.add(traum15);
		traum16.setSymptomsList(traum_symptoms_list16);
		traum_diseases.add(traum16);
		traum17.setSymptomsList(traum_symptoms_list17);
		traum_diseases.add(traum17);
		traum18.setSymptomsList(traum_symptoms_list18);
		traum_diseases.add(traum18);
		traum19.setSymptomsList(traum_symptoms_list19);
		traum_diseases.add(traum19);
		traum20.setSymptomsList(traum_symptoms_list20);
		traum_diseases.add(traum20);
		traum21.setSymptomsList(traum_symptoms_list21);
		traum_diseases.add(traum21);

		sp4.setDisease_list(traum_diseases);
		
		
		// OTHER
		
		String other_symp1 = "Fever/Fatigue/Sweating";
		List<String> other_list_1 = Arrays.asList(other_symp1.split("/"));
		List<String> other_symptoms_list1 =  new ArrayList<String>(other_list_1); 
			// This allows to remove or add symptoms to the list of Strings (USEFUL FOR THE APPLICATION, NOT THE RULES)
		
		String other_symp2 = "Fever/Pain/Fatigue/Sweating";
		List<String> other_list_2 = Arrays.asList(other_symp2.split("/"));
		List<String> other_symptoms_list2 =  new ArrayList<String>(other_list_2); 
		
		other1.setSymptomsList(other_symptoms_list1);
			other_diseases.add(other1);
		other2.setSymptomsList(other_symptoms_list2);
			other_diseases.add(other2);
		
		sp6.setDisease_list(other_diseases);
		
		
			
		// To compare the list of symptoms avoiding the order ----> Needed for the interface NOT rules
	/*
		Collections.sort(list_1);
		Collections.sort(symptoms_list);
		System.out.println(list_1.equals(symptoms_list));
	*/		
		
		
	// STEPS
	// 1. WE SPECIFY THE SPECIALITY

		u.setSpecialty(sp5);

		
	// 2. WE SPECIFY THE SYMPTOMS OF THIS CASE (NOT THE OVERALL FROM ABOVE)
		// In this case I will choose the ones from 'onco_symptoms_list5_2' that correspond to index 9 of the disease_list
		

		Disease select = sp5.getDisease_list().get(0);  //We do this to only specify a single symptom list associated to 1 RULE and 1 DISEASE

		u.setDisease(select);
		
		Emergency test = new Emergency(1,2,"oskdoks", 2);
		test.setSpecialty(sp6);
		
		System.out.println("BEFORE\n" +  test);
		
		ksession.insert(test);
		
		
		ksession.fireAllRules();
		System.out.println("AFTER\n" +  test);
		
		ksession.dispose();
		
	}
	
}
