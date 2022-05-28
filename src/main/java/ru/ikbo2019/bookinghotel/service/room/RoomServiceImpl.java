package ru.ikbo2019.bookinghotel.service.room;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ikbo2019.bookinghotel.entity.Room;
import ru.ikbo2019.bookinghotel.entity.enums.RoomType;
import ru.ikbo2019.bookinghotel.entity.enums.Status;
import ru.ikbo2019.bookinghotel.exception.RoomException;
import ru.ikbo2019.bookinghotel.repository.RoomRepository;
import ru.ikbo2019.bookinghotel.rest.dto.RoomDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;

    @Override
    public List<Room> getAllRoomsByStartDateAndEndDateAndCityName(RoomDto roomDto) {
/*        if (Objects.isNull(roomDto) || roomDto.getCityName().isEmpty() || Objects.isNull(roomDto.getFreeDateEnd())) {
            throw new RoomException("Ошибка валидации параметров");
        }*/
        return new ArrayList<>();
    }

    @Override
    public List<Map<RoomType, Long>> getNumberOfRoomsWithRoomTypes() {
        return repository.findNumberOfRoomsWithRoomTypes();
    }

    @Override
    public void updateRoomsStatus(List<Room> rooms) {
        rooms.forEach(room -> {
                room.setStatus(Status.BUSY);
                repository.save(room);
            });
    }
}
