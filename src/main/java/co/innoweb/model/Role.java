package co.innoweb.model;

import javax.persistence.*;

@Entity
@Table(name = "privilege")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name", nullable = true, length = 30)
    private String role_name;


    @Column(name = "description", nullable = true, length = 30)
    private String description;

    public Role() {
    }

    public Role(String role_name) {
        this.role_name = role_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
