package org.majestic.majesticMusic.dto.request;

import org.majestic.majesticMusic.dto.ReservationsListBaseDTO;

public class GetManagerReservationsListRequest extends ReservationsListBaseDTO {
    private int managerId;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
}
