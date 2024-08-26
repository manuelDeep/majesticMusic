package org.majestic.majesticMusic.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FiltersDTO {
    private String code;
    private LocalDateTime reservationDateFrom;
    private LocalDateTime reservationDateTo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getReservationDateFrom() {
        return reservationDateFrom;
    }

    public void setReservationDateFrom(LocalDateTime reservationDateFrom) {
        this.reservationDateFrom = reservationDateFrom;
    }

    public LocalDateTime getReservationDateTo() {
        return reservationDateTo;
    }

    public void setReservationDateTo(LocalDateTime reservationDateTo) {
        this.reservationDateTo = reservationDateTo;
    }
}
