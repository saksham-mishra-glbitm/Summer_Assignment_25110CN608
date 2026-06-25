import java.util.*;

public class program113
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        int choice;
        double a, b, result;
        
        do
        {
            System.out.println("\n========== MENU-DRIVEN CALCULATOR ==========");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("6. Power (^)");
            System.out.println("7. Square Root (√)");
            System.out.println("8. Exit");
            System.out.println("============================================");
            System.out.println("Enter your choice (1-8):");
            choice = sc.nextInt();
            
            if(choice >= 1 && choice <= 6)
            {
                System.out.println("\nEnter first number:");
                a = sc.nextDouble();
                System.out.println("Enter second number:");
                b = sc.nextDouble();
                
                switch(choice)
                {
                    case 1:
                        result = a + b;
                        System.out.println("\nResult: " + a + " + " + b + " = " + result);
                        break;
                    case 2:
                        result = a - b;
                        System.out.println("\nResult: " + a + " - " + b + " = " + result);
                        break;
                    case 3:
                        result = a * b;
                        System.out.println("\nResult: " + a + " * " + b + " = " + result);
                        break;
                    case 4:
                        if(b == 0)
                            System.out.println("\nError! Division by zero!");
                        else
                        {
                            result = a / b;
                            System.out.println("\nResult: " + a + " / " + b + " = " + result);
                        }
                        break;
                    case 5:
                        if(b == 0)
                            System.out.println("\nError! Modulus by zero!");
                        else
                        {
                            result = a % b;
                            System.out.println("\nResult: " + a + " % " + b + " = " + result);
                        }
                        break;
                    case 6:
                        result = Math.pow(a, b);
                        System.out.println("\nResult: " + a + " ^ " + b + " = " + result);
                        break;
                }
            }
            else if(choice == 7)
            {
                System.out.println("\nEnter number:");
                a = sc.nextDouble();
                if(a < 0)
                    System.out.println("\nError! Square root of negative number!");
                else
                {
                    result = Math.sqrt(a);
                    System.out.println("\nResult: √" + a + " = " + result);
                }
            }
            else if(choice == 8)
            {
                System.out.println("\nExiting Calculator... Thank you!");
            }
            else
            {
                System.out.println("\nInvalid choice! Please enter 1-8.");
            }
            
        } while(choice != 8);
        
        sc.close();
    }
}