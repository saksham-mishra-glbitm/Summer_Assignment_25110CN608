import java.util.*;

public class program118
{
    static Scanner sc = new Scanner(System.in);
    static String titles[] = new String[100];
    static String authors[] = new String[100];
    static String publishers[] = new String[100];
    static int years[] = new int[100];
    static int quantities[] = new int[100];
    static int issued[] = new int[100];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== MINI LIBRARY SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search by Title");
            System.out.println("4. Search by Author");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Display Available Books");
            System.out.println("8. Display Issued Books");
            System.out.println("9. Delete Book");
            System.out.println("10. Exit");
            System.out.println("=========================================");
            System.out.println("Enter your choice (1-10):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addBook(); break;
                case 2: displayAll(); break;
                case 3: searchByTitle(); break;
                case 4: searchByAuthor(); break;
                case 5: issueBook(); break;
                case 6: returnBook(); break;
                case 7: displayAvailable(); break;
                case 8: displayIssued(); break;
                case 9: deleteBook(); break;
                case 10: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 10);
        
        sc.close();
    }
    
    static void addBook()
    {
        if(count >= 100)
        {
            System.out.println("\nStorage full!");
            return;
        }
        
        System.out.println("\n--- ADD BOOK ---");
        System.out.println("Enter Title:");
        String title = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(titles[i].equalsIgnoreCase(title))
            {
                System.out.println("Book already exists! Adding to quantity.");
                quantities[i]++;
                System.out.println("New quantity: " + quantities[i]);
                return;
            }
        }
        
        System.out.println("Enter Author:");
        String author = sc.nextLine();
        
        System.out.println("Enter Publisher:");
        String publisher = sc.nextLine();
        
        System.out.println("Enter Publication Year:");
        int year = sc.nextInt();
        
        System.out.println("Enter Quantity:");
        int qty = sc.nextInt();
        
        titles[count] = title;
        authors[count] = author;
        publishers[count] = publisher;
        years[count] = year;
        quantities[count] = qty;
        issued[count] = 0;
        count++;
        
        System.out.println("\nBook added successfully!");
    }
    
    static void displayAll()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\n--- ALL BOOKS ---");
        System.out.println("=========================================================================");
        System.out.println("#\tTitle\t\t\tAuthor\t\t\tAvailable\tIssued");
        System.out.println("=========================================================================");
        
        for(int i=0; i<count; i++)
        {
            int available = quantities[i] - issued[i];
            System.out.println((i+1) + "\t" + titles[i] + "\t\t\t" + authors[i] + "\t\t\t" + available + "\t\t" + issued[i]);
        }
        System.out.println("=========================================================================");
        System.out.println("Total Books: " + count);
    }
    
    static void searchByTitle()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\nEnter Book Title:");
        String title = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(titles[i].equalsIgnoreCase(title))
            {
                displayBook(i);
                return;
            }
        }
        
        System.out.println("\nBook not found!");
    }
    
    static void searchByAuthor()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\nEnter Author Name:");
        String author = sc.nextLine();
        
        boolean found = false;
        System.out.println("\n--- BOOKS BY " + author.toUpperCase() + " ---");
        System.out.println("==============================================");
        
        for(int i=0; i<count; i++)
        {
            if(authors[i].equalsIgnoreCase(author))
            {
                System.out.println(titles[i] + " (" + publishers[i] + ", " + years[i] + ")");
                found = true;
            }
        }
        
        if(!found)
            System.out.println("No books found by " + author);
    }
    
    static void displayBook(int index)
    {
        int available = quantities[index] - issued[index];
        System.out.println("\n--- BOOK DETAILS ---");
        System.out.println("Title: " + titles[index]);
        System.out.println("Author: " + authors[index]);
        System.out.println("Publisher: " + publishers[index]);
        System.out.println("Year: " + years[index]);
        System.out.println("Total Copies: " + quantities[index]);
        System.out.println("Available: " + available);
        System.out.println("Issued: " + issued[index]);
    }
    
    static void issueBook()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\nEnter Book Title:");
        String title = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(titles[i].equalsIgnoreCase(title))
            {
                int available = quantities[i] - issued[i];
                if(available <= 0)
                {
                    System.out.println("No copies available!");
                    return;
                }
                
                System.out.println("Enter Student Name:");
                String student = sc.nextLine();
                
                issued[i]++;
                System.out.println("\nBook issued successfully to " + student);
                System.out.println("Due Date: 14 days from today");
                return;
            }
        }
        
        System.out.println("\nBook not found!");
    }
    
    static void returnBook()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\nEnter Book Title:");
        String title = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(titles[i].equalsIgnoreCase(title))
            {
                if(issued[i] <= 0)
                {
                    System.out.println("No copies of this book are currently issued!");
                    return;
                }
                
                issued[i]--;
                System.out.println("\nBook returned successfully!");
                return;
            }
        }
        
        System.out.println("\nBook not found!");
    }
    
    static void displayAvailable()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\n--- AVAILABLE BOOKS ---");
        System.out.println("==============================================");
        
        int availableCount = 0;
        for(int i=0; i<count; i++)
        {
            int available = quantities[i] - issued[i];
            if(available > 0)
            {
                System.out.println(titles[i] + " by " + authors[i] + " (" + available + " copies)");
                availableCount++;
            }
        }
        
        if(availableCount == 0)
            System.out.println("No books available!");
        else
            System.out.println("==============================================\nTotal Available Books: " + availableCount);
    }
    
    static void displayIssued()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\n--- ISSUED BOOKS ---");
        System.out.println("==============================================");
        
        int issuedCount = 0;
        for(int i=0; i<count; i++)
        {
            if(issued[i] > 0)
            {
                System.out.println(titles[i] + " by " + authors[i] + " (" + issued[i] + " copies issued)");
                issuedCount++;
            }
        }
        
        if(issuedCount == 0)
            System.out.println("No books currently issued!");
        else
            System.out.println("==============================================\nTotal Issued Book Types: " + issuedCount);
    }
    
    static void deleteBook()
    {
        if(count == 0)
        {
            System.out.println("\nNo books in library!");
            return;
        }
        
        System.out.println("\nEnter Book Title to delete:");
        String title = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(titles[i].equalsIgnoreCase(title))
            {
                if(issued[i] > 0)
                {
                    System.out.println("Cannot delete! " + issued[i] + " copies are currently issued.");
                    return;
                }
                
                for(int j=i; j<count-1; j++)
                {
                    titles[j] = titles[j+1];
                    authors[j] = authors[j+1];
                    publishers[j] = publishers[j+1];
                    years[j] = years[j+1];
                    quantities[j] = quantities[j+1];
                    issued[j] = issued[j+1];
                }
                count--;
                System.out.println("\nBook deleted successfully!");
                return;
            }
        }
        
        System.out.println("\nBook not found!");
    }
}