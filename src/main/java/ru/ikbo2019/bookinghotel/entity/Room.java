package ru.ikbo2019.bookinghotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.ikbo2019.bookinghotel.entity.enums.RoomType;
import ru.ikbo2019.bookinghotel.entity.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="rooms")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class Room extends BaseEntity {

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String desc;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    @JsonBackReference
    private Hotel hotel;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name = "number_of_rooms")
    private int numberRooms;

    @Column(name = "max_people")
    private int maxPeople;

    @Column(name = "free_date_start")
    private LocalDate freeDateStart;

    @Column(name = "free_date_end")
    private LocalDate freeDateEnd;

    @Column(name="price")
    private BigDecimal price;

    @JsonIgnore
    @ManyToMany(mappedBy="reservationRooms")
    private List<Reservation> reservations;
}
