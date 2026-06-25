import java.util.*;

public class program119
{
    static Scanner sc = new Scanner(System.in);
    static int empIds[] = new int[100];
    static String names[] = new String[100];
    static String departments[] = new String[100];
    static String designations[] = new String[100];
    static double salaries[] = new double[100];
    static long phones[] = new long[100];
    static String emails[] = new String[100];
    static String dojs[] = new String[100];
    static int count = 0;
    static int nextId = 1001;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== MINI EMPLOYEE MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Department");
            System.out.println("6. Update Salary");
            System.out.println("7. Delete Employee");
            System.out.println("8. Display Department-wise");
            System.out.println("9. Calculate Payroll");
            System.out.println("10. Exit");
            System.out.println("====================================================");
            System.out.println("Enter your choice (1-10):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addEmployee(); break;
                case 2: displayAll(); break;
                case 3: searchById(); break;
                case 4: searchByName(); break;
                case 5: searchByDept(); break;
                case 6: updateSalary(); break;
                case 7: deleteEmployee(); break;
                case 8: displayByDept(); break;
                case 9: calculatePayroll(); break;
                case 10: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 10);
        
        sc.close();
    }
    
    static void addEmployee()
    {
        if(count >= 100)
        {
            System.out.println("\nStorage full!");
            return;
        }
        
        System.out.println("\n--- ADD EMPLOYEE ---");
        System.out.println("Employee ID will be: " + nextId);
        
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Department (HR/IT/SALES/FINANCE):");
        String dept = sc.nextLine();
        
        System.out.println("Enter Designation:");
        String desig = sc.nextLine();
        
        System.out.println("Enter Salary:");
        double salary = sc.nextDouble();
        
        System.out.println("Enter Phone:");
        long phone = sc.nextLong();
        sc.nextLine();
        
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        
        System.out.println("Enter Date of Joining (DD/MM/YYYY):");
        String doj = sc.nextLine();
        
        empIds[count] = nextId;
        names[count] = name;
        departments[count] = dept;
        designations[count] = desig;
        salaries[count] = salary;
        phones[count] = phone;
        emails[count] = email;
        dojs[count] = doj;
        count++;
        
        System.out.println("\nEmployee added successfully! ID: " + nextId);
        nextId++;
    }
    
    static void displayAll()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\n--- ALL EMPLOYEES ---");
        System.out.println("=================================================================================");
        System.out.println("ID\tName\t\tDept\t\tDesignation\tSalary\t\tPhone");
        System.out.println("=================================================================================");
        
        for(int i=0; i<count; i++)
        {
            System.out.println(empIds[i] + "\t" + names[i] + "\t\t" + departments[i] + "\t\t" + 
                             designations[i] + "\t₹" + salaries[i] + "\t" + phones[i]);
        }
        System.out.println("=================================================================================");
        System.out.println("Total Employees: " + count);
    }
    
    static void searchById()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                displayEmployee(i);
                return;
            }
        }
        
        System.out.println("\nEmployee not found!");
    }
    
    static void searchByName()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Name:");
        sc.nextLine();
        String name = sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(names[i].equalsIgnoreCase(name))
            {
                displayEmployee(i);
                return;
            }
        }
        
        System.out.println("\nEmployee not found!");
    }
    
    static void searchByDept()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Department:");
        sc.nextLine();
        String dept = sc.nextLine();
        
        boolean found = false;
        System.out.println("\n--- EMPLOYEES IN " + dept.toUpperCase() + " ---");
        System.out.println("==============================================");
        
        for(int i=0; i<count; i++)
        {
            if(departments[i].equalsIgnoreCase(dept))
            {
                System.out.println(empIds[i] + " - " + names[i] + " (" + designations[i] + ")");
                found = true;
            }
        }
        
        if(!found)
            System.out.println("No employees found in " + dept + " department!");
    }
    
    static void displayEmployee(int index)
    {
        System.out.println("\n--- EMPLOYEE DETAILS ---");
        System.out.println("Employee ID: " + empIds[index]);
        System.out.println("Name: " + names[index]);
        System.out.println("Department: " + departments[index]);
        System.out.println("Designation: " + designations[index]);
        System.out.println("Salary: ₹" + salaries[index]);
        System.out.println("Phone: " + phones[index]);
        System.out.println("Email: " + emails[index]);
        System.out.println("Date of Joining: " + dojs[index]);
    }
    
    static void updateSalary()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                System.out.println("\nCurrent Salary: ₹" + salaries[i]);
                System.out.println("Enter New Salary:");
                double newSalary = sc.nextDouble();
                
                if(newSalary < 0)
                {
                    System.out.println("Salary cannot be negative!");
                    return;
                }
                
                salaries[i] = newSalary;
                System.out.println("\nSalary updated successfully!");
                return;
            }
        }
        
        System.out.println("\nEmployee not found!");
    }
    
    static void deleteEmployee()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                displayEmployee(i);
                
                System.out.println("\nConfirm deletion? (yes/no):");
                sc.nextLine();
                String confirm = sc.nextLine();
                
                if(confirm.equalsIgnoreCase("yes"))
                {
                    for(int j=i; j<count-1; j++)
                    {
                        empIds[j] = empIds[j+1];
                        names[j] = names[j+1];
                        departments[j] = departments[j+1];
                        designations[j] = designations[j+1];
                        salaries[j] = salaries[j+1];
                        phones[j] = phones[j+1];
                        emails[j] = emails[j+1];
                        dojs[j] = dojs[j+1];
                    }
                    count--;
                    System.out.println("\nEmployee deleted successfully!");
                }
                else
                {
                    System.out.println("\nDeletion cancelled.");
                }
                return;
            }
        }
        
        System.out.println("\nEmployee not found!");
    }
    
    static void displayByDept()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\n--- DEPARTMENT-WISE EMPLOYEES ---");
        String[] depts = {"HR", "IT", "SALES", "FINANCE"};
        
        for(String dept : depts)
        {
            int deptCount = 0;
            double deptSalary = 0;
            
            System.out.println("\n" + dept + " DEPARTMENT:");
            System.out.println("----------------------------------------");
            
            for(int i=0; i<count; i++)
            {
                if(departments[i].equalsIgnoreCase(dept))
                {
                    System.out.println(empIds[i] + " - " + names[i] + " (" + designations[i] + ") - ₹" + salaries[i]);
                    deptCount++;
                    deptSalary += salaries[i];
                }
            }
            
            if(deptCount == 0)
                System.out.println("No employees in " + dept + " department");
            else
                System.out.println("Total: " + deptCount + " employees | Total Salary: ₹" + deptSalary);
        }
    }
    
    static void calculatePayroll()
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        double totalSalary = 0;
        double highest = salaries[0];
        double lowest = salaries[0];
        String highestName = names[0];
        String lowestName = names[0];
        
        for(int i=0; i<count; i++)
        {
            totalSalary += salaries[i];
            
            if(salaries[i] > highest)
            {
                highest = salaries[i];
                highestName = names[i];
            }
            
            if(salaries[i] < lowest)
            {
                lowest = salaries[i];
                lowestName = names[i];
            }
        }
        
        double average = totalSalary / count;
        
        System.out.println("\n--- PAYROLL SUMMARY ---");
        System.out.println("Total Employees: " + count);
        System.out.println("Total Monthly Salary: ₹" + totalSalary);
        System.out.println("Average Salary: ₹" + String.format("%.2f", average));
        System.out.println("Highest Paid: " + highestName + " (₹" + highest + ")");
        System.out.println("Lowest Paid: " + lowestName + " (₹" + lowest + ")");
        System.out.println("Yearly Payroll Cost: ₹" + (totalSalary * 12));
    }
}