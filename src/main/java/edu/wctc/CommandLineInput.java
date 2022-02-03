package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLineInput implements SalesInput{
    @Override
    public List<Sale> getSales() {
        List<Sale> salesList = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);

        String response = "y";

        while(response.equalsIgnoreCase("y")){
            //prompt for customer
            System.out.println("Enter Customer: ");
            String customer = keyboard.nextLine();

            //prompt for country
            System.out.println("Enter Country: ");
            String country = keyboard.nextLine();

            //prompt for amount
            System.out.println("Enter Amount: ");
            double amount = Double.parseDouble(keyboard.nextLine());

            //prompt for tax
            System.out.println("Enter Tax: ");
            double tax = Double.parseDouble(keyboard.nextLine());

            //create sale
            Sale sale = new Sale();
            sale.setCustomer(customer);
            sale.setCountry(country);
            sale.setAmount(amount);
            sale.setTax(tax);

            //add to list
            salesList.add(sale);

            //ask if there are more sales
            System.out.println("More sales? (y/n): ");
            response = keyboard.nextLine();
        }


        return salesList;
    }
}
