package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="TB_MANAGER")
public class TbManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_MANAGER")
    private int managerId;

    @Column(name="FIRSTNAME")
    private String firstName;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="TELEPHONE")
    private String telephone;

    @OneToMany(mappedBy = "tbManager")
    private Set<TbRehearsalSpace> rehearsalSpaces;

    //Getters and Setters

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
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

    public Set<TbRehearsalSpace> getRehearsalSpaces() {
        return rehearsalSpaces;
    }

    public void setRehearsalSpaces(Set<TbRehearsalSpace> rehearsalSpaces) {
        this.rehearsalSpaces = rehearsalSpaces;
    }
}
