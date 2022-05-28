package ru.ikbo2019.bookinghotel.service.reservation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ikbo2019.bookinghotel.entity.Reservation;
import ru.ikbo2019.bookinghotel.entity.enums.BookingStatus;
import ru.ikbo2019.bookinghotel.exception.BusinessException;
import ru.ikbo2019.bookinghotel.repository.ReservationRepository;
import ru.ikbo2019.bookinghotel.repository.UserRepository;
import ru.ikbo2019.bookinghotel.rest.dto.ReservationDto;
import ru.ikbo2019.bookinghotel.security.entities.User;
import ru.ikbo2019.bookinghotel.service.room.RoomService;
import ru.ikbo2019.bookinghotel.utils.ReservationConverter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository repository;
    private final UserRepository userRepository;
    private final RoomService roomService;
    private final ReservationConverter converter;

    @Transactional
    @Override
    public ResponseEntity<?> saveReservationInfo(ReservationDto reservationDto) {
        Integer userId = reservationDto.getUserId();
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователя с ID: %s не существует", userId)));
        try {
            Reservation reservation = converter.dtoToEntity(reservationDto);
            reservation.setUser(user);
            reservation.setStatus(BookingStatus.CONFIRMED);
            repository.save(reservation);
        } catch (BusinessException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

        log.info("Обновление статуса номеров");
        roomService.updateRoomsStatus(reservationDto.getRooms());
        log.info("Обновление статуса номеров завершено");

        return ResponseEntity.ok("Бронирование успешно завершено!");
    }
}
