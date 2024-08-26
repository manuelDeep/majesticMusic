package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="TB_LK_SLOT_RESERVATION")
public class TbLkSlotReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_LK_SLOT_RESERVATION")
    private int lkSlotReservationId;

    @Column(name="CODE")
    private String code;

    @Column(name="DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "tbLkSlotReservation")
    private Set<TbReservation> reservations;
    //Getters and Setters

    public int getLkSlotReservationId() {
        return lkSlotReservationId;
    }

    public void setLkSlotReservationId(int lkSlotReservationId) {
        this.lkSlotReservationId = lkSlotReservationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TbReservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<TbReservation> reservations) {
        this.reservations = reservations;
    }
}
