import java.util.*;

public class program70 
{
	public static void main(String[] sm) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int n = sc.nextInt();       //input size
		System.out.println("Enter " + (n) + " integers in the array: ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)        //input elements
		{
			arr[i] = sc.nextInt();
		}
		System.out.print("Input Array:\t");
		print(arr);
		sort(arr, n);        //sort using selection sort
		System.out.print("\nSorted Array:\t");
		print(arr);
		sc.close();
	}

	static void sort(int[] arr, int n)        //selection sort implementation
	{
		for (int i = 0; i < n-1; i++) 
		{
			int sm=i;        //assume current index has minimum
			for (int j = i+1; j<n; j++) 
			{
				if (arr[j] < arr[sm])        //find actual minimum (use > for descending)
					sm=j;
			}
			//swap minimum element with current position
			int t = arr[i];
			arr[i] = arr[sm];
			arr[sm] = t;
		}
	}	

	static void print(int[] arr)        //display array elements
	{
		for (int i = 0; i < arr.length; i++) 		
			System.out.print(arr[i] + "  ");
		
	}
	// time complexity = O(n^2)
}