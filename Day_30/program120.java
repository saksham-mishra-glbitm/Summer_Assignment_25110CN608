import java.util.*;

public class program120
{
    static Scanner sc = new Scanner(System.in);
    static int rollNos[] = new int[100];
    static String names[] = new String[100];
    static int marks[][] = new int[100][5];
    static int totals[] = new int[100];
    static double percentages[] = new double[100];
    static String grades[] = new String[100];
    static int count = 0;
    
    static String subjects[] = {"Mathematics", "Science", "English", "Computer", "Social Studies"};

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
            System.out.println("║           STUDENT GRADE MANAGEMENT SYSTEM                    ║");
            System.out.println("╠══════════════════════════════════════════════════════════════╣");
            System.out.println("║  1. Add Student & Marks                                      ║");
            System.out.println("║  2. Generate Marksheet                                      ║");
            System.out.println("║  3. Display All Students                                    ║");
            System.out.println("║  4. Search Student                                          ║");
            System.out.println("║  5. Update Marks                                            ║");
            System.out.println("║  6. Delete Student                                          ║");
            System.out.println("║  7. Display Class Results                                   ║");
            System.out.println("║  8. Find Topper                                             ║");
            System.out.println("║  9. Subject-wise Analysis                                  ║");
            System.out.println("║ 10. Exit                                                    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════╝");
            System.out.println("Enter your choice (1-10):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addStudent(); break;
                case 2: generateMarksheet(); break;
                case 3: displayAll(); break;
                case 4: searchStudent(); break;
                case 5: updateMarks(); break;
                case 6: deleteStudent(); break;
                case 7: displayClassResults(); break;
                case 8: findTopper(); break;
                case 9: subjectAnalysis(); break;
                case 10: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 10);
        
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
        
        System.out.println("Enter Student Name:");
        String name = sc.nextLine();
        
        System.out.println("\nEnter marks for 5 subjects (0-100):");
        int total = 0;
        
        for(int i=0; i<5; i++)
        {
            System.out.print(subjects[i] + ": ");
            int mark = sc.nextInt();
            
            if(mark < 0 || mark > 100)
            {
                System.out.println("Invalid marks! Must be between 0 and 100.");
                return;
            }
            
            marks[count][i] = mark;
            total += mark;
        }
        
        rollNos[count] = roll;
        names[count] = name;
        totals[count] = total;
        percentages[count] = (total * 100.0) / 500;
        grades[count] = calculateGrade(percentages[count]);
        count++;
        
        System.out.println("\n✓ Student added successfully! Roll No: " + roll);
    }
    
    static String calculateGrade(double percentage)
    {
        if(percentage >= 90) return "A+ (Excellent)";
        else if(percentage >= 80) return "A (Very Good)";
        else if(percentage >= 70) return "B+ (Good)";
        else if(percentage >= 60) return "B (Average)";
        else if(percentage >= 50) return "C (Below Average)";
        else if(percentage >= 40) return "D (Pass)";
        else return "F (Fail)";
    }
    
    static void generateMarksheet()
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
                displayMarksheet(i);
                return;
            }
        }
        
        System.out.println("\nStudent not found!");
    }
    
    static void displayMarksheet(int index)
    {
        System.out.println("\n");
        System.out.println("╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                         MARKSHEET                                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Roll Number: " + rollNos[index] + "                                                  ║");
        System.out.println("║ Student Name: " + names[index] + "                                                 ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.println("║ Subject                    Marks     Max Marks     Status           ║");
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        
        for(int i=0; i<5; i++)
        {
            String status = (marks[index][i] >= 40) ? "PASS" : "FAIL";
            System.out.printf("║ %-25s %3d        100          %-5s            ║\n", 
                             subjects[i], marks[index][i], status);
        }
        
        System.out.println("╠══════════════════════════════════════════════════════════════════════╣");
        System.out.printf("║ TOTAL                      %3d        500                             ║\n", totals[index]);
        System.out.printf("║ PERCENTAGE                  %.2f%%                                      ║\n", percentages[index]);
        System.out.println("║ GRADE                       " + grades[index] + "                              ║");
        
        String result = (percentages[index] >= 40) ? "PASS" : "FAIL";
        System.out.println("║ RESULT                      " + result + "                                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════╝");
    }
    
    static void displayAll()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\n--- ALL STUDENTS ---");
        System.out.println("=========================================================================");
        System.out.println("Roll No\tName\t\tTotal\tPercentage\tGrade");
        System.out.println("=========================================================================");
        
        for(int i=0; i<count; i++)
        {
            System.out.println(rollNos[i] + "\t" + names[i] + "\t\t" + totals[i] + "\t" + 
                             String.format("%.2f", percentages[i]) + "%\t" + grades[i]);
        }
        System.out.println("=========================================================================");
        System.out.println("Total Students: " + count);
    }
    
    static void searchStudent()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\n1. Search by Roll Number");
        System.out.println("2. Search by Name");
        System.out.println("Enter choice:");
        int ch = sc.nextInt();
        sc.nextLine();
        
        if(ch == 1)
        {
            System.out.println("Enter Roll Number:");
            int roll = sc.nextInt();
            
            for(int i=0; i<count; i++)
            {
                if(rollNos[i] == roll)
                {
                    displayMarksheet(i);
                    return;
                }
            }
        }
        else if(ch == 2)
        {
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            
            for(int i=0; i<count; i++)
            {
                if(names[i].equalsIgnoreCase(name))
                {
                    displayMarksheet(i);
                    return;
                }
            }
        }
        
        System.out.println("\nStudent not found!");
    }
    
    static void updateMarks()
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
                System.out.println("\nCurrent Marks for " + names[i] + ":");
                for(int j=0; j<5; j++)
                {
                    System.out.println(subjects[j] + ": " + marks[i][j]);
                }
                
                System.out.println("\nEnter new marks:");
                int total = 0;
                for(int j=0; j<5; j++)
                {
                    System.out.print(subjects[j] + ": ");
                    int mark = sc.nextInt();
                    
                    if(mark < 0 || mark > 100)
                    {
                        System.out.println("Invalid marks!");
                        return;
                    }
                    
                    marks[i][j] = mark;
                    total += mark;
                }
                
                totals[i] = total;
                percentages[i] = (total * 100.0) / 500;
                grades[i] = calculateGrade(percentages[i]);
                
                System.out.println("\n✓ Marks updated successfully!");
                return;
            }
        }
        
        System.out.println("\nStudent not found!");
    }
    
    static void deleteStudent()
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
                displayMarksheet(i);
                
                System.out.println("\nConfirm deletion? (yes/no):");
                sc.nextLine();
                String confirm = sc.nextLine();
                
                if(confirm.equalsIgnoreCase("yes"))
                {
                    for(int j=i; j<count-1; j++)
                    {
                        rollNos[j] = rollNos[j+1];
                        names[j] = names[j+1];
                        totals[j] = totals[j+1];
                        percentages[j] = percentages[j+1];
                        grades[j] = grades[j+1];
                        
                        for(int k=0; k<5; k++)
                            marks[j][k] = marks[j+1][k];
                    }
                    count--;
                    System.out.println("\n✓ Student deleted successfully!");
                }
                else
                {
                    System.out.println("\nDeletion cancelled.");
                }
                return;
            }
        }
        
        System.out.println("\nStudent not found!");
    }
    
    static void displayClassResults()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        int passCount = 0, failCount = 0;
        int distinctionCount = 0;
        double totalPercentage = 0;
        int highest = totals[0];
        int lowest = totals[0];
        String highestName = names[0];
        String lowestName = names[0];
        
        for(int i=0; i<count; i++)
        {
            if(percentages[i] >= 40)
                passCount++;
            else
                failCount++;
            
            if(percentages[i] >= 75)
                distinctionCount++;
            
            totalPercentage += percentages[i];
            
            if(totals[i] > highest)
            {
                highest = totals[i];
                highestName = names[i];
            }
            
            if(totals[i] < lowest)
            {
                lowest = totals[i];
                lowestName = names[i];
            }
        }
        
        double classAverage = totalPercentage / count;
        double passPercentage = (passCount * 100.0) / count;
        
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                      CLASS RESULTS                           ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║ Total Students:              " + count + "                                         ║");
        System.out.println("║ Students Passed:             " + passCount + "                                         ║");
        System.out.println("║ Students Failed:             " + failCount + "                                         ║");
        System.out.println("║ Pass Percentage:             " + String.format("%.2f", passPercentage) + "%                                        ║");
        System.out.println("║ Class Average:               " + String.format("%.2f", classAverage) + "%                                        ║");
        System.out.println("║ Students with Distinction:   " + distinctionCount + "                                         ║");
        System.out.println("║ Highest Scorer:              " + highestName + " (" + highest + "/500)                      ║");
        System.out.println("║ Lowest Scorer:               " + lowestName + " (" + lowest + "/500)                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
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
        
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                       CLASS TOPPER                            ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║ Name:                    " + names[topperIndex] + "                                         ║");
        System.out.println("║ Roll Number:             " + rollNos[topperIndex] + "                                         ║");
        System.out.println("║ Total Marks:             " + totals[topperIndex] + "/500                                      ║");
        System.out.println("║ Percentage:              " + String.format("%.2f", percentages[topperIndex]) + "%                                        ║");
        System.out.println("║ Grade:                   " + grades[topperIndex] + "                                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        // Check for ties
        System.out.println("\nOther toppers with same percentage:");
        boolean hasTie = false;
        for(int i=0; i<count; i++)
        {
            if(i != topperIndex && percentages[i] == percentages[topperIndex])
            {
                System.out.println("- " + names[i] + " (Roll No: " + rollNos[i] + ")");
                hasTie = true;
            }
        }
        
        if(!hasTie)
            System.out.println("No ties found.");
    }
    
    static void subjectAnalysis()
    {
        if(count == 0)
        {
            System.out.println("\nNo student records found!");
            return;
        }
        
        System.out.println("\n--- SUBJECT-WISE ANALYSIS ---");
        System.out.println("==================================================");
        
        for(int i=0; i<5; i++)
        {
            int subjectTotal = 0;
            int highest = marks[0][i];
            int lowest = marks[0][i];
            int passCount = 0;
            
            for(int j=0; j<count; j++)
            {
                subjectTotal += marks[j][i];
                
                if(marks[j][i] > highest)
                    highest = marks[j][i];
                
                if(marks[j][i] < lowest)
                    lowest = marks[j][i];
                
                if(marks[j][i] >= 40)
                    passCount++;
            }
            
            double average = (double)subjectTotal / count;
            double passPercentage = (passCount * 100.0) / count;
            
            System.out.println("\n" + subjects[i].toUpperCase() + ":");
            System.out.println("  Average Marks: " + String.format("%.2f", average));
            System.out.println("  Highest Marks: " + highest);
            System.out.println("  Lowest Marks: " + lowest);
            System.out.println("  Pass Percentage: " + String.format("%.2f", passPercentage) + "%");
        }
        System.out.println("==================================================");
    }
}