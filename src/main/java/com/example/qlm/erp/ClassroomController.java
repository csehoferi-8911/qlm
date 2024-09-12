package com.example.qlm.erp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/classroom")
public class ClassroomController {

    private final SeatingArrangementService seatingArrangementService;

    @PostMapping("/seating")
    public ResponseEntity<String> calculateSeatingArrangements(@Valid @RequestBody ClassModel classModel) {

        int arrangements = seatingArrangementService.calculateSeatingArrangements(classModel);

        return ResponseEntity.status(HttpStatus.OK).body("Lehetséges ültetési párok száma: " + arrangements);
    }
}
