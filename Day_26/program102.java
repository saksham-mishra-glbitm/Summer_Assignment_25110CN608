import java.util.*;

public class program102
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("Enter the number of people to check:");
        int n = sc.nextInt();       //input number of people
        sc.nextLine();

        String names[] = new String[n];
        int days[] = new int[n];
        int months[] = new int[n];
        int years[] = new int[n];
        boolean eligible[] = new boolean[n];
        String reasons[] = new String[n];

        for(int i=0; i<n; i++)        //input details for each person
        {
            System.out.println("\n\n--- PERSON " + (i+1) + " ---");
            
            System.out.println("Enter name:");
            names[i] = sc.nextLine();
            
            System.out.println("Enter date of birth:-");
            System.out.println("\nDate: ");
            days[i] = sc.nextInt();
            System.out.println("\nMonth: ");
            months[i] = sc.nextInt();
            System.out.println("\nYear: ");
            years[i] = sc.nextInt();
            sc.nextLine();
            
            System.out.println("Are you an Indian citizen? (yes/no):");
            String citizen = sc.nextLine();
            
            System.out.println("Enter the polling area/constituency name:");
            String constituency = sc.nextLine();
            
            System.out.println("Are you ordinarily resident of " + constituency + "? (yes/no):");
            String resident = sc.nextLine();
            
            System.out.println("Are you disqualified to be enrolled as an elector? (yes/no):");
            String disqualified = sc.nextLine();
            
            // Check all eligibility conditions
            boolean citizenshipOk = citizen.equalsIgnoreCase("yes");
            boolean residentOk = resident.equalsIgnoreCase("yes");
            boolean notDisqualified = disqualified.equalsIgnoreCase("no");
            
            // Check age eligibility based on qualifying dates
            int age = years[i];
            boolean ageOk = false;
            
            if(age > 18)        //clearly above 18
                ageOk = true;

            else if(age == 18)        //need to check month and day
            {
                // Qualifying dates: 1 Jan, 1 April, 1 July, 1 Oct
                if(months[i] < 1)        //born before Jan
                    ageOk = true;
                else if(months[i] == 1 && days[i] <= 1)
                    ageOk = true;
                else if(months[i] < 4)        //born before April
                    ageOk = true;
                else if(months[i] == 4 && days[i] <= 1)
                    ageOk = true;
                else if(months[i] < 7)        //born before July
                    ageOk = true;
                else if(months[i] == 7 && days[i] <= 1)
                    ageOk = true;
                else if(months[i] < 10)        //born before October
                    ageOk = true;
                else if(months[i] == 10 && days[i] <= 1)
                    ageOk = true;
                else        //turns 18 after October
                    ageOk = false;
            }
            else        //age < 18
                ageOk = false;
            
            // Determine eligibility
            if(citizenshipOk && ageOk && residentOk && notDisqualified)
            {
                eligible[i] = true;
                reasons[i] = "ALL CONDITIONS SATISFIED";
            }
            else
            {
                eligible[i] = false;
                reasons[i] = "FAILED: ";
                if(!citizenshipOk) reasons[i] += "Not an Indian citizen. ";
                if(!ageOk) reasons[i] += "Age requirement not met (needs to be 18 by qualifying date). ";
                if(!residentOk) reasons[i] += "Not ordinarily resident of the constituency. ";
                if(!notDisqualified) reasons[i] += "Disqualified as an elector. ";
            }
        }
        
        // Display results
        System.out.println("\n\n\n========== VOTING ELIGIBILITY RESULTS ==========");
        System.out.println("==================================================");
        
        for(int i=0; i<n; i++)
        {
            System.out.println("\n--- PERSON " + (i+1) + ": " + names[i] + " ---");
            System.out.println("Date of Birth: " + days[i] + "/" + months[i] + "/" + years[i]);
            System.out.println("Status: " + (eligible[i] ? "ELIGIBLE ✓" : "NOT ELIGIBLE ✗"));
            System.out.println("Reason: " + reasons[i]);
        }
        
        // Summary count
        int countEligible = 0;
        for(int i=0; i<n; i++)
            if(eligible[i]) countEligible++;
        
        System.out.println("\n\n==================================================");
        System.out.println("SUMMARY: " + countEligible + " out of " + n + " people are eligible to vote.");
        System.out.println("==================================================");

        sc.close();        
    }
}