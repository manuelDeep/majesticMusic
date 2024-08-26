package org.majestic.majesticMusic.service.impl;

import jakarta.persistence.criteria.*;
import org.majestic.majesticMusic.common.Constants;
import org.majestic.majesticMusic.common.ReservationDataUtil;
import org.majestic.majesticMusic.common.Utils;
import org.majestic.majesticMusic.dto.DetailReservationDTO;
import org.majestic.majesticMusic.dto.FiltersDTO;
import org.majestic.majesticMusic.dto.OutcomeDTO;
import org.majestic.majesticMusic.dto.request.GetCustomerReservationsListRequest;
import org.majestic.majesticMusic.dto.request.GetManagerReservationsListRequest;
import org.majestic.majesticMusic.dto.request.HandleReservationRequest;
import org.majestic.majesticMusic.dto.request.InsertReservationRequest;
import org.majestic.majesticMusic.entity.*;
import org.majestic.majesticMusic.exception.BusinessException;
import org.majestic.majesticMusic.exception.HttpErrorCode;
import org.majestic.majesticMusic.exception.HttpStatusCode;
import org.majestic.majesticMusic.repository.CustomerRepository;
import org.majestic.majesticMusic.repository.ReservationRepository;

import org.majestic.majesticMusic.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import static org.majestic.majesticMusic.exception.HttpErrorCode.*;
import static org.majestic.majesticMusic.exception.HttpStatusCode.*;

@Service
public class ReservationServiceImpl implements ReservationService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationDataUtil reservationDataUtil;

    /**
     * Insert the reservation with the data provided by the customer.
     *
     * @param request Necessary information for reservation entry
     * @return Reservation object
     * @throws BusinessException Business exception
     */
    @Override
    public DetailReservationDTO insert(InsertReservationRequest request) throws BusinessException {

        try {
            TbReservation tbReservation = createTbReservation(request);

            TbReservation savedReservation = reservationRepository.save(tbReservation);

            savedReservation.setCode(Utils.generateCode(savedReservation.getReservationId()));

            reservationRepository.save(savedReservation);

            return createDetailReservationByRecord(savedReservation);
        }
        catch (BusinessException ex) {
            System.err.println("Error during the insertion of the reservation: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Return the list of reservations for the customer.
     *
     * @param request Contains the filters and customer ID useful for the search.
     * @return Reservations list
     * @throws BusinessException Business exception
     */
    @Override
    public List<DetailReservationDTO> getReservations(GetCustomerReservationsListRequest request) throws BusinessException {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<TbReservation> criteriaQuery = criteriaBuilder.createQuery(TbReservation.class);

            Root<TbReservation> reservationRoot = criteriaQuery.from(TbReservation.class);

            // Join with customer
            Join<TbReservation, TbCustomer> customerJoin = reservationRoot.join("tbCustomer");

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(criteriaBuilder.equal(customerJoin.get("idCustomer"), request.getCustomerId()));

            //TODO check
            predicates = checkFilters(criteriaBuilder, reservationRoot, predicates, request.getFilters());

            criteriaQuery.where(predicates.toArray(new Predicate[0]));
            List<TbReservation> reservations = entityManager.createQuery(criteriaQuery).getResultList();

            return reservations.stream().map(this::createDetailReservationByRecord).toList();
        }
        catch (BusinessException ex) {
            System.err.println("Error during get reservations customer list: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Return the list of reservations for the manager.
     *
     * @param request Contains the filters and manager ID useful for the search.
     * @return List of rehearsal space reservations managed by the manager.
     * @throws BusinessException Business exception
     */
    @Override
    public List<DetailReservationDTO> getReservations(GetManagerReservationsListRequest request) throws BusinessException {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<TbReservation> criteriaQuery = criteriaBuilder.createQuery(TbReservation.class);

            Root<TbReservation> reservationRoot = criteriaQuery.from(TbReservation.class);
            // Join with rehearsal space
            Join<TbReservation, TbRehearsalSpace> rehearsalSpaceJoin = reservationRoot.join("tbRehearsalSpace");

            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(rehearsalSpaceJoin.get("tbManager").get("idManager"), request.getManagerId()));

            //TODO check
            predicates = checkFilters(criteriaBuilder, reservationRoot, predicates, request.getFilters());

            //TODO check
            criteriaQuery
                    .select(reservationRoot)
                    .where(predicates.toArray(new Predicate[0]));

            List<TbReservation> reservations = entityManager.createQuery(criteriaQuery).getResultList();

            return reservations.stream().map(this::createDetailReservationByRecord).toList();
        }
        catch (BusinessException ex) {
            System.err.println("Error during get reservations manager list: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Return reservation detail
     *
     * @param reservationId Reservation ID
     * @return Reservation object
     * @throws BusinessException Business exception
     */
    @Override
    public DetailReservationDTO get(int reservationId) throws BusinessException {
        try {
            TbReservation tbReservation = reservationRepository.getReferenceById(reservationId);

            return createDetailReservationByRecord(tbReservation);
        }
        catch (BusinessException ex) {
            System.err.println("Error during get reservation detail: " + ex.getMessage());
            throw ex;
        }
    }

    /**
     * Return reservation detail
     *
     * @param request Contains the reservation ID and the status set by the manager.
     * @return Outcome of update
     * @throws BusinessException Business exception
     */
    @Override
    public OutcomeDTO handleReservation(HandleReservationRequest request) throws BusinessException {
        try {
            TbReservation tbReservation = reservationRepository.getReferenceById(request.getReservationId());

            String statusCode = request.isApproved() ? Constants.Reservation.STATUS_APPROVED : Constants.Reservation.STATUS_REJECTED;

            TbLkStatusReservation tbLkStatusReservation = reservationDataUtil.getStatusByCode(statusCode);
            tbReservation.setTbLkStatusReservation(tbLkStatusReservation);

            reservationRepository.save(tbReservation);

            OutcomeDTO response = new OutcomeDTO();
            response.setOutcome(true);
            response.setDescription("Status successfully updated");

            return response;
        }
        catch (BusinessException ex) {
            System.err.println("Error during reservation status update: " + ex.getMessage());
            OutcomeDTO response = new OutcomeDTO();
            response.setOutcome(false);
            response.setDescription("Error during status update");

            return response;
        }
    }

    // Private methods
    private TbReservation createTbReservation(InsertReservationRequest request) {
        TbLkStatusReservation tbLkStatusReservation = reservationDataUtil.getStatusByCode(Constants.Reservation.STARTING_STATUS_CODE);
        TbLkSlotReservation tbLkSlotReservation = reservationDataUtil.getSlotByCode(request.getSlotCode());
        TbRehearsalSpace tbRehearsalSpace = reservationDataUtil.getRehearsalSpaceByCode(request.getRehearsalSpaceCode());
        TbCustomer tbCustomer = customerRepository.getReferenceById(request.getCustomerId());

        TbReservation tbReservation = new TbReservation();
        tbReservation.setTbLkStatusReservation(tbLkStatusReservation);
        tbReservation.setTbLkSlotReservation(tbLkSlotReservation);
        tbReservation.setTbRehearsalSpace(tbRehearsalSpace);
        tbReservation.setTbCustomer(tbCustomer);
        tbReservation.setReservationDate(request.getReservationDate());
        tbReservation.setCode(Utils.generateCode(0));

        return tbReservation;
    }

    private DetailReservationDTO createDetailReservationByRecord (TbReservation tbReservation) {
        DetailReservationDTO detailReservationDTO = new DetailReservationDTO();
        detailReservationDTO.setReservationId(tbReservation.getReservationId());
        detailReservationDTO.setCode(tbReservation.getCode());
        detailReservationDTO.setReservationDate(tbReservation.getReservationDate());
        detailReservationDTO.setStatusReservationCode(tbReservation.getTbLkStatusReservation().getCode());
        detailReservationDTO.setSlotCode(tbReservation.getTbLkSlotReservation().getCode());
        detailReservationDTO.setRehearsalSpaceCode(tbReservation.getTbRehearsalSpace().getName());

        return  detailReservationDTO;
    }

    private List<Predicate> checkFilters (CriteriaBuilder criteriaBuilder, Root<TbReservation> reservationRoot, List<Predicate> predicates, FiltersDTO filter) {
        // Check filters
        if(filter != null) {
            // Check code filter
            if(filter.getCode() != null && !filter.getCode().isEmpty()) {
                predicates.add(criteriaBuilder.equal(reservationRoot.get("code"), filter.getCode()));
            } else {
                // Check date from filter
                if(filter.getReservationDateFrom() != null) {
                    predicates.add(criteriaBuilder.greaterThanOrEqualTo(reservationRoot.get("reservationDate"), filter.getReservationDateFrom()));
                }
                // Check date to filter
                if(filter.getReservationDateTo() != null) {
                    predicates.add(criteriaBuilder.lessThanOrEqualTo(reservationRoot.get("reservationDate"), filter.getReservationDateTo()));
                }
            }
        }

        return predicates;
    }
}
