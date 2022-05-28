package ru.ikbo2019.bookinghotel.service.reservation;

import org.springframework.http.ResponseEntity;
import ru.ikbo2019.bookinghotel.rest.dto.ReservationDto;

/**
 * Интерфейс для работы с этапом бронирования номеров
 */
public interface ReservationService {
    /**
     * Сохранить данные о резервировании номера в отеле
     * @param reservation - данные о резервировании
     * @return ответ на запрос
     */
    ResponseEntity<?> saveReservationInfo(ReservationDto reservation);
}
