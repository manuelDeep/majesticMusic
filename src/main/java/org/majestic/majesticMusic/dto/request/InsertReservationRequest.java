package org.majestic.majesticMusic.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.majestic.majesticMusic.dto.BaseReservationDTO;

@Getter
@Setter
public class InsertReservationRequest extends BaseReservationDTO {
    private int customerId;
}
