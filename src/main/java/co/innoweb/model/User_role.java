package co.innoweb.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class User_role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "role_id",referencedColumnName = "id")
    @ManyToOne
    private Role role;

    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @ManyToOne
    private Customer customer;

    public User_role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "User_role{" +
                "id=" + id +
                ", role=" + role +
                ", customer=" + customer +
                '}';
    }
}
