import java.util.*;

public class program109
{
    static Scanner sc = new Scanner(System.in);
    static String titles[] = new String[100];
    static String authors[] = new String[100];
    static String isbns[] = new String[100];
    static boolean issued[] = new boolean[100];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by ISBN");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Issued Books");
            System.out.println("7. Delete Book");
            System.out.println("8. Exit");
            System.out.println("==============================================");
            System.out.println("Enter your choice (1-8):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addBook(); break;
                case 2: displayAllBooks(); break;
                case 3: searchBook(); break;
                case 4: issueBook(); break;
                case 5: returnBook(); break;
                case 6: displayIssuedBooks(); break;
                case 7: deleteBook(); break;
                case 8: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 8 && choice>0);
        
        sc.close();
    }
    
    static void addBook()        //add new book
    {
        if(count >= 100)
        {
            System.out.println("\nStorage full! Cannot add more books.");
            return;
        }
        
        System.out.println("\n--- ADD BOOK ---");
        System.out.println("Enter ISBN:");
        String isbn = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(isbns[i].equals(isbn))
            {
                System.out.println("Book with this ISBN already exists!");
                return;
            }
        }
        
        System.out.println("Enter Title:");
        String title = sc.nextLine();
        
        System.out.println("Enter Author:");
        String author = sc.nextLine();
        
        isbns[count] = isbn;
        titles[count] = title;
        authors[count] = author;
        issued[count] = false;
        count++;
        
        System.out.println("\nBook added successfully! ISBN: " + isbn);
    }
    
    static void displayAllBooks()        //display all books
    {
        if(count == 0)
        {
            System.out.println("\nNo books in the library!");
            return;
        }
        
        System.out.println("\n--- ALL BOOKS ---");
        System.out.println("=========================================================================");
        System.out.println("ISBN\t\tTitle\t\t\tAuthor\t\t\tStatus");
        System.out.println("=========================================================================");
        
        for(int i=0; i<count; i++)
        {
            String status = issued[i] ? "ISSUED" : "AVAILABLE";
            System.out.println(isbns[i] + "\t" + titles[i] + "\t\t\t" + authors[i] + "\t\t\t" + status);
        }
        System.out.println("=========================================================================");
        System.out.println("Total Books: " + count);
    }
    
    static void searchBook()        //search by ISBN
    {
        if(count == 0)
        {
            System.out.println("\nNo books in the library!");
            return;
        }
        
        System.out.println("\nEnter ISBN to search:");
        String isbn = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(isbns[i].equals(isbn))
            {
                System.out.println("\n--- BOOK FOUND ---");
                System.out.println("ISBN: " + isbns[i]);
                System.out.println("Title: " + titles[i]);
                System.out.println("Author: " + authors[i]);
                System.out.println("Status: " + (issued[i] ? "ISSUED" : "AVAILABLE"));
                return;
            }
        }
        
        System.out.println("\nBook with ISBN " + isbn + " not found!");
    }
    
    static void issueBook()        //issue a book
    {
        if(count == 0)
        {
            System.out.println("\nNo books in the library!");
            return;
        }
        
        System.out.println("\nEnter ISBN of book to issue:");
        String isbn = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(isbns[i].equals(isbn))
            {
                if(issued[i])
                {
                    System.out.println("Book is already issued!");
                }
                else
                {
                    issued[i] = true;
                    System.out.println("\nBook issued successfully!");
                    System.out.println("Title: " + titles[i]);
                    System.out.println("Due Date: 14 days from today");
                }
                return;
            }
        }
        
        System.out.println("\nBook with ISBN " + isbn + " not found!");
    }
    
    static void returnBook()        //return a book
    {
        if(count == 0)
        {
            System.out.println("\nNo books in the library!");
            return;
        }
        
        System.out.println("\nEnter ISBN of book to return:");
        String isbn = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(isbns[i].equals(isbn))
            {
                if(!issued[i])
                {
                    System.out.println("Book was not issued!");
                }
                else
                {
                    issued[i] = false;
                    System.out.println("\nBook returned successfully!");
                    System.out.println("Title: " + titles[i]);
                }
                return;
            }
        }
        
        System.out.println("\nBook with ISBN " + isbn + " not found!");
    }
    
    static void displayIssuedBooks()        //display all issued books
    {
        int issuedCount = 0;
        
        System.out.println("\n--- ISSUED BOOKS ---");
        System.out.println("=========================================");
        System.out.println("ISBN\t\tTitle\t\t\tAuthor");
        System.out.println("=========================================");
        
        for(int i=0; i<count; i++)
        {
            if(issued[i])
            {
                System.out.println(isbns[i] + "\t" + titles[i] + "\t\t\t" + authors[i]);
                issuedCount++;
            }
        }
        
        if(issuedCount == 0)
            System.out.println("No books are currently issued.");
        else
            System.out.println("=========================================\nTotal Issued Books: " + issuedCount);
    }
    
    static void deleteBook()        //delete a book
    {
        if(count == 0)
        {
            System.out.println("\nNo books in the library!");
            return;
        }
        
        System.out.println("\nEnter ISBN of book to delete:");
        String isbn = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(isbns[i].equals(isbn))
            {
                if(issued[i])
                {
                    System.out.println("Cannot delete issued book! Please return it first.");
                    return;
                }
                
                for(int j=i; j<count-1; j++)
                {
                    isbns[j] = isbns[j+1];
                    titles[j] = titles[j+1];
                    authors[j] = authors[j+1];
                    issued[j] = issued[j+1];
                }
                count--;
                System.out.println("\nBook deleted successfully!");
                return;
            }
        }
        
        System.out.println("\nBook with ISBN " + isbn + " not found!");
    }
}