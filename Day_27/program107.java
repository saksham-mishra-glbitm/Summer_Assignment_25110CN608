import java.util.*;

public class program107
{
    static Scanner sc = new Scanner(System.in);
    static int empIds[] = new int[100];
    static String names[] = new String[100];
    static double basics[] = new double[100];
    static double hras[] = new double[100];
    static double das[] = new double[100];
    static double tas[] = new double[100];
    static double pfs[] = new double[100];
    static double taxes[] = new double[100];
    static double grossSalaries[] = new double[100];
    static double netSalaries[] = new double[100];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do          //iterate over choices
        {
            System.out.println("\n========== SALARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Employee Salary Details");
            System.out.println("2. Calculate Salary for Employee");
            System.out.println("3. Display Salary Slip");
            System.out.println("4. Display All Salaries");
            System.out.println("5. Update Salary Components");
            System.out.println("6. Exit");
            System.out.println("==============================================");
            System.out.println("Enter your choice (1-6):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addEmployee(); break;
                case 2: calculateSalary(); break;
                case 3: displaySalarySlip(); break;
                case 4: displayAllSalaries(); break;
                case 5: updateSalary(); break;
                case 6: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 6 && choice>0);
        
        sc.close();
    }
    
    static void addEmployee()       //add employee details
    {
        if(count >= 100)
        {
            System.out.println("\nStorage full!");
            return;
        }
        
        System.out.println("\n--- ADD EMPLOYEE ---");
        System.out.println("Enter Employee ID:");
        int id = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                System.out.println("Employee ID already exists!");
                return;
            }
        }
        
        System.out.println("Enter Employee Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Basic Salary:");
        double basic = sc.nextDouble();
        
        empIds[count] = id;
        names[count] = name;
        basics[count] = basic;
        count++;
        
        System.out.println("\nEmployee added successfully! ID: " + id);
    }
    
    static void calculateSalary()      //calc employee net and gross salary 
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID to calculate salary:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                // Calculate salary components
                hras[i] = basics[i] * 0.20;        //HRA = 20% of basic
                das[i] = basics[i] * 0.10;         //DA = 10% of basic
                tas[i] = basics[i] * 0.05;         //TA = 5% of basic
                pfs[i] = basics[i] * 0.12;         //PF = 12% of basic
                taxes[i] = basics[i] * 0.10;       //Tax = 10% of basic
                
                grossSalaries[i] = basics[i] + hras[i] + das[i] + tas[i];
                netSalaries[i] = grossSalaries[i] - (pfs[i] + taxes[i]);
                
                System.out.println("\nSalary calculated for: " + names[i]);
                System.out.println("Gross Salary: ₹" + grossSalaries[i]);
                System.out.println("Net Salary: ₹" + netSalaries[i]);
                return;
            }
        }
        
        System.out.println("\nEmployee with ID " + id + " not found!");
    }
    
    static void displaySalarySlip()     //display salary in a slip
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID for salary slip:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                if(grossSalaries[i] == 0)
                {
                    System.out.println("\nSalary not calculated yet! Please calculate first.");
                    return;
                }
                
                System.out.println("\n========== SALARY SLIP ==========");
                System.out.println("Employee ID: " + empIds[i]);
                System.out.println("Employee Name: " + names[i]);
                System.out.println("=================================");
                System.out.println("EARNINGS:");
                System.out.println("Basic Salary:     ₹" + basics[i]);
                System.out.println("HRA (20%):        ₹" + hras[i]);
                System.out.println("DA (10%):         ₹" + das[i]);
                System.out.println("TA (5%):          ₹" + tas[i]);
                System.out.println("---------------------------------");
                System.out.println("Gross Salary:     ₹" + grossSalaries[i]);
                System.out.println("\nDEDUCTIONS:");
                System.out.println("PF (12%):         ₹" + pfs[i]);
                System.out.println("Tax (10%):        ₹" + taxes[i]);
                System.out.println("---------------------------------");
                System.out.println("Total Deduction:  ₹" + (pfs[i] + taxes[i]));
                System.out.println("=================================");
                System.out.println("NET SALARY:       ₹" + netSalaries[i]);
                System.out.println("=================================");
                return;
            }
        }
        
        System.out.println("\nEmployee with ID " + id + " not found!");
    }
    
    static void displayAllSalaries()     //display salary of all employees
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\n--- ALL EMPLOYEE SALARIES ---");
        System.out.println("================================================================");
        System.out.println("ID\tName\t\tBasic\t\tGross\t\tNet");
        System.out.println("================================================================");
        
        double totalGross = 0, totalNet = 0;
        
        for(int i=0; i<count; i++)
        {
            if(grossSalaries[i] == 0)
                System.out.println(empIds[i] + "\t" + names[i] + "\t\t" + basics[i] + "\t\tNot Calculated\tNot Calculated");
            else
            {
                System.out.println(empIds[i] + "\t" + names[i] + "\t\t" + basics[i] + "\t\t" + grossSalaries[i] + "\t\t" + netSalaries[i]);
                totalGross += grossSalaries[i];
                totalNet += netSalaries[i];
            }
        }
        
        System.out.println("================================================================");
        System.out.println("Total Salary Budget: ₹" + totalGross);
        System.out.println("Total Net Payout: ₹" + totalNet);
    }
    
    static void updateSalary()          //update salary
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID to update salary:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                System.out.println("\nCurrent Basic Salary: ₹" + basics[i]);
                System.out.println("Enter New Basic Salary:");
                double newBasic = sc.nextDouble();
                
                basics[i] = newBasic;
                
                //reset calculations
                grossSalaries[i] = 0;
                netSalaries[i] = 0;
                
                System.out.println("\nBasic salary updated successfully!");
                System.out.println("Please recalculate salary for new values.");
                return;
            }
        }
        
        System.out.println("\nEmployee with ID " + id + " not found!");
    }
}