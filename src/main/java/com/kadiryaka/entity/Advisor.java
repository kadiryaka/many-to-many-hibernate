package com.kadiryaka.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_ADVISOR")
public class Advisor implements Serializable {

	private static final long serialVersionUID = 2114871349738336499L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADVISOR_ID")
	private Long id;
	
	@Column(name = "U_NAME")
	private String name;
	
	@Column(name = "U_AGE")
	private Long age;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "ADVISOR_ID", nullable = false)
	List<Program> programList = new ArrayList<Program>();

	@OneToMany(cascade=CascadeType.ALL, mappedBy="advisor")
	List<Contact> contactList = new ArrayList<Contact>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="T_ADVISOR_SPORTSMAN", joinColumns=@JoinColumn(name = "ADVISOR_ID"), inverseJoinColumns=@JoinColumn(name = "SPORTSMAN_ID"))
	private Set<Sportsman> sportmanList = new HashSet<Sportsman>();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Program> getProgramList() {
		return programList;
	}

	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public Set<Sportsman> getSportmanList() {
		return sportmanList;
	}

	public void setSportmanList(Set<Sportsman> sportmanList) {
		this.sportmanList = sportmanList;
	}
	
}
