package org.majestic.majesticMusic.dto.request;

import org.majestic.majesticMusic.dto.BaseReservationDTO;

public class InsertReservationRequest extends BaseReservationDTO {
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
