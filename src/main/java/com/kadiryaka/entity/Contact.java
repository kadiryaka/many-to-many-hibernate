package com.kadiryaka.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_CONTACT")
public class Contact implements Serializable {

	private static final long serialVersionUID = -6056426920596072711L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
	private Long id;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@ManyToOne()
	@JoinColumn(name = "ADVISOR_ID")
	private Advisor advisor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}
	
}
