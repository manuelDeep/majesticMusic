package org.majestic.majesticMusic.controller.v1;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.majestic.majesticMusic.dto.DetailReservationDTO;
import org.majestic.majesticMusic.dto.FiltersDTO;
import org.majestic.majesticMusic.dto.OutcomeDTO;
import org.majestic.majesticMusic.dto.request.GetCustomerReservationsListRequest;
import org.majestic.majesticMusic.dto.request.GetManagerReservationsListRequest;
import org.majestic.majesticMusic.dto.request.HandleReservationRequest;
import org.majestic.majesticMusic.dto.request.InsertReservationRequest;
import org.majestic.majesticMusic.exception.BusinessException;
import org.majestic.majesticMusic.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/reservation")
@Tag(name = "Reservation", description = "Operations related to reservations")
class ReservationControllerV1 {

    @Autowired
    ReservationService reservationService;

    /**
     * Insert the reservation with the data provided by the customer.
     *
     * @param request Necessary information for reservation entry
     * @return Reservation object
     * @throws BusinessException Business exception
     */
    @PostMapping("/insert")
    public DetailReservationDTO insert(@RequestBody InsertReservationRequest request) throws BusinessException {
        return reservationService.insert(request);
    }

    /**
     * Return the list of reservations for the customer.
     *
     * @param customerId Customer Id
     * @param code Reservation code
     * @param reservationDateFrom Reservation start date
     * @param reservationDateTo Reservation end date
     * @return List of rehearsal space reservations managed by the manager.
     * @throws BusinessException Business exception
     */
    @GetMapping("/get-customer-reservations")
    public List<DetailReservationDTO> getCustomerReservations(@RequestParam(required = true) int customerId, @RequestParam(required = false) String code, @RequestParam(required = false) LocalDateTime reservationDateFrom, @RequestParam(required = false) LocalDateTime reservationDateTo) throws BusinessException {
        GetCustomerReservationsListRequest request = new GetCustomerReservationsListRequest();
        request.setCustomerId(customerId);

        if((code != null && !code.isEmpty()) || reservationDateFrom != null || reservationDateTo != null ) {
            FiltersDTO filters = new FiltersDTO();
            filters.setCode(code);
            filters.setReservationDateFrom(reservationDateFrom);
            filters.setReservationDateTo(reservationDateTo);
            request.setFilters(filters);
        }

        return reservationService.getReservations(request);
    }

    /**
     * Return the list of reservations for the manager.
     *
     * @param managerId ManagerId
     * @param code Reservation code
     * @param reservationDateFrom Reservation start date
     * @param reservationDateTo Reservation end date
     * @return List of rehearsal space reservations managed by the manager.
     * @throws BusinessException Business exception
     */
    @GetMapping("/get-manager-reservations")
    public List<DetailReservationDTO> getManagerReservations(@RequestParam(required = true) int managerId, @RequestParam(required = false) String code, @RequestParam(required = false) LocalDateTime reservationDateFrom, @RequestParam(required = false) LocalDateTime reservationDateTo) throws BusinessException {
        GetManagerReservationsListRequest request = new GetManagerReservationsListRequest();
        request.setManagerId(managerId);

        if((code != null && !code.isEmpty()) || reservationDateFrom != null || reservationDateTo != null ) {
            FiltersDTO filters = new FiltersDTO();
            filters.setCode(code);
            filters.setReservationDateFrom(reservationDateFrom);
            filters.setReservationDateTo(reservationDateTo);
            request.setFilters(filters);
        }

        return reservationService.getReservations(request);
    }

    /**
     * Return reservation detail
     *
     * @param reservationId Reservation ID
     * @return Reservation object
     * @throws BusinessException Business exception
     */
    @GetMapping("/get")
    public DetailReservationDTO get(@RequestParam(required = true) int reservationId) throws BusinessException {
        return reservationService.get(reservationId);
    }

    /**
     * Return reservation detail
     * @param request contains reservation id and reservation status.
     * @throws BusinessException Business exception
     */
    @PostMapping("/update-status")
    public OutcomeDTO handleReservation(@RequestBody HandleReservationRequest request) throws BusinessException {
        return reservationService.handleReservation(request);
    }
}
