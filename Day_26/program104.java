import java.util.*;

public class program104
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] sm)
    {
        System.out.println("========== QUIZ APPLICATION ==========");
        System.out.println("Enter your name:");
        String name = sc.nextLine();
        
        System.out.println("\nWelcome " + name + "! Let's begin the quiz.");
        System.out.println("Instructions:");
        System.out.println("- 5 questions will be asked");
        System.out.println("- Each question has 4 options (1-4)");
        System.out.println("- Each correct answer: +2 marks");
        System.out.println("- Each wrong answer: 0 marks");
        System.out.println("- No negative marking");
        System.out.println("\nPress Enter to start...");
        sc.nextLine();
        
        // Arrays to store questions, options, and answers
        String questions[] = new String[5];
        String options[][] = new String[5][4];
        int answers[] = new int[5];
        int userAnswers[] = new int[5];
        boolean correct[] = new boolean[5];
        
        // Question 1
        questions[0] = "What is the capital of India?";
        options[0][0] = "1. Mumbai";
        options[0][1] = "2. Kolkata";
        options[0][2] = "3. New Delhi";
        options[0][3] = "4. Chennai";
        answers[0] = 3;
        
        // Question 2
        questions[1] = "Which of the following is not a Java keyword?";
        options[1][0] = "1. static";
        options[1][1] = "2. Boolean";
        options[1][2] = "3. void";
        options[1][3] = "4. private";
        answers[1] = 2;
        
        // Question 3
        questions[2] = "Who developed Java programming language?";
        options[2][0] = "1. Dennis Ritchie";
        options[2][1] = "2. James Gosling";
        options[2][2] = "3. Guido van Rossum";
        options[2][3] = "4. Bjarne Stroustrup";
        answers[2] = 2;
        
        // Question 4
        questions[3] = "Which planet is known as the Red Planet?";
        options[3][0] = "1. Jupiter";
        options[3][1] = "2. Venus";
        options[3][2] = "3. Saturn";
        options[3][3] = "4. Mars";
        answers[3] = 4;
        
        // Question 5
        questions[4] = "What is the chemical symbol for Gold?";
        options[4][0] = "1. Go";
        options[4][1] = "2. Gd";
        options[4][2] = "3. Au";
        options[4][3] = "4. Ag";
        answers[4] = 3;
        
        // Conduct quiz
        int score = 0;
        
        for(int i=0; i<5; i++)        //loop through all questions
        {
            System.out.println("\n\n========== QUESTION " + (i+1) + " ==========");
            System.out.println(questions[i]);
            System.out.println("--------------------------------");
            
            for(int j=0; j<4; j++)        //display options
                System.out.println(options[i][j]);
            
            System.out.println("--------------------------------");
            System.out.println("Enter your answer (1-4):");
            int ans = sc.nextInt();
            userAnswers[i] = ans;
            
            if(ans == answers[i])        //check if answer is correct
            {
                System.out.println("\n✓ CORRECT! +2 marks");
                score = score + 2;
                correct[i] = true;
            }
            else
            {
                System.out.println("\n✗ WRONG!");
                System.out.println("Correct answer was: " + options[i][answers[i]-1]);
                correct[i] = false;
            }
            
            System.out.println("Current score: " + score);
        }
        
        // Display final results
        System.out.println("\n\n\n========== QUIZ COMPLETED ==========");
        System.out.println("Participant: " + name);
        System.out.println("=====================================");
        
        for(int i=0; i<5; i++)        //show detailed results
        {
            System.out.println("\nQ" + (i+1) + ": " + questions[i]);
            System.out.println("   Your answer: " + options[i][userAnswers[i]-1]);
            System.out.println("   Correct answer: " + options[i][answers[i]-1]);
            System.out.println("   Result: " + (correct[i] ? "CORRECT ✓" : "WRONG ✗"));
        }
        
        int totalMarks = 10;
        double percentage = (score * 100.0) / totalMarks;
        
        System.out.println("\n=====================================");
        System.out.println("FINAL SCORE: " + score + " out of " + totalMarks);
        System.out.println("PERCENTAGE: " + percentage + "%");
        
        // Grade based on percentage
        if(percentage >= 80)
            System.out.println("GRADE: A (Excellent!)");
        else if(percentage >= 60)
            System.out.println("GRADE: B (Good!)");
        else if(percentage >= 40)
            System.out.println("GRADE: C (Average)");
        else
            System.out.println("GRADE: D (Need Improvement)");
        
        System.out.println("=====================================");
        System.out.println("\nThank you for participating, " + name + "!");
        
        sc.close();        
    }
}