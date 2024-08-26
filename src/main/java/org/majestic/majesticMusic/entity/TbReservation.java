package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="TB_RESERVATION")
public class TbReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_RESERVATION")
    private int reservationId;

    @Column(name="CODE")
    private String code;

    @Column(name="RESERVATION_DATE")
    private LocalDateTime reservationDate;

    @ManyToOne
    @JoinColumn(name = "FK_CUSTOMER", nullable = false)
    private TbCustomer tbCustomer;

    @ManyToOne
    @JoinColumn(name = "FK_REHEARSAL_SPACE", nullable = false)
    private TbRehearsalSpace tbRehearsalSpace;

    @ManyToOne
    @JoinColumn(name = "FK_LK_SLOT_RESERVATION", nullable = false)
    private TbLkSlotReservation tbLkSlotReservation;

    @ManyToOne
    @JoinColumn(name = "FK_LK_STATUS_RESERVATION", nullable = false)
    private TbLkStatusReservation tbLkStatusReservation;

    //Getters and Setters

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TbCustomer getTbCustomer() {
        return tbCustomer;
    }

    public void setTbCustomer(TbCustomer tbCustomer) {
        this.tbCustomer = tbCustomer;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public TbRehearsalSpace getTbRehearsalSpace() {
        return tbRehearsalSpace;
    }

    public void setTbRehearsalSpace(TbRehearsalSpace tbRehearsalSpace) {
        this.tbRehearsalSpace = tbRehearsalSpace;
    }

    public TbLkSlotReservation getTbLkSlotReservation() {
        return tbLkSlotReservation;
    }

    public void setTbLkSlotReservation(TbLkSlotReservation tbLkSlotReservation) {
        this.tbLkSlotReservation = tbLkSlotReservation;
    }

    public TbLkStatusReservation getTbLkStatusReservation() {
        return tbLkStatusReservation;
    }

    public void setTbLkStatusReservation(TbLkStatusReservation tbLkStatusReservation) {
        this.tbLkStatusReservation = tbLkStatusReservation;
    }
}
