import com.example.booking.dal.BookingDAL;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingDAL bookingDAL;

    public List<Slot> getAvailableSlots(LocalDate date) {
        return bookingDAL.findAvailableSlots(date);
    }

    public void bookSlot(String email, Long slotId) {
        bookingDAL.bookSlot(email, slotId);
    }

    public List<Booking> getAllBookings() {
        return bookingDAL.findAllBookings();
    }
}