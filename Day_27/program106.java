import java.util.*;

public class program106
{
    static Scanner sc = new Scanner(System.in);
    static int empIds[] = new int[100];
    static String names[] = new String[100];
    static String departments[] = new String[100];
    static String designations[] = new String[100];
    static double salaries[] = new double[100];
    static long phones[] = new long[100];
    static int count = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do          //iterate over choice
        {
            System.out.println("\n========== EMPLOYEE MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Details");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Department-wise Employees");
            System.out.println("7. Exit");
            System.out.println("================================================");
            System.out.println("Enter your choice (1-7):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addEmployee();          break;
                case 2: displayAll();           break;
                case 3: searchEmployee();       break;
                case 4: updateEmployee();       break;
                case 5: deleteEmployee();       break;
                case 6: displayByDepartment();  break;
                case 7: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 7  && choice>0);
        
        sc.close();
    }
    
    static void addEmployee()       //add employee data
    {
        if(count >= 50)
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
        
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Department (HR/IT/SALES/FINANCE/OTHERS):");
        String dept = sc.nextLine();
        
        System.out.println("Enter Designation:");
        String desig = sc.nextLine();
        
        System.out.println("Enter Salary:");
        double sal = sc.nextDouble();
        
        System.out.println("Enter Phone Number:");
        long phone = sc.nextLong();
        
        empIds[count] = id;
        names[count] = name;
        departments[count] = dept;
        designations[count] = desig;
        salaries[count] = sal;
        phones[count] = phone;
        count++;
        
        System.out.println("\nEmployee added successfully! ID: " + id);
    }
    
    static void displayAll()        //display all employees' data
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\n--- ALL EMPLOYEES ---");
        System.out.println("=================================================================");
        System.out.println("ID\tName\t\tDept\t\tDesignation\tSalary\t\tPhone");
        System.out.println("=================================================================");
        
        for(int i=0; i<count; i++)
        {
            System.out.println(empIds[i] + "\t" + names[i] + "\t\t" + departments[i] + "\t\t" + 
                             designations[i] + "\t" + salaries[i] + "\t\t" + phones[i]);
        }
        System.out.println("=================================================================");
        System.out.println("Total Employees: " + count);
        
        //calculate total salary
        double totalSalary = 0;
        for(int i=0; i<count; i++)
            totalSalary += salaries[i];
        System.out.println("Total Salary Budget: ₹" + totalSalary);
        System.out.println("Average Salary: ₹" + (totalSalary/count));
    }
    
    static void searchEmployee()        //search for an employee
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID to search:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                System.out.println("\n--- EMPLOYEE FOUND ---");
                System.out.println("ID: " + empIds[i]);
                System.out.println("Name: " + names[i]);
                System.out.println("Department: " + departments[i]);
                System.out.println("Designation: " + designations[i]);
                System.out.println("Salary: ₹" + salaries[i]);
                System.out.println("Phone: " + phones[i]);
                return;
            }
        }
        
        System.out.println("\nEmployee with ID " + id + " not found!");
    }
    
    static void updateEmployee()        //update employee detail
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID to update:");
        int id = sc.nextInt();
        sc.nextLine();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                System.out.println("\nCurrent Details:");
                System.out.println("Name: " + names[i]);
                System.out.println("Department: " + departments[i]);
                System.out.println("Designation: " + designations[i]);
                System.out.println("Salary: ₹" + salaries[i]);
                
                System.out.println("\nEnter New Name:");
                names[i] = sc.nextLine();
                
                System.out.println("Enter New Department:");
                departments[i] = sc.nextLine();
                
                System.out.println("Enter New Designation:");
                designations[i] = sc.nextLine();
                
                System.out.println("Enter New Salary:");
                salaries[i] = sc.nextDouble();
                
                System.out.println("\nEmployee record updated successfully!");
                return;
            }
        }
        
        System.out.println("\nEmployee with ID " + id + " not found!");
    }
    
    static void deleteEmployee()        //delete employee data
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Employee ID to delete:");
        int id = sc.nextInt();
        
        for(int i=0; i<count; i++)
        {
            if(empIds[i] == id)
            {
                for(int j=i; j<count-1; j++)
                {
                    empIds[j] = empIds[j+1];
                    names[j] = names[j+1];
                    departments[j] = departments[j+1];
                    designations[j] = designations[j+1];
                    salaries[j] = salaries[j+1];
                    phones[j] = phones[j+1];
                }
                count--;
                System.out.println("\nEmployee deleted successfully!");
                return;
            }
        }
        
        System.out.println("\nEmployee with ID " + id + " not found!");
    }
    
    static void displayByDepartment()           //display employees' data by dept
    {
        if(count == 0)
        {
            System.out.println("\nNo employee records found!");
            return;
        }
        
        System.out.println("\nEnter Department (HR/IT/SALES/FINANCE):");
        String dept = sc.nextLine();
        
        System.out.println("\n--- EMPLOYEES IN " + dept.toUpperCase() + " DEPARTMENT ---");
        System.out.println("==================================================");
        System.out.println("ID\tName\t\tDesignation\tSalary");
        System.out.println("==================================================");
        
        int deptCount = 0;
        double deptSalary = 0;
        
        for(int i=0; i<count; i++)
        {
            if(departments[i].equalsIgnoreCase(dept))
            {
                System.out.println(empIds[i] + "\t" + names[i] + "\t\t" + designations[i] + "\t\t" + salaries[i]);
                deptCount++;
                deptSalary += salaries[i];
            }
        }
        
        System.out.println("==================================================");
        System.out.println("Total Employees in " + dept + ": " + deptCount);
        System.out.println("Total Salary Budget: ₹" + deptSalary);
    }
}