package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="TB_LK_SLOT_RESERVATION")
@Getter
@Setter
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
}
