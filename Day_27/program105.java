import java.util.*;

public class program105
{
    static Scanner sc = new Scanner(System.in);
    static String names[] = new String[100];
    static int rollNos[] = new int[100];
    static String courses[] = new String[100];
    static long phones[] = new long[100];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== STUDENT RECORD MANAGEMENT ==========");
            System.out.println("1. Add Student Record");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Exit");
            System.out.println("==============================================");
            System.out.println("Enter your choice (1-6):");
            choice = sc.nextInt();
            sc.nextLine();        //consume newline
            
            switch(choice)
            {
                case 1:        //Add Student
                    addStudent();
                    break;
                case 2:        //Display All
                    displayAll();
                    break;
                case 3:        //Search
                    searchStudent();
                    break;
                case 4:        //Update
                    updateStudent();
                    break;
                case 5:        //Delete
                    deleteStudent();
                    break;
                case 6:        //Exit
                    System.out.println("\nExiting System... Thank you!");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please enter 1-6.");
            }
            
        } while(choice!=6 && choice>0);
        
        sc.close();
    }
    
    static void addStudent()        //add new student record
    {
        if(count >= 50)
        {
            System.out.println("\nStorage full! Cannot add more students.");
            return;
        }
        
        System.out.println("\n--- ADD STUDENT RECORD ---");
        System.out.println("Enter Roll Number:");
        int roll = sc.nextInt();
        sc.nextLine();
        
        //check if roll number already exists
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
        
        System.out.println("Enter Phone Number:");
        long phone = sc.nextLong();
        
        rollNos[count] = roll;
        names[count] = name;
        courses[count] = course;
        phones[count] = phone;
        count++;
        
        System.out.println("\nStudent added successfully! Roll No: " + roll);
    }
    
    static void displayAll()        //display all students
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\n--- ALL STUDENT RECORDS ---");
        System.out.println("==================================================");
        System.out.println("Roll No\tName\t\tCourse\t\tPhone");
        System.out.println("==================================================");
        
        for(int i=0; i<count; i++)
        {
            System.out.println(rollNos[i] + "\t" + names[i] + "\t\t" + courses[i] + "\t\t" + phones[i]);
        }
        System.out.println("==================================================");
        System.out.println("Total Students: " + count);
    }
    
    static void searchStudent()        //search by roll number
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\nEnter Roll Number to search:");
        int roll = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(rollNos[i] == roll)
            {
                System.out.println("\n--- STUDENT FOUND ---");
                System.out.println("Roll No: " + rollNos[i]);
                System.out.println("Name: " + names[i]);
                System.out.println("Course: " + courses[i]);
                System.out.println("Phone: " + phones[i]);
                return;
            }
        }
        
        System.out.println("\nStudent with Roll No " + roll + " not found!");
    }
    
    static void updateStudent()        //update student details
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
                System.out.println("Name: " + names[i]);
                System.out.println("Course: " + courses[i]);
                System.out.println("Phone: " + phones[i]);
                
                System.out.println("\nEnter New Name:");
                names[i] = sc.nextLine();
                
                System.out.println("Enter New Course:");
                courses[i] = sc.nextLine();
                
                System.out.println("Enter New Phone Number:");
                phones[i] = sc.nextLong();
                
                System.out.println("\nStudent record updated successfully!");
                return;
            }
        }
        
        System.out.println("\nStudent with Roll No " + roll + " not found!");
    }
    
    static void deleteStudent()        //delete student record
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
                //shift all records left
                for(int j=i; j<count-1; j++)
                {
                    rollNos[j] = rollNos[j+1];
                    names[j] = names[j+1];
                    courses[j] = courses[j+1];
                    phones[j] = phones[j+1];
                }
                count--;
                System.out.println("\nStudent record deleted successfully!");
                return;
            }
        }
        
        System.out.println("\nStudent with Roll No " + roll + " not found!");
    }
}