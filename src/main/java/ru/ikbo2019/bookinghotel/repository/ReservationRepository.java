package ru.ikbo2019.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ikbo2019.bookinghotel.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
