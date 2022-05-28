package ru.ikbo2019.bookinghotel.utils;


public interface DtoToEntity<T, Q> {
    Q dtoToEntity(T dto);

    T entityToDto (Q entity);
}
