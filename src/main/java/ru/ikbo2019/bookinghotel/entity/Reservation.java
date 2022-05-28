package ru.ikbo2019.bookinghotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.ikbo2019.bookinghotel.entity.enums.BookingStatus;
import ru.ikbo2019.bookinghotel.security.entities.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@RequiredArgsConstructor
public class Reservation extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate start;

    private LocalDate end;

    @ManyToMany
    @JoinTable(
        name= "reservation_rooms",
        joinColumns = @JoinColumn(name= "reservation_id"),
        inverseJoinColumns = @JoinColumn(name="room_id"))
    private List<Room> reservationRooms;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
