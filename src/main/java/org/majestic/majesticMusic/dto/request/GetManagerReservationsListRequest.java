package org.majestic.majesticMusic.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.majestic.majesticMusic.dto.ReservationsListBaseDTO;

@Getter
@Setter
public class GetManagerReservationsListRequest extends ReservationsListBaseDTO {
    private int managerId;
}
