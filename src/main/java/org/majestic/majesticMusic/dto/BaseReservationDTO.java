package org.majestic.majesticMusic.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseReservationDTO {
    private String code;
    private String rehearsalSpaceCode;
    private String slotCode;
    private String statusReservationCode;
    private LocalDateTime reservationDate;

}
