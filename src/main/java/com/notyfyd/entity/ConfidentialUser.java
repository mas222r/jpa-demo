package com.notyfyd.entity;

import javax.persistence.Entity;

import javax.persistence.Table;


@Entity
@Table(name = "t_official_user")

//@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "t_official_user_fk"))
public class ConfidentialUser extends User {
	
	private String typeConfidential;
	
	
	
    public ConfidentialUser() {
		
	}

	public String getTypeConfidential() {
		return typeConfidential;
	}

	public void setTypeConfidential(String typeConfidential) {
		this.typeConfidential = typeConfidential;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfidentialUser that = (ConfidentialUser) o;

        if (!typeConfidential.equals(that.typeConfidential)) return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int result = typeConfidential.hashCode();
        
        return 31*result;
    }
}
