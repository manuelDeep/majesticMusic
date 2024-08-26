package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="TB_MANAGER")
@Getter
@Setter
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
}
