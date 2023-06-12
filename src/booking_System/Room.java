package booking_System;

public class Room {
	private int roomNumber;
    private boolean isAvailable;
    private String host;
    private String startTime;
    private String endTime;
    private boolean hasChairBooking;

    public Room(int number) {
        roomNumber = number;
        isAvailable = true;
        hasChairBooking = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isRoomAvailable() {
        return isAvailable;
    }

    public void setRoomAvailability(boolean availability) {
        isAvailable = availability;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String roomHost) {
        host = roomHost;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String time) {
        startTime = time;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String time) {
        endTime = time;
    }

    public boolean hasBookingChair() {
        return hasChairBooking;
    }

    public void setBookingChair(boolean booking) {
        hasChairBooking = booking;
    }


}
