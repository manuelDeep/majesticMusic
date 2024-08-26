package org.majestic.majesticMusic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="TB_REHEARSAL_SPACE")
@Getter
@Setter
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
}
