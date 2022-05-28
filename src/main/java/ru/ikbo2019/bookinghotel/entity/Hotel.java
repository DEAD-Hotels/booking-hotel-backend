package ru.ikbo2019.bookinghotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.ikbo2019.bookinghotel.entity.enums.Rating;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "hotels")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Hotel extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    private String address;

    @Column(name = "hotel_phone")
    private String hotelPhone;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    @ToString.Exclude
    private City city;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Room> rooms = new ArrayList<>();

    @Column(name=" chipest_price")
    private BigDecimal chipestPrice;
}
