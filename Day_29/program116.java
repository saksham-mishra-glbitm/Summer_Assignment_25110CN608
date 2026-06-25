import java.util.*;

public class program116
{
    static Scanner sc = new Scanner(System.in);
    static int ids[] = new int[100];
    static String names[] = new String[100];
    static int quantities[] = new int[100];
    static double prices[] = new double[100];
    static int count = 0;
    static int nextId = 101;

    public static void main(String[] sm)
    {
        int choice;
        
        do
        {
            System.out.println("\n========== INVENTORY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Update Stock");
            System.out.println("6. Update Price");
            System.out.println("7. Delete Product");
            System.out.println("8. Display Low Stock Items (Stock < 10)");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Exit");
            System.out.println("=================================================");
            System.out.println("Enter your choice (1-10):");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice)
            {
                case 1: addProduct(); break;
                case 2: displayAllProducts(); break;
                case 3: searchById(); break;
                case 4: searchByName(); break;
                case 5: updateStock(); break;
                case 6: updatePrice(); break;
                case 7: deleteProduct(); break;
                case 8: displayLowStock(); break;
                case 9: calculateTotalValue(); break;
                case 10: System.out.println("\nExiting System... Thank you!"); break;
                default: System.out.println("\nInvalid choice!");
            }
            
        } while(choice != 10);
        
        sc.close();
    }
    
    static void addProduct()        //add new product
    {
        if(count >= 100)
        {
            System.out.println("\nStorage full! Cannot add more products.");
            return;
        }
        
        System.out.println("\n--- ADD PRODUCT ---");
        System.out.println("Product ID will be: " + nextId);
        
        System.out.println("Enter Product Name:");
        String name = sc.nextLine();
        
        System.out.println("Enter Quantity:");
        int qty = sc.nextInt();
        
        if(qty < 0)
        {
            System.out.println("Quantity cannot be negative!");
            return;
        }
        
        System.out.println("Enter Price per unit:");
        double price = sc.nextDouble();
        
        if(price < 0)
        {
            System.out.println("Price cannot be negative!");
            return;
        }
        
        ids[count] = nextId;
        names[count] = name;
        quantities[count] = qty;
        prices[count] = price;
        count++;
        
        System.out.println("\nProduct added successfully!");
        System.out.println("Product ID: " + nextId);
        nextId++;
    }
    
    static void displayAllProducts()        //display all products
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        System.out.println("\n--- ALL PRODUCTS ---");
        System.out.println("=================================================================================");
        System.out.println("ID\tName\t\t\tQuantity\tPrice\t\tTotal Value");
        System.out.println("=================================================================================");
        
        for(int i=0; i<count; i++)
        {
            double totalValue = quantities[i] * prices[i];
            System.out.println(ids[i] + "\t" + names[i] + "\t\t\t" + quantities[i] + "\t\t₹" + prices[i] + "\t\t₹" + totalValue);
        }
        System.out.println("=================================================================================");
        System.out.println("Total Products: " + count);
    }
    
    static int findById(int id)        //find product index by ID
    {
        for(int i=0; i<count; i++)
        {
            if(ids[i] == id)
                return i;
        }
        return -1;
    }
    
    static int findByName(String name)        //find product index by name
    {
        for(int i=0; i<count; i++)
        {
            if(names[i].equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }
    
    static void searchById()        //search product by ID
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        System.out.println("\nEnter Product ID:");
        int id = sc.nextInt();
        
        int index = findById(id);
        if(index == -1)
        {
            System.out.println("Product not found!");
            return;
        }
        
        displayProduct(index);
    }
    
    static void searchByName()        //search product by name
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        System.out.println("\nEnter Product Name:");
        String name = sc.nextLine();
        
        int index = findByName(name);
        if(index == -1)
        {
            System.out.println("Product not found!");
            return;
        }
        
        displayProduct(index);
    }
    
    static void displayProduct(int index)        //display single product details
    {
        double totalValue = quantities[index] * prices[index];
        System.out.println("\n--- PRODUCT DETAILS ---");
        System.out.println("Product ID: " + ids[index]);
        System.out.println("Name: " + names[index]);
        System.out.println("Quantity: " + quantities[index]);
        System.out.println("Price: ₹" + prices[index]);
        System.out.println("Total Value: ₹" + totalValue);
        
        if(quantities[index] < 10)
            System.out.println("*** LOW STOCK WARNING! ***");
    }
    
    static void updateStock()        //update product quantity
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        System.out.println("\nEnter Product ID:");
        int id = sc.nextInt();
        
        int index = findById(id);
        if(index == -1)
        {
            System.out.println("Product not found!");
            return;
        }
        
        System.out.println("\nCurrent Stock: " + quantities[index]);
        System.out.println("Enter new quantity:");
        int newQty = sc.nextInt();
        
        if(newQty < 0)
        {
            System.out.println("Quantity cannot be negative!");
            return;
        }
        
        quantities[index] = newQty;
        System.out.println("\nStock updated successfully!");
        displayProduct(index);
    }
    
    static void updatePrice()        //update product price
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        System.out.println("\nEnter Product ID:");
        int id = sc.nextInt();
        
        int index = findById(id);
        if(index == -1)
        {
            System.out.println("Product not found!");
            return;
        }
        
        System.out.println("\nCurrent Price: ₹" + prices[index]);
        System.out.println("Enter new price:");
        double newPrice = sc.nextDouble();
        
        if(newPrice < 0)
        {
            System.out.println("Price cannot be negative!");
            return;
        }
        
        prices[index] = newPrice;
        System.out.println("\nPrice updated successfully!");
        displayProduct(index);
    }
    
    static void deleteProduct()        //delete a product
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        System.out.println("\nEnter Product ID to delete:");
        int id = sc.nextInt();
        
        int index = findById(id);
        if(index == -1)
        {
            System.out.println("Product not found!");
            return;
        }
        
        System.out.println("\nProduct to delete:");
        displayProduct(index);
        
        System.out.println("\nConfirm deletion? (yes/no):");
        sc.nextLine();
        String confirm = sc.nextLine();
        
        if(confirm.equalsIgnoreCase("yes"))
        {
            for(int j=index; j<count-1; j++)
            {
                ids[j] = ids[j+1];
                names[j] = names[j+1];
                quantities[j] = quantities[j+1];
                prices[j] = prices[j+1];
            }
            count--;
            System.out.println("\nProduct deleted successfully!");
        }
        else
        {
            System.out.println("\nDeletion cancelled.");
        }
    }
    
    static void displayLowStock()        //display products with low stock
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        System.out.println("\n--- LOW STOCK PRODUCTS (Quantity < 10) ---");
        System.out.println("==================================================");
        System.out.println("ID\tName\t\t\tQuantity");
        System.out.println("==================================================");
        
        int lowStockCount = 0;
        for(int i=0; i<count; i++)
        {
            if(quantities[i] < 10)
            {
                System.out.println(ids[i] + "\t" + names[i] + "\t\t\t" + quantities[i]);
                lowStockCount++;
            }
        }
        
        if(lowStockCount == 0)
            System.out.println("No low stock products found!");
        else
            System.out.println("==================================================\nTotal Low Stock Items: " + lowStockCount);
    }
    
    static void calculateTotalValue()        //calculate total inventory value
    {
        if(count == 0)
        {
            System.out.println("\nNo products in inventory!");
            return;
        }
        
        double totalValue = 0;
        for(int i=0; i<count; i++)
            totalValue += quantities[i] * prices[i];
        
        System.out.println("\n--- INVENTORY VALUE ---");
        System.out.println("Total Products: " + count);
        System.out.println("Total Inventory Value: ₹" + totalValue);
    }
}