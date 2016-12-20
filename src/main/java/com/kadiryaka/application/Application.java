package com.kadiryaka.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;

import com.kadiryaka.entity.Program;
import com.kadiryaka.entity.Sportsman;
import com.kadiryaka.entity.Advisor;
import com.kadiryaka.entity.Contact;

public class Application {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Advisor advisor = new Advisor();
		Random rnd = new Random();
		advisor.setName("Mr.Richardson Hoca" + rnd.nextInt(1000));
		advisor.setAge(35L);
		
		List<Program> programList = new ArrayList<Program>();
		Program program = createProgram();
		programList.add(program);
		advisor.setProgramList(programList);
		
		List<Contact> contactList = new ArrayList<Contact>();
		Contact contact = createContact(advisor);
		contactList.add(contact);
		advisor.setContactList(contactList);
		
		Set<Sportsman> sportsmanList = new HashSet<Sportsman>();
		Sportsman sportsman1 = createSportsman(advisor);
		sportsmanList.add(sportsman1);
		advisor.setSportmanList(sportsmanList);
		
		session.save(advisor);
		
		session.flush();
		
		Advisor dbAdvisor = (Advisor)session.get(Advisor.class, advisor.getId());
		
	    for (Iterator<Sportsman> it = dbAdvisor.getSportmanList().iterator(); it.hasNext(); ) {
	    	Sportsman f = it.next();
	    	System.out.println("sportsman name from Advisor = " + f.getName());
	    }
		
		Sportsman dbSportsman = (Sportsman)session.get(Sportsman.class, sportsman1.getId());
		
	    for (Iterator<Advisor> it = dbSportsman.getAdvisorList().iterator(); it.hasNext(); ) {
	    	Advisor f = it.next();
	    	System.out.println("advisor name from Sportsman = " + f.getName());
	    }
	    
	    session.getTransaction().commit();
		
		session.close();
		HibernateUtil.getSessionFactory().close();
	}
	
	public static Program createProgram() {
		Program program = new Program();
		Random rnd = new Random();
		program.setProgramName("Program" + rnd.nextInt(1000));
		return program;
	}
	
	public static Contact createContact(Advisor advisor) {
		Contact contact = new Contact();
		Random rnd = new Random();
		contact.setPhoneNumber("0535 971 64 " + (10 + rnd.nextInt(89)));
		contact.setAdvisor(advisor);
		return contact;
	}
	
	public static Sportsman createSportsman(Advisor advisor) {
		Sportsman sportsman = new Sportsman();
		Random rnd = new Random();
		sportsman.setName("Name" + rnd.nextInt(1000));
		Set<Advisor> advisorList = new HashSet<Advisor>();
		advisorList.add(advisor);
		sportsman.setAdvisorList(advisorList );
		return sportsman;
	}

}
