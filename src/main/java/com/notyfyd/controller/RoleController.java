package com.notyfyd.controller;

import com.notyfyd.entity.ConfidentialUser;
import com.notyfyd.entity.Role;
import com.notyfyd.entity.User;
import com.notyfyd.service.RoleService;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role/create")
    public ResponseEntity<Object> createRole(@RequestBody RoleResource roleResource) {
        return  roleService.addRole(mapToRole(roleResource));
    }
    @DeleteMapping("/role/delete/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id) {
        return roleService.deleteRole(id);
    }
    
    @PutMapping("/role/{id}")
    public ResponseEntity<Object> updateRole(@RequestBody RoleResource roleResource,@PathVariable Long id) {
        return roleService.updateRole(id,mapToRole(roleResource));
    }
    
    private Role mapToRole(RoleResource roleResource) {
    	Role role = new Role();
    	role.setId(roleResource.getId());
    	role.setDescription(roleResource.getDescription());
    	role.setName(roleResource.getName());
    	role.setUsers(roleResource.getUsers().stream().map(x->mapToUser(x)).collect(Collectors.toList()));
    	role.getUsers().forEach(x->{x.setFkUserRole(role);});
    	return role;
    }
    
    private User mapToUser(UserResource userResource){
  
    	if(userResource.getUserType().contains("secret")) {
    		User user = new ConfidentialUser();
    		user.setId(userResource.getId());
    		user.setFirstName(userResource.getFirstName());
    		user.setLastName(userResource.getLastName());
    		user.setMobile(userResource.getMobile());
    		user.setEmail(userResource.getEmail());
    		((ConfidentialUser) user).setTypeConfidential(userResource.getUserType());
    		return user;
    	}
    	return null;
    }
}