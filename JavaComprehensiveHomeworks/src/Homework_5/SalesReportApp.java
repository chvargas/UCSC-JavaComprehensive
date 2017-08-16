package Homework_5;
import java.text.NumberFormat;

public class SalesReportApp
{	
	public static void main(String[] args)
	{
    // Sales information stored in a rectangular array
    double[][] sales = { {1540, 2010, 2450, 1845},
                         {1130, 1168, 1847, 1491},
                         {1580, 2305, 2710, 1284},
                         {1105, 4102, 2391, 1576} };

    // get the currency format object
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    // display a welcome message
    System.out.println("------ Welcome to the Sales Report Application. ------\n");

    // 1st printing sales tabulated
    System.out.println("Region\t\t  Q1  \t\t\t  Q2  \t\t\t  Q3  \t\t\t  Q4  \n"); // Printing header	
    
    for (int quarter = 0; quarter < sales.length; quarter++) // loop by row (region) length
    {
        System.out.print(quarter + 1); // row headers (Region)
        
        for (int region = 0; region < sales[quarter].length; region++) // loop by column (quarter) length
        {
            System.out.print("\t\t" + currency.format(sales[quarter][region]));
        }
        
        System.out.println(); // printing blank line
    }

    // 2nd Sales by region section:
    
    System.out.println("\nSales by region:\n"); // Printing header	
    
    for (int region = 0; region < sales.length; region++) // loop by row (region) length
    {
        double salesByRegion = 0; // initialization
        
        System.out.print("Region " + (region + 1) + ": "); // printing region headers 
        
        for (int quarter = 0; quarter < sales[region].length; quarter++) // looping by column (quarter) length
        {
            salesByRegion += sales[region][quarter]; // adding sales into SalesByRegion by region
        }
        
        System.out.println(currency.format(salesByRegion)); // printing formated sales by region 
    }

    // 3rd sales by quarter
    
    System.out.println("\nSales by quarter: \n"); // // Printing header	
    
    for (int region=0; region < sales.length; region++) // looping by row (region) length
    {
        double salesByQuarter = 0; // initialization
        
        System.out.print("Quarter " + (region + 1) + ": ");
        
        for (int quarter = 0; quarter < sales[region].length; quarter++) // looping by column (quarter) length
        {
            salesByQuarter += sales[quarter][region]; // adding sales into salesByQuarter (assuming length of rows and columns are same) 
        }
        
        System.out.println(currency.format(salesByQuarter)); // prints sales by quarter
    }

    // 4th Total annual Sales
    
    double totalSales = 0; // initialization
    
    System.out.print("\nTotal annual sales, all regions: \n"); // Printing header
    
    for (int region = 0; region < sales.length; region++) // looping by row (region) length
    {
        for (int quarter = 0; quarter < sales[region].length; quarter++) // looping by column (quarter) length
        {
            totalSales += sales[region][quarter]; // adding sales into totalSales
        }
    }
    
    System.out.println(currency.format(totalSales)); // printing formated total sales
}
}