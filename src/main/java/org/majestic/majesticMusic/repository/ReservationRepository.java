package org.majestic.majesticMusic.repository;

import org.majestic.majesticMusic.entity.TbReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<TbReservation, Integer> {
}
