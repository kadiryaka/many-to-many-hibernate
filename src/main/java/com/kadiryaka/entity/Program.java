package com.kadiryaka.entity;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_PROGRAM")
public class Program implements Serializable {

	private static final long serialVersionUID = -6056426920596072711L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROGRAM_ID")
	private Long id;
	
	@Column(name = "NAME")
	private String programName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
}
