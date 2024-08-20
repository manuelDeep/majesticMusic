package org.majestic.majesticMusic.controller.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
class TestControllerV2 {
    @GetMapping("/test")
    public String hello() {
        return "Hello, World!";
    }
}
