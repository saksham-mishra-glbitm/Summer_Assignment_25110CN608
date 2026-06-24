import java.util.*;

public class program110
{
    static Scanner sc = new Scanner(System.in);
    static int accountNos[] = new int[100];
    static String names[] = new String[100];
    static String phones[] = new String[100];
    static double balances[] = new double[100];
    static String accountTypes[] = new String[100]; // Savings/Current
    static int count = 0;
    static int nextAccountNo = 1001;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== BANK ACCOUNT SYSTEM ==========");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Search Account");
            System.out.println("7. Delete Account");
            System.out.println("8. Exit");
            System.out.println("=========================================");
            System.out.println("Enter your choice (1-8):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: checkBalance(); break;
                case 5: displayAllAccounts(); break;
                case 6: searchAccount(); break;
                case 7: deleteAccount(); break;
                case 8: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 8 &&choice>0);
        
        sc.close();
    }
    
    static void createAccount()        //create new bank account
    {
        if(count >= 100)
        {
            System.out.println("\nCannot create more accounts! Storage full.");
            return;
        }
        
        System.out.println("\n--- CREATE ACCOUNT ---");
        System.out.println("Account Number: " + nextAccountNo);
        
        System.out.println("Enter Account Holder Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Phone Number:");
        String phone = sc.nextLine();
        
        System.out.println("Enter Account Type (Savings/Current):");
        String type = sc.nextLine();
        
        System.out.println("Enter Initial Deposit Amount (Minimum ₹500):");
        double deposit = sc.nextDouble();
        
        if(deposit < 500)
        {
            System.out.println("Minimum deposit of ₹500 required!");
            return;
        }
        
        accountNos[count] = nextAccountNo;
        names[count] = name;
        phones[count] = phone;
        accountTypes[count] = type;
        balances[count] = deposit;
        count++;
        
        System.out.println("\nAccount created successfully!");
        System.out.println("Account Number: " + nextAccountNo);
        nextAccountNo++;
    }
    
    static int findAccount(int accNo)        //find account index by account number
    {
        for(int i=0; i<count; i++)
        {
            if(accountNos[i] == accNo)
                return i;
        }
        return -1;
    }
    
    static void deposit()        //deposit money
    {
        if(count == 0)
        {
            System.out.println("\nNo accounts found!");
            return;
        }
        
        System.out.println("\nEnter Account Number:");
        int accNo = sc.nextInt();
        
        int index = findAccount(accNo);
        if(index == -1)
        {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Enter amount to deposit:");
        double amount = sc.nextDouble();
        
        if(amount <= 0)
        {
            System.out.println("Invalid amount!");
            return;
        }
        
        balances[index] += amount;
        System.out.println("\n₹" + amount + " deposited successfully!");
        System.out.println("New Balance: ₹" + balances[index]);
    }
    
    static void withdraw()        //withdraw money
    {
        if(count == 0)
        {
            System.out.println("\nNo accounts found!");
            return;
        }
        
        System.out.println("\nEnter Account Number:");
        int accNo = sc.nextInt();
        
        int index = findAccount(accNo);
        if(index == -1)
        {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("Enter amount to withdraw:");
        double amount = sc.nextDouble();
        
        if(amount <= 0)
        {
            System.out.println("Invalid amount!");
            return;
        }
        
        if(amount > balances[index])
        {
            System.out.println("Insufficient balance! Available: ₹" + balances[index]);
            return;
        }
        
        double minBalance = accountTypes[index].equalsIgnoreCase("Savings") ? 500 : 0;
        if(balances[index] - amount < minBalance)
        {
            System.out.println("Minimum balance of ₹" + minBalance + " required!");
            return;
        }
        
        balances[index] -= amount;
        System.out.println("\n₹" + amount + " withdrawn successfully!");
        System.out.println("Remaining Balance: ₹" + balances[index]);
    }
    
    static void checkBalance()        //check account balance
    {
        if(count == 0)
        {
            System.out.println("\nNo accounts found!");
            return;
        }
        
        System.out.println("\nEnter Account Number:");
        int accNo = sc.nextInt();
        
        int index = findAccount(accNo);
        if(index == -1)
        {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Account Number: " + accountNos[index]);
        System.out.println("Holder Name: " + names[index]);
        System.out.println("Account Type: " + accountTypes[index]);
        System.out.println("Current Balance: ₹" + balances[index]);
    }
    
    static void displayAllAccounts()        //display all accounts
    {
        if(count == 0)
        {
            System.out.println("\nNo accounts found!");
            return;
        }
        
        System.out.println("\n--- ALL ACCOUNTS ---");
        System.out.println("=========================================================================");
        System.out.println("Acc No\tHolder Name\t\tPhone\t\tType\t\tBalance");
        System.out.println("=========================================================================");
        
        double totalBalance = 0;
        for(int i=0; i<count; i++)
        {
            System.out.println(accountNos[i] + "\t" + names[i] + "\t\t" + phones[i] + "\t" + accountTypes[i] + "\t\t₹" + balances[i]);
            totalBalance += balances[i];
        }
        System.out.println("=========================================================================");
        System.out.println("Total Accounts: " + count);
        System.out.println("Total Bank Balance: ₹" + totalBalance);
    }
    
    static void searchAccount()        //search account by number
    {
        if(count == 0)
        {
            System.out.println("\nNo accounts found!");
            return;
        }
        
        System.out.println("\nEnter Account Number:");
        int accNo = sc.nextInt();
        
        int index = findAccount(accNo);
        if(index == -1)
        {
            System.out.println("Account not found!");
            return;
        }
        
        System.out.println("\n--- ACCOUNT FOUND ---");
        System.out.println("Account Number: " + accountNos[index]);
        System.out.println("Holder Name: " + names[index]);
        System.out.println("Phone: " + phones[index]);
        System.out.println("Account Type: " + accountTypes[index]);
        System.out.println("Balance: ₹" + balances[index]);
    }
    
    static void deleteAccount()        //delete an account
    {
        if(count == 0)
        {
            System.out.println("\nNo accounts found!");
            return;
        }
        
        System.out.println("\nEnter Account Number:");
        int accNo = sc.nextInt();
        
        int index = findAccount(accNo);
        if(index == -1)
        {
            System.out.println("Account not found!");
            return;
        }
        
        if(balances[index] > 0)
        {
            System.out.println("Cannot delete account with positive balance!");
            System.out.println("Please withdraw ₹" + balances[index] + " first.");
            return;
        }
        
        for(int j=index; j<count-1; j++)
        {
            accountNos[j] = accountNos[j+1];
            names[j] = names[j+1];
            phones[j] = phones[j+1];
            accountTypes[j] = accountTypes[j+1];
            balances[j] = balances[j+1];
        }
        count--;
        
        System.out.println("\nAccount deleted successfully!");
    }
}