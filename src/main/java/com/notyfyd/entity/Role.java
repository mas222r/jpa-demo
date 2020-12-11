package com.notyfyd.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "t_role")
public class Role {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    /*
	 * @JoinColumn(name = "role_id" , foreignKey = @ForeignKey(name = "role_id_fk"),
	 * insertable = true, updatable = true)
	 */
    /*
     * @Cascade (value={CascadeType.SAVE_UPDATE,CascadeType.DELETE_ORPHAN}) 
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_role_id")
    @JsonManagedReference
    private List<User> users;
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
