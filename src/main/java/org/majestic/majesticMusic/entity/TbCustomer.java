package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="TB_CUSTOMER")
@Getter
@Setter
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
}
