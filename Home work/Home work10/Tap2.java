public interface HotelService {
    List<Hotel> getHotelList();
    List<Hotel> filterHotels(String criteria);
}

public interface BookingService {
    boolean bookRoom(String hotelId, String userId, Date startDate, Date endDate);
    boolean checkAvailability(String hotelId, Date startDate, Date endDate);
}

public class UIComponent {
    private HotelService hotelService;
    private BookingService bookingService;
    private UserManagementService userManagementService;

    public UIComponent(HotelService hotelService, BookingService bookingService, UserManagementService userManagementService) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
        this.userManagementService = userManagementService;
    }

    public void searchHotels() {
        List<Hotel> hotels = hotelService.getHotelList();
        // Display hotels to the user
    }

    public void bookRoom(String hotelId, Date startDate, Date endDate) {
        // Logic to initiate booking
        boolean success = bookingService.bookRoom(hotelId, "userId", startDate, endDate);
        if (success) {
            System.out.println("Booking successful!");
        }
    }
}
