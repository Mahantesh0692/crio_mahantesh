import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HotelBookingSystem {

	private static final int FLOORS = 10;
	private static final int ROOMS_PER_FLOOR = 26;
	private final Map<String,String> bookings;
	private int coinscollected ;
	
	
	private HotelBookingSystem() {
		this.bookings = new HashMap<>();
		this.coinscollected = 0;
	}
	
	public static void printRoom() {
		for(int floor = 0 ; floor<= FLOORS - 1 ;floor ++ ) {
			for(int rooms = 0 ; rooms<=ROOMS_PER_FLOOR - 1; rooms++ ) {
				System.out.println(floor + ""+(char) ('A' + rooms)+" ");
			}
		}
	}
	
	public void bookRoom(String roomNumber , String customerName) {
		if(bookings.containsKey(roomNumber)) {
			System.out.println(roomNumber+" room is booked");
		}
		
		bookings.put(roomNumber, customerName);
		coinscollected ++;
		System.out.println("Room " + roomNumber + " booked for " + customerName + ".");
	}
	
	public void checkoutCustomer(String customerName ) {
		bookings.entrySet().removeIf(entry -> entry.getValue().equals(customerName));
		System.out.println("Checked out customer :"+ customerName);
	}
	
	public int coinsCollected () {
		System.out.println("coinscollected :"+ coinscollected);
		return coinscollected; 
	}
	
	public int totalActiveBookings() {
		System.out.println("totalActiveBookings :"+bookings.size());
		return bookings.size();
	}
	
	public void printActiveBookings() {
		for(Entry<String, String> map : bookings.entrySet()){
			System.out.println(map.getKey()+" "+map.getValue());
		}
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HotelBookingSystem hotel = new HotelBookingSystem();
		
		
		//total rooms
		HotelBookingSystem.printRoom();
		
		//booked rooms
		hotel.bookRoom("1B", "Ram");
        hotel.bookRoom("2A", "Shyam");
        hotel.bookRoom("3D", "Kavita");
        hotel.bookRoom("4A", "Preeti");
        
        //checkout from booked room
        hotel.checkoutCustomer("Preeti");
        
        //total coins collected
        hotel.coinsCollected();
        
        //total active bookings
        hotel.totalActiveBookings();
        
        //printing total active bookings
        hotel.printActiveBookings();
	}

}
