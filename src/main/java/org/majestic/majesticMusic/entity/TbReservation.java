package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="TB_RESERVATION")
@Getter
@Setter
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
}
