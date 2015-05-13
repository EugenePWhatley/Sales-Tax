package SalesTax;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Eugene on 5/11/2015.
 */
public class SalesTax {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the name of the file: ");
        ArrayList<Basket> basket = readFile(input.next());
        calcTotal(basket);
    }

    private static ArrayList<Basket> readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        ArrayList<Basket> basket = new ArrayList<>();
        System.out.println("\nInput:");
        while(reader.hasNext()) {
            int quantity = reader.nextInt();
            String product = "";
            while (reader.hasNext() && !reader.hasNextDouble() && !reader.hasNext("at")) {
                product += reader.next() + " ";
            }
            reader.next();
            double price = 0.0;
            if (reader.hasNextDouble()) {
                price = reader.nextDouble();
            }
            System.out.println(quantity + " " + product + " at " + price);
            basket.add(new Basket(quantity, product, price));
        }
        return basket;
    }
    private static void calcTotal(ArrayList<Basket> basket) {
        double tax = 0.0;
        double total = 0.0;
        System.out.println("\nOutput:");
        for(Basket b : basket) {
            b.printDetails();
            tax+=b.getType().getTax();
            total+=b.getPrice();
        }
        System.out.printf("Sales Taxes: %.2f\nTotal: %.2f", tax, total);
    }
}
