package booking_System;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomAllotmentSystem {
	
	private static class Scheduler {
		private List<Room> rooms;

	    public Scheduler() {
	        rooms = new ArrayList<>();
	    }

	    public void addRoom(Room room) {
	        rooms.add(room);
	    }

	    public  Room findRoomByNumber(int roomNumber) {
	        for (Room room : rooms) {
	            if (room.getRoomNumber() == roomNumber) {
	                return room;
	            }
	        }
	        return null;
	    }

	    public   void bookRoom(Room room, String host, String startTime, String endTime, boolean bookingChair) {
	        room.setRoomAvailability(false);
	        room.setHost(host);
	        room.setStartTime(startTime);
	        room.setEndTime(endTime);
	        room.setBookingChair(bookingChair);
	    }

	    public  void printRoomStatus(Room room) {
	        System.out.println("Room Number: " + room.getRoomNumber());
	        System.out.println("Availability: " + (room.isRoomAvailable() ? "Available" : "Booked"));
	        if (!room.isRoomAvailable()) {
	            System.out.println("Host: " + room.getHost());
	            System.out.println("Start Time: " + room.getStartTime());
	            System.out.println("End Time: " + room.getEndTime());
	            System.out.println("Chair Booking: " + (room.hasBookingChair() ? "Yes" : "No"));
	        }
	        System.out.println();
	    }

	}

	
	
	
	
	
	public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        // Create and add rooms
        Room room1 = new Room(101);
        Room room2 = new Room(102);
        Room room3 = new Room(103);
        scheduler.addRoom(room1);
        scheduler.addRoom(room2);
        scheduler.addRoom(room3);

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("============== Room Allotment System ==============");
            System.out.println("Room number started from 101");
            System.out.println("1. Book a room");
            System.out.println("2. Check room status");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    int roomNumber;
                    System.out.print("Enter room number: ");
                    roomNumber = scanner.nextInt();

                    Room selectedRoom = scheduler.findRoomByNumber(roomNumber);
                    if (selectedRoom != null) {
                        if (selectedRoom.isRoomAvailable()) {
                            String host, startTime, endTime;
                            boolean chairBooking;

                            scanner.nextLine(); // Consume the newline character

                            System.out.print("Enter host name: ");
                            host = scanner.nextLine();

                            System.out.print("Enter start time: ");
                            startTime = scanner.nextLine();

                            System.out.print("Enter end time: ");
                            endTime = scanner.nextLine();

                            System.out.print("Require chair booking? (True-Yes, False-No): ");
                            chairBooking = scanner.nextBoolean();

                            scheduler.bookRoom(selectedRoom, host, startTime, endTime, chairBooking);
                            System.out.println("Room booked successfully!");
                        } else {
                            System.out.println("Room is already booked!");
                        }
                    } else {
                        System.out.println("Invalid room number!");
                    }
                    break;
                }
                case 2: {
                    int roomNumber;
                    System.out.print("Enter room number: ");
                    roomNumber = scanner.nextInt();

                    Room selectedRoom = scheduler.findRoomByNumber(roomNumber);
                    if (selectedRoom != null) {
                        scheduler.printRoomStatus(selectedRoom);
                    } else {
                        System.out.println("Invalid room number!");
                    }
                    break;
                }
                case 3:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 3);

        scanner.close();
    }

}
