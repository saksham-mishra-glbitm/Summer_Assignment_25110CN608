import java.util.*;

public class program108
{
    static Scanner sc = new Scanner(System.in);
    static int rollNos[] = new int[100];
    static String names[] = new String[100];
    static int maths[] = new int[100];
    static int science[] = new int[100];
    static int english[] = new int[100];
    static int computers[] = new int[100];
    static int social[] = new int[100];
    static int totals[] = new int[100];
    static double percentages[] = new double[100];
    static String grades[] = new String[100];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== MARKSHEET GENERATION SYSTEM ==========");
            System.out.println("1. Add Student Marks");
            System.out.println("2. Generate Marksheet for Student");
            System.out.println("3. Display All Marksheets");
            System.out.println("4. Display Class Results");
            System.out.println("5. Find Topper");
            System.out.println("6. Exit");
            System.out.println("=================================================");
            System.out.println("Enter your choice (1-6):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addStudent(); break;
                case 2: generateMarksheet(); break;
                case 3: displayAllMarksheets(); break;
                case 4: displayClassResults(); break;
                case 5: findTopper(); break;
                case 6: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 6);
        
        sc.close();
    }
    
    static void addStudent()
    {
        if(count >= 100)
        {
            System.out.println("\nStorage full!");
            return;
        }
        
        System.out.println("\n--- ADD STUDENT MARKS ---");
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
        
        System.out.println("Enter Student Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Marks for Mathematics (0-100):");
        int m = sc.nextInt();
        System.out.println("Enter Marks for Science (0-100):");
        int sci = sc.nextInt();
        System.out.println("Enter Marks for English (0-100):");
        int eng = sc.nextInt();
        System.out.println("Enter Marks for Computers (0-100):");
        int comp = sc.nextInt();
        System.out.println("Enter Marks for Social Studies (0-100):");
        int soc = sc.nextInt();
        
        //validate marks
        if(m<0 || m>100 || sci<0 || sci>100 || eng<0 || eng>100 || comp<0 || comp>100 || soc<0 || soc>100)
        {
            System.out.println("Invalid marks! Marks must be between 0 and 100.");
            return;
        }
        
        rollNos[count] = roll;
        names[count] = name;
        maths[count] = m;
        science[count] = sci;
        english[count] = eng;
        computers[count] = comp;
        social[count] = soc;
        
        //calculate total and percentage
        totals[count] = m + sci + eng + comp + soc;
        percentages[count] = (totals[count] * 100.0) / 500;
        
        //calculate grade
        if(percentages[count] >= 90)
            grades[count] = "A+ (Excellent)";
        else if(percentages[count] >= 80)
            grades[count] = "A (Very Good)";
        else if(percentages[count] >= 70)
            grades[count] = "B+ (Good)";
        else if(percentages[count] >= 60)
            grades[count] = "B (Average)";
        else if(percentages[count] >= 50)
            grades[count] = "C (Below Average)";
        else if(percentages[count] >= 40)
            grades[count] = "D (Pass)";
        else
            grades[count] = "F (Fail)";
        
        count++;
        System.out.println("\nStudent marks added successfully! Roll No: " + roll);
    }
    
    static void generateMarksheet()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\nEnter Roll Number for marksheet:");
        int roll = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(rollNos[i] == roll)
            {
                System.out.println("\n");
                System.out.println("╔════════════════════════════════════════════════════════════╗");
                System.out.println("║                    MARKSHEET                               ║");
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("║ Roll Number: " + rollNos[i] + "                                      ║");
                System.out.println("║ Student Name: " + names[i] + "                                  ║");
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("║ Subject                    Marks     Max Marks             ║");
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("║ Mathematics                " + maths[i] + "        100                   ║");
                System.out.println("║ Science                    " + science[i] + "        100                   ║");
                System.out.println("║ English                    " + english[i] + "        100                   ║");
                System.out.println("║ Computers                  " + computers[i] + "        100                   ║");
                System.out.println("║ Social Studies             " + social[i] + "        100                   ║");
                System.out.println("╠════════════════════════════════════════════════════════════╣");
                System.out.println("║ TOTAL                      " + totals[i] + "        500                   ║");
                System.out.println("║ PERCENTAGE                  " + String.format("%.2f", percentages[i]) + "%                   ║");
                System.out.println("║ GRADE                       " + grades[i] + "              ║");
                
                if(percentages[i] >= 40)
                    System.out.println("║ RESULT                     PASS                                ║");
                else
                    System.out.println("║ RESULT                     FAIL                                ║");
                
                System.out.println("╚════════════════════════════════════════════════════════════╝");
                return;
            }
        }
        
        System.out.println("\nStudent with Roll No " + roll + " not found!");
    }
    
    static void displayAllMarksheets()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\n--- ALL STUDENT MARKSHEETS ---");
        System.out.println("=================================================================");
        System.out.println("Roll No\tName\t\tTotal\tPercentage\tGrade");
        System.out.println("=================================================================");
        
        for(int i=0; i<count; i++)
        {
            System.out.println(rollNos[i] + "\t" + names[i] + "\t\t" + totals[i] + "\t" + 
                             String.format("%.2f", percentages[i]) + "%\t" + grades[i]);
        }
        System.out.println("=================================================================");
    }
    
    static void displayClassResults()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        int passCount = 0;
        int failCount = 0;
        double totalPercentage = 0;
        int highest = 0;
        int lowest = 100;
        
        for(int i=0; i<count; i++)
        {
            if(percentages[i] >= 40)
                passCount++;
            else
                failCount++;
            
            totalPercentage += percentages[i];
            
            if(totals[i] > highest)
                highest = totals[i];
            
            if(totals[i] < lowest)
                lowest = totals[i];
        }
        
        double classAverage = totalPercentage / count;
        
        System.out.println("\n========== CLASS RESULTS ==========");
        System.out.println("Total Students: " + count);
        System.out.println("Students Passed: " + passCount);
        System.out.println("Students Failed: " + failCount);
        System.out.println("Pass Percentage: " + ((passCount*100.0)/count) + "%");
        System.out.println("Class Average: " + String.format("%.2f", classAverage) + "%");
        System.out.println("Highest Total Marks: " + highest);
        System.out.println("Lowest Total Marks: " + lowest);
        System.out.println("====================================");
    }
    
    static void findTopper()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        int topperIndex = 0;
        
        for(int i=1; i<count; i++)
        {
            if(percentages[i] > percentages[topperIndex])
                topperIndex = i;
        }
        
        System.out.println("\n========== CLASS TOPPER ==========");
        System.out.println("Name: " + names[topperIndex]);
        System.out.println("Roll Number: " + rollNos[topperIndex]);
        System.out.println("Total Marks: " + totals[topperIndex] + "/500");
        System.out.println("Percentage: " + String.format("%.2f", percentages[topperIndex]) + "%");
        System.out.println("Grade: " + grades[topperIndex]);
        System.out.println("===================================");
        
        //check for tie
        System.out.println("\nOther Toppers with same percentage:");
        for(int i=0; i<count; i++)
        {
            if(i != topperIndex && percentages[i] == percentages[topperIndex])
                System.out.println("- " + names[i] + " (Roll No: " + rollNos[i] + ")");
        }
    }
}