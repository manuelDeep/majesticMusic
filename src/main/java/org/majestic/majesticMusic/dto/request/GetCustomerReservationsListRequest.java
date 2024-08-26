package org.majestic.majesticMusic.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.majestic.majesticMusic.dto.ReservationsListBaseDTO;

@Getter
@Setter
public class GetCustomerReservationsListRequest extends ReservationsListBaseDTO {
    private int customerId;
}
