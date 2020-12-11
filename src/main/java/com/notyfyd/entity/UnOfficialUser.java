package com.notyfyd.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "t_un_official_user")
//@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "t_un_official_user_fk"))
public class UnOfficialUser extends User {

	 private String unOfficialType;
	 
	
	 
	 public UnOfficialUser() {
			
		}

	public String getUnOfficialType() {
		return unOfficialType;
	}

	public void setUnOfficialType(String unOfficialType) {
		this.unOfficialType = unOfficialType;
	}

	
	 
}
