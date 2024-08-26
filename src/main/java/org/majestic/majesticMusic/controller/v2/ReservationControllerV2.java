package org.majestic.majesticMusic.controller.v2;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
@Tag(name = "Reservation", description = "Operations related to reservations")

class ReservationControllerV2 {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
