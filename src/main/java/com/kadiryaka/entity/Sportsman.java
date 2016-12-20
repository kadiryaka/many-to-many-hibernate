package com.kadiryaka.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Table(name = "T_SPORTSMAN")
@Entity
public class Sportsman implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SPORTSMAN_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="sportmanList")
	private Set<Advisor> advisorList = new HashSet<Advisor>();

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

	public Set<Advisor> getAdvisorList() {
		return advisorList;
	}

	public void setAdvisorList(Set<Advisor> advisorList) {
		this.advisorList = advisorList;
	}
	
}