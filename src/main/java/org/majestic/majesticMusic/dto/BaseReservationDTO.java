package org.majestic.majesticMusic.dto;

import java.time.LocalDateTime;

public class BaseReservationDTO {
    private String code;
    private String rehearsalSpaceCode;
    private String slotCode;
    private String statusReservationCode;
    private LocalDateTime reservationDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRehearsalSpaceCode() {
        return rehearsalSpaceCode;
    }

    public void setRehearsalSpaceCode(String rehearsalSpaceCode) {
        this.rehearsalSpaceCode = rehearsalSpaceCode;
    }

    public String getSlotCode() {
        return slotCode;
    }

    public void setSlotCode(String slotCode) {
        this.slotCode = slotCode;
    }

    public String getStatusReservationCode() {
        return statusReservationCode;
    }

    public void setStatusReservationCode(String statusReservationCode) {
        this.statusReservationCode = statusReservationCode;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }
}
