package io.bookingmonolith.booking.data.jpa.repositories;
 import io.bookingmonolith.booking.data.jpa.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, UUID>{


public BookingEntity findBookingByIdAndIsDeletedFalse(UUID id)
;

public List<BookingEntity> findAllByTripFlightIdAndIsDeletedFalse(UUID flightId)
;

}