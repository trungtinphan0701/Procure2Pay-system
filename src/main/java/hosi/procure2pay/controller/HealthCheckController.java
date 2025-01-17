// Controller to check if user is running properly or not
package hosi.procure2pay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthCheckController {
    @GetMapping("/api/v1/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("User service is up and running");
    }
}
