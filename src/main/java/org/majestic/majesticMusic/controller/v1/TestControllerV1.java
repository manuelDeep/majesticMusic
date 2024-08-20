package org.majestic.majesticMusic.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
class TestControllerV1 {
    @GetMapping("/test")
    public String hello() {
        return "Hello, World!";
    }
}
