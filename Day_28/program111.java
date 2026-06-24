import java.util.*;

public class program111
{
    static Scanner sc = new Scanner(System.in);
    static String events[] = new String[50];
    static int totalSeats[] = new int[50];
    static int bookedSeats[] = new int[50];
    static double prices[] = new double[50];
    static int eventCount = 0;
    
    //Booking arrays
    static int bookingIds[] = new int[500];
    static String bookingNames[] = new String[500];
    static int bookingEventIndices[] = new int[500];
    static int bookingSeats[] = new int[500];
    static int bookingCount = 0;
    static int nextBookingId = 1001;

    public static void main(String[] sm)
    {
        int choice;
        
        //Add some sample events
        initializeEvents();
        
        do
        {
            System.out.println("\n========== TICKET BOOKING SYSTEM ==========");
            System.out.println("1. View All Events");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. View Available Seats");
            System.out.println("6. Add New Event (Admin)");
            System.out.println("7. Exit");
            System.out.println("===========================================");
            System.out.println("Enter your choice (1-7):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: viewEvents(); break;
                case 2: bookTickets(); break;
                case 3: cancelBooking(); break;
                case 4: viewBookingDetails(); break;
                case 5: viewAvailableSeats(); break;
                case 6: addEvent(); break;
                case 7: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 7);
        
        sc.close();
    }
    
    static void initializeEvents()        //add sample events
    {
        events[0] = "Concert - Rock Night";
        totalSeats[0] = 100;
        bookedSeats[0] = 0;
        prices[0] = 500;
        
        events[1] = "Movie - Avengers";
        totalSeats[1] = 80;
        bookedSeats[1] = 0;
        prices[1] = 300;
        
        events[2] = "Sports - Cricket Match";
        totalSeats[2] = 200;
        bookedSeats[2] = 0;
        prices[2] = 400;
        
        eventCount = 3;
    }
    
    static void viewEvents()        //display all events
    {
        if(eventCount == 0)
        {
            System.out.println("\nNo events available!");
            return;
        }
        
        System.out.println("\n--- AVAILABLE EVENTS ---");
        System.out.println("================================================================");
        System.out.println("ID\tEvent Name\t\t\tSeats Available\t\tPrice");
        System.out.println("================================================================");
        
        for(int i=0; i<eventCount; i++)
        {
            int available = totalSeats[i] - bookedSeats[i];
            System.out.println((i+1) + "\t" + events[i] + "\t\t" + available + "/" + totalSeats[i] + "\t\t₹" + prices[i]);
        }
        System.out.println("================================================================");
    }
    
    static void bookTickets()        //book tickets for an event
    {
        if(eventCount == 0)
        {
            System.out.println("\nNo events available for booking!");
            return;
        }
        
        viewEvents();
        
        System.out.println("\nEnter Event ID to book:");
        int eventId = sc.nextInt();
        sc.nextLine();
        
        if(eventId < 1 || eventId > eventCount)
        {
            System.out.println("Invalid Event ID!");
            return;
        }
        
        int index = eventId - 1;
        int available = totalSeats[index] - bookedSeats[index];
        
        if(available == 0)
        {
            System.out.println("Sorry! Event is sold out.");
            return;
        }
        
        System.out.println("Enter number of tickets (Max " + available + "):");
        int tickets = sc.nextInt();
        sc.nextLine();
        
        if(tickets <= 0 || tickets > available)
        {
            System.out.println("Invalid number of tickets!");
            return;
        }
        
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        
        double totalAmount = tickets * prices[index];
        
        System.out.println("\n--- BOOKING SUMMARY ---");
        System.out.println("Event: " + events[index]);
        System.out.println("Tickets: " + tickets);
        System.out.println("Price per ticket: ₹" + prices[index]);
        System.out.println("Total Amount: ₹" + totalAmount);
        
        System.out.println("\nConfirm booking? (yes/no):");
        String confirm = sc.nextLine();
        
        if(confirm.equalsIgnoreCase("yes"))
        {
            bookingIds[bookingCount] = nextBookingId;
            bookingNames[bookingCount] = name;
            bookingEventIndices[bookingCount] = index;
            bookingSeats[bookingCount] = tickets;
            bookedSeats[index] += tickets;
            bookingCount++;
            
            System.out.println("\n✓ Booking Successful!");
            System.out.println("Booking ID: " + nextBookingId);
            System.out.println("Please save your Booking ID for future reference.");
            nextBookingId++;
        }
        else
        {
            System.out.println("\nBooking cancelled.");
        }
    }
    
    static void cancelBooking()        //cancel existing booking
    {
        if(bookingCount == 0)
        {
            System.out.println("\nNo bookings found!");
            return;
        }
        
        System.out.println("\nEnter Booking ID to cancel:");
        int bookingId = sc.nextInt();
        
        for(int i=0; i<bookingCount; i++)
        {
            if(bookingIds[i] == bookingId)
            {
                int eventIndex = bookingEventIndices[i];
                int seats = bookingSeats[i];
                
                System.out.println("\n--- BOOKING DETAILS ---");
                System.out.println("Booking ID: " + bookingIds[i]);
                System.out.println("Name: " + bookingNames[i]);
                System.out.println("Event: " + events[eventIndex]);
                System.out.println("Tickets: " + seats);
                
                System.out.println("\nConfirm cancellation? (yes/no):");
                sc.nextLine();
                String confirm = sc.nextLine();
                
                if(confirm.equalsIgnoreCase("yes"))
                {
                    //Remove booking by shifting
                    for(int j=i; j<bookingCount-1; j++)
                    {
                        bookingIds[j] = bookingIds[j+1];
                        bookingNames[j] = bookingNames[j+1];
                        bookingEventIndices[j] = bookingEventIndices[j+1];
                        bookingSeats[j] = bookingSeats[j+1];
                    }
                    bookingCount--;
                    bookedSeats[eventIndex] -= seats;
                    
                    System.out.println("\n✓ Booking cancelled successfully!");
                    System.out.println("Refund Amount: ₹" + (seats * prices[eventIndex]));
                }
                else
                {
                    System.out.println("\nCancellation aborted.");
                }
                return;
            }
        }
        
        System.out.println("Booking ID not found!");
    }
    
    static void viewBookingDetails()        //view details of a booking
    {
        if(bookingCount == 0)
        {
            System.out.println("\nNo bookings found!");
            return;
        }
        
        System.out.println("\nEnter Booking ID:");
        int bookingId = sc.nextInt();
        
        for(int i=0; i<bookingCount; i++)
        {
            if(bookingIds[i] == bookingId)
            {
                int eventIndex = bookingEventIndices[i];
                System.out.println("\n--- BOOKING DETAILS ---");
                System.out.println("Booking ID: " + bookingIds[i]);
                System.out.println("Name: " + bookingNames[i]);
                System.out.println("Event: " + events[eventIndex]);
                System.out.println("Tickets Booked: " + bookingSeats[i]);
                System.out.println("Total Amount Paid: ₹" + (bookingSeats[i] * prices[eventIndex]));
                return;
            }
        }
        
        System.out.println("Booking ID not found!");
    }
    
    static void viewAvailableSeats()        //view available seats for an event
    {
        if(eventCount == 0)
        {
            System.out.println("\nNo events available!");
            return;
        }
        
        viewEvents();
        
        System.out.println("\nEnter Event ID to view seat availability:");
        int eventId = sc.nextInt();
        
        if(eventId < 1 || eventId > eventCount)
        {
            System.out.println("Invalid Event ID!");
            return;
        }
        
        int index = eventId - 1;
        int available = totalSeats[index] - bookedSeats[index];
        
        System.out.println("\n--- SEAT AVAILABILITY ---");
        System.out.println("Event: " + events[index]);
        System.out.println("Total Seats: " + totalSeats[index]);
        System.out.println("Booked Seats: " + bookedSeats[index]);
        System.out.println("Available Seats: " + available);
        
        //Show seat percentage
        double percentage = (available * 100.0) / totalSeats[index];
        System.out.println("Availability: " + String.format("%.1f", percentage) + "%");
    }
    
    static void addEvent()        //add new event (admin function)
    {
        if(eventCount >= 50)
        {
            System.out.println("\nCannot add more events! Storage full.");
            return;
        }
        
        System.out.println("\n--- ADD NEW EVENT ---");
        System.out.println("Enter Event Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Total Seats:");
        int seats = sc.nextInt();
        
        System.out.println("Enter Ticket Price:");
        double price = sc.nextDouble();
        sc.nextLine();
        
        events[eventCount] = name;
        totalSeats[eventCount] = seats;
        bookedSeats[eventCount] = 0;
        prices[eventCount] = price;
        eventCount++;
        
        System.out.println("\nEvent added successfully!");
    }
}