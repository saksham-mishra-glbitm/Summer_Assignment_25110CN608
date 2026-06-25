import java.util.*;

public class program115
{
    static Scanner sc = new Scanner(System.in);
    static String str = "";

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== STRING OPERATIONS SYSTEM ==========");
            System.out.println("1. Input String");
            System.out.println("2. Display String");
            System.out.println("3. Find Length");
            System.out.println("4. Reverse String");
            System.out.println("5. Check Palindrome");
            System.out.println("6. Count Vowels & Consonants");
            System.out.println("7. Count Words");
            System.out.println("8. Convert Case (Upper/Lower)");
            System.out.println("9. Remove Spaces");
            System.out.println("10. Find Character Frequency");
            System.out.println("11. Find Substring");
            System.out.println("12. Replace Character");
            System.out.println("13. Exit");
            System.out.println("==============================================");
            System.out.println("Enter your choice (1-13):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: inputString(); break;
                case 2: displayString(); break;
                case 3: findLength(); break;
                case 4: reverseString(); break;
                case 5: checkPalindrome(); break;
                case 6: countVowelsConsonants(); break;
                case 7: countWords(); break;
                case 8: convertCase(); break;
                case 9: removeSpaces(); break;
                case 10: findCharFrequency(); break;
                case 11: findSubstring(); break;
                case 12: replaceCharacter(); break;
                case 13: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 13);
        
        sc.close();
    }
    
    static void inputString()        //input string from user
    {
        System.out.println("\n--- INPUT STRING ---");
        System.out.println("Enter a string:");
        str = sc.nextLine().trim();
        System.out.println("\nString stored successfully!");
    }
    
    static void displayString()        //display current string
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        System.out.println("\nCurrent String: \"" + str + "\"");
    }
    
    static void findLength()        //find string length
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        System.out.println("\nLength of string: " + str.length());
    }
    
    static void reverseString()        //reverse the string
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        String rev = "";
        for(int i=str.length()-1; i>=0; i--)
            rev += str.charAt(i);
        
        System.out.println("\nOriginal String: \"" + str + "\"");
        System.out.println("Reversed String: \"" + rev + "\"");
    }
    
    static void checkPalindrome()        //check if string is palindrome
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        boolean isPalindrome = true;
        for(int i=0, j=str.length()-1; i<j; i++, j--)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                isPalindrome = false;
                break;
            }
        }
        
        if(isPalindrome)
            System.out.println("\n\"" + str + "\" is a PALINDROME!");
        else
            System.out.println("\n\"" + str + "\" is NOT a palindrome.");
    }
    
    static void countVowelsConsonants()        //count vowels and consonants
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        String vowelsSet = "aeiouAEIOU";
        int vowels = 0, consonants = 0;
        
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(Character.isLetter(ch))
            {
                if(vowelsSet.indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }
        
        System.out.println("\n--- VOWELS & CONSONANTS ---");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    static void countWords()        //count number of words
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        String trimmed = str.trim();
        if(trimmed.isEmpty())
        {
            System.out.println("\nNumber of words: 0");
            return;
        }
        
        String[] words = trimmed.split("\\s+");
        System.out.println("\nNumber of words: " + words.length);
    }
    
    static void convertCase()        //convert to upper or lower case
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        System.out.println("\n--- CONVERT CASE ---");
        System.out.println("1. Uppercase");
        System.out.println("2. Lowercase");
        System.out.println("Enter choice:");
        int ch = sc.nextInt();
        sc.nextLine();
        
        if(ch == 1)
            System.out.println("\nUppercase: \"" + str.toUpperCase() + "\"");
        else if(ch == 2)
            System.out.println("\nLowercase: \"" + str.toLowerCase() + "\"");
        else
            System.out.println("Invalid choice!");
    }
    
    static void removeSpaces()        //remove all spaces from string
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        String noSpaces = str.replaceAll(" ", "");
        System.out.println("\nOriginal: \"" + str + "\"");
        System.out.println("Without spaces: \"" + noSpaces + "\"");
    }
    
    static void findCharFrequency()        //find frequency of a character
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        System.out.println("\nEnter character to find frequency:");
        char ch = sc.nextLine().charAt(0);
        
        int count = 0;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) == ch)
                count++;
        }
        
        System.out.println("\nFrequency of '" + ch + "': " + count);
    }
    
    static void findSubstring()        //check if substring exists
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        System.out.println("\nEnter substring to search:");
        String sub = sc.nextLine();
        
        if(str.indexOf(sub) != -1)
        {
            int pos = str.indexOf(sub);
            System.out.println("\nSubstring found at position " + pos);
        }
        else
        {
            System.out.println("\nSubstring not found!");
        }
    }
    
    static void replaceCharacter()        //replace character in string
    {
        if(str.isEmpty())
        {
            System.out.println("\nString is empty! Please input string first.");
            return;
        }
        
        System.out.println("\nEnter character to replace:");
        char oldChar = sc.nextLine().charAt(0);
        
        System.out.println("Enter new character:");
        char newChar = sc.nextLine().charAt(0);
        
        String newStr = str.replace(oldChar, newChar);
        
        System.out.println("\nOriginal: \"" + str + "\"");
        System.out.println("Modified: \"" + newStr + "\"");
    }
}