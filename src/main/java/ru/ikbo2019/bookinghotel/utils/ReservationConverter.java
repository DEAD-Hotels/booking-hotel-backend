package ru.ikbo2019.bookinghotel.utils;

import org.springframework.stereotype.Component;
import ru.ikbo2019.bookinghotel.entity.Reservation;
import ru.ikbo2019.bookinghotel.rest.dto.ReservationDto;

@Component
public class ReservationConverter implements DtoToEntity<ReservationDto, Reservation> {

    @Override
    public Reservation dtoToEntity(ReservationDto dto) {
        Reservation reservation = new Reservation();
        reservation.setStart(dto.getStartDate());
        reservation.setEnd(dto.getEndDate());
        reservation.setReservationRooms(dto.getRooms());
        reservation.setTotalPrice(dto.getTotalPrice());
        return reservation;
    }

    @Override
    public ReservationDto entityToDto(Reservation entity) {
        return null;
    }
}
