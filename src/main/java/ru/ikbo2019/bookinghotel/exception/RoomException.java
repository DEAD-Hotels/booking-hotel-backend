package ru.ikbo2019.bookinghotel.exception;

/**
 * todo Document type BusinessException
 */
public class RoomException extends RuntimeException {
    public RoomException(String message) {
        super(message);
    }

    public RoomException(String message, Throwable cause) {
        super(message, cause);
    }
}
