package ru.ikbo2019.bookinghotel.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ikbo2019.bookinghotel.rest.dto.ReservationDto;
import ru.ikbo2019.bookinghotel.service.reservation.ReservationService;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @PostMapping("/saveReservation")
    public ResponseEntity<?> saveReservation(@RequestBody ReservationDto request) {
        System.out.println(request);
        ResponseEntity<?> response = service.saveReservationInfo(request);
        return ResponseEntity.ok(response);
    }
}
