package com.notyfyd.controller;

import java.util.List;


public class RoleResource {

	    private Long id;
	    private String name;
	    private String description;
	    private List<UserResource> users;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public List<UserResource> getUsers() {
			return users;
		}
		public void setUsers(List<UserResource> users) {
			this.users = users;
		}
	    
	    
}
