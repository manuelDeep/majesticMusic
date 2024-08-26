package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="TB_REHEARSAL_SPACE")
public class TbRehearsalSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_REHEARSAL_SPACE")
    private int rehearsalSpaceId;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "FK_MANAGER", nullable = false)
    private TbManager tbManager;

    @OneToMany(mappedBy = "tbRehearsalSpace")
    private Set<TbReservation> reservations;

    //Getters and Setters

    public int getRehearsalSpaceId() {
        return rehearsalSpaceId;
    }

    public void setRehearsalSpaceId(int rehearsalSpaceId) {
        this.rehearsalSpaceId = rehearsalSpaceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TbManager getTbManager() {
        return tbManager;
    }

    public void setTbManager(TbManager tbManager) {
        this.tbManager = tbManager;
    }

    public Set<TbReservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<TbReservation> reservations) {
        this.reservations = reservations;
    }
}
