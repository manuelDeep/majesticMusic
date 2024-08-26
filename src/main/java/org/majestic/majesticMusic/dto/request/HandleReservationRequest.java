package org.majestic.majesticMusic.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HandleReservationRequest {
    private int reservationId;
    private  boolean isApproved;
}
