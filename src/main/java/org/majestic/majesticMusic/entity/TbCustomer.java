package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="TB_CUSTOMER")
public class TbCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CUSTOMER")
    private int customerId;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="TELEPHONE")
    private String telephone;

    @OneToMany(mappedBy = "tbCustomer")
    private Set<TbReservation> reservations;

    //Getters and Setters

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<TbReservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<TbReservation> reservations) {
        this.reservations = reservations;
    }
}
