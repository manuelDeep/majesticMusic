package org.majestic.majesticMusic.dto.request;

import org.majestic.majesticMusic.dto.ReservationsListBaseDTO;

public class GetCustomerReservationsListRequest extends ReservationsListBaseDTO {
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
