package org.majestic.majesticMusic.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FiltersDTO {
    private String code;
    private LocalDateTime reservationDateFrom;
    private LocalDateTime reservationDateTo;
}
