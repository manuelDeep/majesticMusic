package org.majestic.majesticMusic.service;

import org.majestic.majesticMusic.dto.DetailReservationDTO;
import org.majestic.majesticMusic.dto.OutcomeDTO;
import org.majestic.majesticMusic.dto.request.GetCustomerReservationsListRequest;
import org.majestic.majesticMusic.dto.request.GetManagerReservationsListRequest;
import org.majestic.majesticMusic.dto.request.HandleReservationRequest;
import org.majestic.majesticMusic.dto.request.InsertReservationRequest;
import org.majestic.majesticMusic.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The ReservationService interface represents a handler that can process or manage reservations with various criteria.
 */
@Service
public interface ReservationService {
    /**
     * Insert the reservation with the data provided by the customer.
     * @param request Necessary information for reservation entry
     * @return Reservation object
     * @throws BusinessException Business exception
     */
    DetailReservationDTO insert(InsertReservationRequest request) throws BusinessException;

    /**
     * Return the list of reservations for the customer.
     * @param request Contains the filters and customer ID useful for the search.
     * @return Reservations list
     * @throws BusinessException Business exception
     */
    List<DetailReservationDTO> getReservations(GetCustomerReservationsListRequest request) throws BusinessException;

    /**
     * Return the list of reservations for the manager.
     * @param request Contains the filters and manager ID useful for the search.
     * @return List of rehearsal space reservations managed by the manager.
     * @throws BusinessException Business exception
     */
    List<DetailReservationDTO> getReservations(GetManagerReservationsListRequest request) throws BusinessException;

    /**
     * Return reservation detail
     * @param reservationId Reservation ID
     * @return Reservation object
     * @throws BusinessException Business exception
     */
    DetailReservationDTO get(int reservationId) throws BusinessException;

    /**
     * Return reservation detail
     * @param request Contains the reservation ID and the status set by the manager.
     * @return Outcome of update
     * @throws BusinessException Business exception
     */
    OutcomeDTO handleReservation(HandleReservationRequest request) throws BusinessException;
}
