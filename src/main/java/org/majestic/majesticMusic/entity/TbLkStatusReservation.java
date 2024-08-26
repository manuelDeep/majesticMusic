package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="TB_LK_STATUS_RESERVATION")
@Getter
@Setter
public class TbLkStatusReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_LK_STATUS_RESERVATION")
    private int lkStatusReservationId;

    @Column(name="CODE")
    private String code;

    @Column(name="DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "tbLkStatusReservation")
    private Set<TbReservation> reservations;
}
