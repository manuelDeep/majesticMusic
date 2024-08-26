package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;

@Entity
@Table(name="TB_LK_STATUS_RESERVATION")
public class TbLkStatusReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_LK_STATUS_RESERVATION")
    private int lkStatusReservationId;

    @Column(name="CODE")
    private String code;

    @Column(name="DESCRIPTION")
    private String description;

//    @OneToMany(mappedBy = "tbLkStatusReservation")
//    private Set<TbReservation> reservations;

    //Getters and Setters

    public int getLkStatusReservationId() { return lkStatusReservationId; }

    public void setLkStatusReservationId(int lkStatusReservationId) { this.lkStatusReservationId = lkStatusReservationId; }

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

//    public Set<TbReservation> getReservations() {
//        return reservations;
//    }

//    public void setReservations(Set<TbReservation> reservations) {
//        this.reservations = reservations;
//    }
}
