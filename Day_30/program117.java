import java.util.*;

public class program117
{
    static Scanner sc = new Scanner(System.in);
    static int rollNos[] = new int[100];
    static String names[] = new String[100];
    static String courses[] = new String[100];
    static String branches[] = new String[100];
    static int years[] = new int[100];
    static long phones[] = new long[100];
    static String emails[] = new String[100];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== STUDENT RECORD SYSTEM ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Branch");
            System.out.println("6. Update Student Details");
            System.out.println("7. Delete Student");
            System.out.println("8. Display Branch-wise Students");
            System.out.println("9. Exit");
            System.out.println("===========================================");
            System.out.println("Enter your choice (1-9):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addStudent(); break;
                case 2: displayAll(); break;
                case 3: searchByRoll(); break;
                case 4: searchByName(); break;
                case 5: searchByBranch(); break;
                case 6: updateStudent(); break;
                case 7: deleteStudent(); break;
                case 8: displayByBranch(); break;
                case 9: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 9);
        
        sc.close();
    }
    
    static void addStudent()
    {
        if(count >= 100)
        {
            System.out.println("\nStorage full! Cannot add more students.");
            return;
        }
        
        System.out.println("\n--- ADD STUDENT ---");
        System.out.println("Enter Roll Number:");
        int roll = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(rollNos[i] == roll)
            {
                System.out.println("Roll number already exists!");
                return;
            }
        }
        
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Course:");
        String course = sc.nextLine();
        
        System.out.println("Enter Branch (CSE/IT/ECE/ME/CE):");
        String branch = sc.nextLine();
        
        System.out.println("Enter Year (1-4):");
        int year = sc.nextInt();
        
        System.out.println("Enter Phone Number:");
        long phone = sc.nextLong();
        sc.nextLine();
        
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        
        rollNos[count] = roll;
        names[count] = name;
        courses[count] = course;
        branches[count] = branch;
        years[count] = year;
        phones[count] = phone;
        emails[count] = email;
        count++;
        
        System.out.println("\nStudent added successfully! Roll No: " + roll);
    }
    
    static void displayAll()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\n--- ALL STUDENTS ---");
        System.out.println("=================================================================================");
        System.out.println("Roll\tName\t\tCourse\t\tBranch\tYear\tPhone\t\tEmail");
        System.out.println("=================================================================================");
        
        for(int i=0; i<count; i++)
        {
            System.out.println(rollNos[i] + "\t" + names[i] + "\t\t" + courses[i] + "\t" + 
                             branches[i] + "\t" + years[i] + "\t" + phones[i] + "\t" + emails[i]);
        }
        System.out.println("=================================================================================");
        System.out.println("Total Students: " + count);
    }
    
    static void searchByRoll()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\nEnter Roll Number:");
        int roll = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(rollNos[i] == roll)
            {
                displayStudent(i);
                return;
            }
        }
        
        System.out.println("\nStudent with Roll No " + roll + " not found!");
    }
    
    static void searchByName()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\nEnter Name:");
        sc.nextLine();
        String name = sc.nextLine();
        
        boolean found = false;
        for(int i=0; i<count; i++)
        {
            if(names[i].equalsIgnoreCase(name))
            {
                displayStudent(i);
                found = true;
            }
        }
        
        if(!found)
            System.out.println("\nNo student found with name: " + name);
    }
    
    static void searchByBranch()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\nEnter Branch (CSE/IT/ECE/ME/CE):");
        sc.nextLine();
        String branch = sc.nextLine();
        
        boolean found = false;
        System.out.println("\n--- STUDENTS IN " + branch.toUpperCase() + " BRANCH ---");
        System.out.println("==============================================");
        
        for(int i=0; i<count; i++)
        {
            if(branches[i].equalsIgnoreCase(branch))
            {
                System.out.println(rollNos[i] + "\t" + names[i] + "\t" + years[i]);
                found = true;
            }
        }
        
        if(!found)
            System.out.println("No students found in " + branch + " branch!");
    }
    
    static void displayStudent(int index)
    {
        System.out.println("\n--- STUDENT DETAILS ---");
        System.out.println("Roll Number: " + rollNos[index]);
        System.out.println("Name: " + names[index]);
        System.out.println("Course: " + courses[index]);
        System.out.println("Branch: " + branches[index]);
        System.out.println("Year: " + years[index]);
        System.out.println("Phone: " + phones[index]);
        System.out.println("Email: " + emails[index]);
    }
    
    static void updateStudent()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\nEnter Roll Number to update:");
        int roll = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(rollNos[i] == roll)
            {
                System.out.println("\nCurrent Details:");
                displayStudent(i);
                
                System.out.println("\n--- UPDATE (Leave blank to keep current) ---");
                
                System.out.println("Enter New Name (Current: " + names[i] + "):");
                String newName = sc.nextLine();
                if(!newName.isEmpty()) names[i] = newName;
                
                System.out.println("Enter New Course (Current: " + courses[i] + "):");
                String newCourse = sc.nextLine();
                if(!newCourse.isEmpty()) courses[i] = newCourse;
                
                System.out.println("Enter New Branch (Current: " + branches[i] + "):");
                String newBranch = sc.nextLine();
                if(!newBranch.isEmpty()) branches[i] = newBranch;
                
                System.out.println("Enter New Year (Current: " + years[i] + "):");
                String newYear = sc.nextLine();
                if(!newYear.isEmpty()) years[i] = Integer.parseInt(newYear);
                
                System.out.println("Enter New Phone (Current: " + phones[i] + "):");
                String newPhone = sc.nextLine();
                if(!newPhone.isEmpty()) phones[i] = Long.parseLong(newPhone);
                
                System.out.println("Enter New Email (Current: " + emails[i] + "):");
                String newEmail = sc.nextLine();
                if(!newEmail.isEmpty()) emails[i] = newEmail;
                
                System.out.println("\nStudent record updated successfully!");
                return;
            }
        }
        
        System.out.println("\nStudent with Roll No " + roll + " not found!");
    }
    
    static void deleteStudent()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\nEnter Roll Number to delete:");
        int roll = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(rollNos[i] == roll)
            {
                displayStudent(i);
                
                System.out.println("\nConfirm deletion? (yes/no):");
                sc.nextLine();
                String confirm = sc.nextLine();
                
                if(confirm.equalsIgnoreCase("yes"))
                {
                    for(int j=i; j<count-1; j++)
                    {
                        rollNos[j] = rollNos[j+1];
                        names[j] = names[j+1];
                        courses[j] = courses[j+1];
                        branches[j] = branches[j+1];
                        years[j] = years[j+1];
                        phones[j] = phones[j+1];
                        emails[j] = emails[j+1];
                    }
                    count--;
                    System.out.println("\nStudent deleted successfully!");
                }
                else
                {
                    System.out.println("\nDeletion cancelled.");
                }
                return;
            }
        }
        
        System.out.println("\nStudent with Roll No " + roll + " not found!");
    }
    
    static void displayByBranch()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\n--- BRANCH-WISE STUDENTS ---");
        String[] branches = {"CSE", "IT", "ECE", "ME", "CE"};
        
        for(String branch : branches)
        {
            int branchCount = 0;
            System.out.println("\n" + branch + " BRANCH:");
            System.out.println("----------------------------------------");
            
            for(int i=0; i<count; i++)
            {
                if(branches[i].equalsIgnoreCase(branch))
                {
                    System.out.println(rollNos[i] + " - " + names[i] + " (Year " + years[i] + ")");
                    branchCount++;
                }
            }
            
            if(branchCount == 0)
                System.out.println("No students in " + branch + " branch");
            else
                System.out.println("Total: " + branchCount + " students");
        }
    }
}