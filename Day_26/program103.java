import java.util.*;

public class program103
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter your 4-digit ATM PIN:");
        int pin = sc.nextInt();       //input PIN
        
        int balance = 50000;        //initial balance
        boolean authenticated = false;
        
        // PIN verification with 3 attempts
        for(int i=1; i<=3; i++)
        {
            System.out.println("\nEnter PIN to access account (Attempt " +i+ "/3):");
            int enteredPin = sc.nextInt();
            
            if(enteredPin == pin)
            {
                authenticated = true;
                break;
            }
            else
                System.out.println("Incorrect PIN!");
        }
        
        if(!authenticated)
        {
            System.out.println("\nToo many failed attempts! Account locked.");
            sc.close();
            return;
        }
        
        System.out.println("\nACCESS GRANTED. Welcome to ATM!");
        
        int choice;
        do                                                   //main ATM menu loop
        {
            System.out.println("\n========== ATM MENU ==========");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Change PIN");
            System.out.println("4. Exit");
            System.out.println("==============================");
            System.out.println("Enter your choice (1-4):");
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1:          //Check Balance
                    System.out.println("\nYour current balance is: ₹" + balance);
                    System.out.println("Available balance: ₹" + balance);
                    break;
                    
                case 2:        //Withdraw Cash
                    System.out.println("\nEnter amount to withdraw (₹100, ₹500, ₹1000 multiples only):");
                    int withdraw = sc.nextInt();
                    
                    if(withdraw <= 0)   System.out.println("Invalid amount!");
                    else if(withdraw > balance)
                        System.out.println("Insufficient balance! Your balance is ₹" + balance);
                    else if(withdraw > 10000)
                        System.out.println("Maximum withdrawal limit per transaction is ₹10,000!");
                    else if(withdraw % 100 != 0)
                        System.out.println("Amount must be in multiples of ₹100!");
                    else
                    {
                        balance = balance - withdraw;
                        System.out.println("\nPlease collect your cash: ₹" + withdraw);
                        System.out.println("Remaining balance: ₹" + balance);
                    }
                    break;
                    
                case 3:        //Change PIN
                    System.out.println("\nEnter old PIN:");
                    int oldPin = sc.nextInt();
                    
                    if(oldPin == pin)
                    {
                        System.out.println("Enter new 4-digit PIN:");
                        int newPin = sc.nextInt();
                        System.out.println("Confirm new PIN:");
                        int confirmPin = sc.nextInt();
                        
                        if(newPin == confirmPin && newPin >= 1000 && newPin <= 9999)
                        {
                            pin = newPin;
                            System.out.println("PIN changed successfully!");
                        }
                        else
                            System.out.println("PIN mismatch or invalid PIN format!");
                    }
                    else
                        System.out.println("Incorrect old PIN!");
                    break;
                    
                case 4:        //Exit
                    System.out.println("\nThank you for using ATM. Have a nice day!");

                    break;
                    
                default:
                    System.out.println("\nInvalid choice! Please enter 1-4.");
            }
            
        }while(choice != 4);
        
        sc.close();        
    }
}