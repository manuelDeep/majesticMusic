package org.majestic.majesticMusic.common;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.majestic.majesticMusic.entity.TbLkSlotReservation;
import org.majestic.majesticMusic.entity.TbLkStatusReservation;
import org.majestic.majesticMusic.entity.TbRehearsalSpace;
import org.springframework.stereotype.Service;
import jakarta.persistence.*;

/**
 * Component responsible for retrieving data based on certain filters.
 */
@Service
public class ReservationDataUtil {

    @PersistenceContext
    private EntityManager entityManager;

    public TbLkStatusReservation getStatusByCode (String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<TbLkStatusReservation> criteriaQuery = criteriaBuilder.createQuery(TbLkStatusReservation.class);

        Root<TbLkStatusReservation> statusReservationRoot = criteriaQuery.from(TbLkStatusReservation.class);

        //Set filter by code
        Predicate statusCodePredicate = criteriaBuilder.equal(statusReservationRoot.get("code"), code);
        criteriaQuery.where(statusCodePredicate);

        // Run query
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public TbLkSlotReservation getSlotByCode (String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<TbLkSlotReservation> criteriaQuery = criteriaBuilder.createQuery(TbLkSlotReservation.class);

        Root<TbLkSlotReservation> slotReservationRoot = criteriaQuery.from(TbLkSlotReservation.class);

        //Set filter by code
        Predicate slotCodePredicate = criteriaBuilder.equal(slotReservationRoot.get("code"), code);
        criteriaQuery.where(slotCodePredicate);

        // Run query
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public TbRehearsalSpace getRehearsalSpaceByCode (String code) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<TbRehearsalSpace> criteriaQuery = criteriaBuilder.createQuery(TbRehearsalSpace.class);

        Root<TbRehearsalSpace> rehearsalSpaceRoot = criteriaQuery.from(TbRehearsalSpace.class);

        //Set filter by code
        Predicate rehearsalSpaceCodePredicate = criteriaBuilder.equal(rehearsalSpaceRoot.get("name"), code);
        criteriaQuery.where(rehearsalSpaceCodePredicate);

        // Run query
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
