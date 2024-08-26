package org.majestic.majesticMusic.dto;

import java.time.LocalDateTime;

public class DetailReservationDTO extends BaseReservationDTO {
    private int reservationId;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
