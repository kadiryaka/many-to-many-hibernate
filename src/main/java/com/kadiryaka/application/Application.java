package com.kadiryaka.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;

import com.kadiryaka.entity.Program;
import com.kadiryaka.entity.Advisor;
import com.kadiryaka.entity.Contact;

public class Application {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Advisor advisor = new Advisor();
		advisor.setName("Mr.Richardson Hoca");
		advisor.setAge(35L);
		
		List<Program> programList = new ArrayList<Program>();
		Program program = createProgram();
		Program program2 = createProgram();
		programList.add(program);
		programList.add(program2);
		advisor.setProgramList(programList);
		
		List<Contact> contactList = new ArrayList<Contact>();
		Contact contact = createContact(advisor);
		Contact contact2 = createContact(advisor);
		contactList.add(contact);
		contactList.add(contact2);
		advisor.setContactList(contactList);
		
		session.save(advisor);
		
		session.getTransaction().commit();
		
		Advisor dbAdvisor = (Advisor)session.get(Advisor.class, advisor.getId());
		
		System.out.println("Program name through Advisor object = " + dbAdvisor.getProgramList().get(0).getProgramName());
		Program dbProgram = (Program)session.get(Program.class, program.getId());
		//Program(dbProgram) object can't access to Advisor information. 
		
		System.out.println("Contact phone number through Advisor object = " + dbAdvisor.getContactList().get(0).getPhoneNumber());
		//Contact object can access to Advisor information. 
		Contact dbContact = (Contact)session.get(Contact.class, contact.getId());
		System.out.println("Advisor name through Contact object = " + dbContact.getAdvisor().getName());
		
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

}
