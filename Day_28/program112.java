import java.util.*;

public class program112
{
    static Scanner sc = new Scanner(System.in);
    static String names[] = new String[200];
    static String phones[] = new String[200];
    static String emails[] = new String[200];
    static String addresses[] = new String[200];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== CONTACT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Contact");
            System.out.println("2. Display All Contacts");
            System.out.println("3. Search Contact by Name");
            System.out.println("4. Search Contact by Phone");
            System.out.println("5. Update Contact");
            System.out.println("6. Delete Contact");
            System.out.println("7. Exit");
            System.out.println("===============================================");
            System.out.println("Enter your choice (1-7):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addContact(); break;
                case 2: displayAllContacts(); break;
                case 3: searchByName(); break;
                case 4: searchByPhone(); break;
                case 5: updateContact(); break;
                case 6: deleteContact(); break;
                case 7: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 7);
        
        sc.close();
    }
    
    static void addContact()        //add new contact
    {
        if(count >= 200)
        {
            System.out.println("\nStorage full! Cannot add more contacts.");
            return;
        }
        
        System.out.println("\n--- ADD CONTACT ---");
        
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Phone Number:");
        String phone = sc.nextLine();
        
        //Check if phone number already exists
        for(int i=0; i<count; i++)
        {
            if(phones[i].equals(phone))
            {
                System.out.println("Contact with this phone number already exists!");
                return;
            }
        }
        
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        
        System.out.println("Enter Address:");
        String address = sc.nextLine();
        
        names[count] = name;
        phones[count] = phone;
        emails[count] = email;
        addresses[count] = address;
        count++;
        
        System.out.println("\nContact added successfully!");
    }
    
    static void displayAllContacts()        //display all contacts
    {
        if(count == 0)
        {
            System.out.println("\nNo contacts found!");
            return;
        }
        
        System.out.println("\n--- ALL CONTACTS ---");
        System.out.println("=========================================================================");
        System.out.println("#\tName\t\t\tPhone\t\t\tEmail");
        System.out.println("=========================================================================");
        
        for(int i=0; i<count; i++)
        {
            System.out.println((i+1) + "\t" + names[i] + "\t\t\t" + phones[i] + "\t\t" + emails[i]);
        }
        System.out.println("=========================================================================");
        System.out.println("Total Contacts: " + count);
    }
    
    static int findByName(String name)        //find contact index by name
    {
        for(int i=0; i<count; i++)
        {
            if(names[i].equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }
    
    static int findByPhone(String phone)        //find contact index by phone
    {
        for(int i=0; i<count; i++)
        {
            if(phones[i].equals(phone))
                return i;
        }
        return -1;
    }
    
    static void searchByName()        //search contact by name
    {
        if(count == 0)
        {
            System.out.println("\nNo contacts found!");
            return;
        }
        
        System.out.println("\nEnter Name to search:");
        String name = sc.nextLine();
        
        int index = findByName(name);
        if(index == -1)
        {
            System.out.println("Contact not found!");
            return;
        }
        
        displayContact(index);
    }
    
    static void searchByPhone()        //search contact by phone number
    {
        if(count == 0)
        {
            System.out.println("\nNo contacts found!");
            return;
        }
        
        System.out.println("\nEnter Phone Number to search:");
        String phone = sc.nextLine();
        
        int index = findByPhone(phone);
        if(index == -1)
        {
            System.out.println("Contact not found!");
            return;
        }
        
        displayContact(index);
    }
    
    static void displayContact(int index)        //display single contact details
    {
        System.out.println("\n--- CONTACT DETAILS ---");
        System.out.println("Name: " + names[index]);
        System.out.println("Phone: " + phones[index]);
        System.out.println("Email: " + emails[index]);
        System.out.println("Address: " + addresses[index]);
    }
    
    static void updateContact()        //update existing contact
    {
        if(count == 0)
        {
            System.out.println("\nNo contacts found!");
            return;
        }
        
        System.out.println("\nEnter Phone Number of contact to update:");
        String phone = sc.nextLine();
        
        int index = findByPhone(phone);
        if(index == -1)
        {
            System.out.println("Contact not found!");
            return;
        }
        
        System.out.println("\nCurrent Details:");
        displayContact(index);
        
        System.out.println("\n--- UPDATE CONTACT ---");
        System.out.println("Leave blank to keep current value.");
        
        System.out.println("Enter New Name (Current: " + names[index] + "):");
        String newName = sc.nextLine();
        if(!newName.isEmpty())
            names[index] = newName;
        
        System.out.println("Enter New Phone (Current: " + phones[index] + "):");
        String newPhone = sc.nextLine();
        if(!newPhone.isEmpty())
        {
            //Check if new phone number already exists for another contact
            for(int i=0; i<count; i++)
            {
                if(i != index && phones[i].equals(newPhone))
                {
                    System.out.println("Phone number already used by another contact!");
                    return;
                }
            }
            phones[index] = newPhone;
        }
        
        System.out.println("Enter New Email (Current: " + emails[index] + "):");
        String newEmail = sc.nextLine();
        if(!newEmail.isEmpty())
            emails[index] = newEmail;
        
        System.out.println("Enter New Address (Current: " + addresses[index] + "):");
        String newAddress = sc.nextLine();
        if(!newAddress.isEmpty())
            addresses[index] = newAddress;
        
        System.out.println("\nContact updated successfully!");
    }
    
    static void deleteContact()        //delete a contact
    {
        if(count == 0)
        {
            System.out.println("\nNo contacts found!");
            return;
        }
        
        System.out.println("\nEnter Phone Number of contact to delete:");
        String phone = sc.nextLine();
        
        int index = findByPhone(phone);
        if(index == -1)
        {
            System.out.println("Contact not found!");
            return;
        }
        
        System.out.println("\nContact to delete:");
        displayContact(index);
        
        System.out.println("\nConfirm deletion? (yes/no):");
        String confirm = sc.nextLine();
        
        if(confirm.equalsIgnoreCase("yes"))
        {
            for(int j=index; j<count-1; j++)
            {
                names[j] = names[j+1];
                phones[j] = phones[j+1];
                emails[j] = emails[j+1];
                addresses[j] = addresses[j+1];
            }
            count--;
            System.out.println("\nContact deleted successfully!");
        }
        else
        {
            System.out.println("\nDeletion cancelled.");
        }
    }
}