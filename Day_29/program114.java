import java.util.*;

public class program114
{
    static Scanner sc = new Scanner(System.in);
    static int arr[] = new int[100];
    static int size = 0;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== ARRAY OPERATIONS SYSTEM ==========");
            System.out.println("1. Create Array");
            System.out.println("2. Display Array");
            System.out.println("3. Insert Element at Position");
            System.out.println("4. Delete Element by Value");
            System.out.println("5. Delete Element by Position");
            System.out.println("6. Search Element");
            System.out.println("7. Sort Array");
            System.out.println("8. Find Maximum");
            System.out.println("9. Find Minimum");
            System.out.println("10. Calculate Sum & Average");
            System.out.println("11. Reverse Array");
            System.out.println("12. Exit");
            System.out.println("=============================================");
            System.out.println("Enter your choice (1-12):");
            choice = sc.nextInt();
            
            switch(choice)
            {
                case 1: createArray(); break;
                case 2: displayArray(); break;
                case 3: insertElement(); break;
                case 4: deleteByValue(); break;
                case 5: deleteByPosition(); break;
                case 6: searchElement(); break;
                case 7: sortArray(); break;
                case 8: findMax(); break;
                case 9: findMin(); break;
                case 10: sumAndAverage(); break;
                case 11: reverseArray(); break;
                case 12: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 12);
        
        sc.close();
    }
    
    static void createArray()        //create new array
    {
        System.out.println("\n--- CREATE ARRAY ---");
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        
        if(n <= 0 || n > 100)
        {
            System.out.println("Invalid size! Must be between 1 and 100.");
            return;
        }
        
        System.out.println("Enter " + n + " elements:");
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        size = n;
        System.out.println("\nArray created successfully!");
        displayArray();
    }
    
    static void displayArray()        //display array elements
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty! Please create array first.");
            return;
        }
        
        System.out.print("\nArray elements: [");
        for(int i=0; i<size; i++)
        {
            System.out.print(arr[i]);
            if(i < size-1)
                System.out.print(", ");
        }
        System.out.println("]");
        System.out.println("Size: " + size);
    }
    
    static void insertElement()        //insert element at specific position
    {
        if(size >= 100)
        {
            System.out.println("\nArray is full! Cannot insert.");
            return;
        }
        
        System.out.println("\n--- INSERT ELEMENT ---");
        System.out.println("Enter element to insert:");
        int element = sc.nextInt();
        
        System.out.println("Enter position (1 to " + (size+1) + "):");
        int pos = sc.nextInt();
        
        if(pos < 1 || pos > size+1)
        {
            System.out.println("Invalid position!");
            return;
        }
        
        for(int i=size; i>=pos; i--)
            arr[i] = arr[i-1];
        
        arr[pos-1] = element;
        size++;
        
        System.out.println("\nElement inserted successfully!");
        displayArray();
    }
    
    static void deleteByValue()        //delete element by value
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        System.out.println("\n--- DELETE BY VALUE ---");
        System.out.println("Enter element to delete:");
        int element = sc.nextInt();
        
        int index = -1;
        for(int i=0; i<size; i++)
        {
            if(arr[i] == element)
            {
                index = i;
                break;
            }
        }
        
        if(index == -1)
        {
            System.out.println("Element not found!");
            return;
        }
        
        for(int i=index; i<size-1; i++)
            arr[i] = arr[i+1];
        
        size--;
        System.out.println("\nElement deleted successfully!");
        displayArray();
    }
    
    static void deleteByPosition()        //delete element by position
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        System.out.println("\n--- DELETE BY POSITION ---");
        System.out.println("Enter position (1 to " + size + "):");
        int pos = sc.nextInt();
        
        if(pos < 1 || pos > size)
        {
            System.out.println("Invalid position!");
            return;
        }
        
        int deleted = arr[pos-1];
        
        for(int i=pos-1; i<size-1; i++)
            arr[i] = arr[i+1];
        
        size--;
        System.out.println("\nDeleted element: " + deleted);
        displayArray();
    }
    
    static void searchElement()        //search for an element
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        System.out.println("\n--- SEARCH ELEMENT ---");
        System.out.println("Enter element to search:");
        int element = sc.nextInt();
        
        boolean found = false;
        for(int i=0; i<size; i++)
        {
            if(arr[i] == element)
            {
                System.out.println("Element found at position " + (i+1));
                found = true;
            }
        }
        
        if(!found)
            System.out.println("Element not found!");
    }
    
    static void sortArray()        //sort array in ascending order
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        System.out.println("\n--- SORT ARRAY ---");
        
        for(int i=0; i<size-1; i++)
        {
            for(int j=0; j<size-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        System.out.println("Array sorted in ascending order!");
        displayArray();
    }
    
    static void findMax()        //find maximum element
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        int max = arr[0];
        for(int i=1; i<size; i++)
        {
            if(arr[i] > max)
                max = arr[i];
        }
        
        System.out.println("\nMaximum element: " + max);
    }
    
    static void findMin()        //find minimum element
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        int min = arr[0];
        for(int i=1; i<size; i++)
        {
            if(arr[i] < min)
                min = arr[i];
        }
        
        System.out.println("\nMinimum element: " + min);
    }
    
    static void sumAndAverage()        //calculate sum and average
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        int sum = 0;
        for(int i=0; i<size; i++)
            sum += arr[i];
        
        double average = (double)sum / size;
        
        System.out.println("\n--- SUM & AVERAGE ---");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + String.format("%.2f", average));
    }
    
    static void reverseArray()        //reverse the array
    {
        if(size == 0)
        {
            System.out.println("\nArray is empty!");
            return;
        }
        
        System.out.println("\n--- REVERSE ARRAY ---");
        
        for(int i=0, j=size-1; i<j; i++, j--)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        System.out.println("Array reversed successfully!");
        displayArray();
    }
}