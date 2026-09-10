package Act1;
import java.util.Scanner;

public class Canteen {

    public static double calculatePrice(int itemNumber, int quantity) {

        double price = 0;
        switch (itemNumber) {
            case 1:
                price = 50;
                break;
            case 2:
                price = 60;
                break;
            case 3:
                price = 40;
                break;
            case 4:
                price = 35;
                break;
            case 5:
                price = 70;
                break;
            default:
                System.out.println("Invalid item number.");
                return -1;
        }
        return price * quantity;
    }

    public static double calculateDiscount(double subtotal) {
        if (subtotal >= 500) {
            return subtotal * 0.15;
        } else {
            return subtotal * 0.10;
        }
    }

    public static void displayPrice(double totalPrice, double finalPrice, boolean isAStudent) {
        System.out.println("\n-- Price Summary --");
        System.out.printf("subTotal Price: %.2f\n", totalPrice);
        if (isAStudent) {
            System.out.printf("Final Price after discount: %.2f\n", finalPrice);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;
        double totalFinal = 0;

        System.out.println("\n-- Canteen Menu --");
        System.out.println("1. Adobo(50)");
        System.out.println("2. Menudo(60)");
        System.out.println("3. Sinigang(40)");
        System.out.println("4. Sisig(35)");
        System.out.println("5. Bistek(70)\n");

        String orderAgain = "Y";
        while (orderAgain.equalsIgnoreCase("Y")) {
 
            System.out.println();
            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();
            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
 
            if (itemNumber < 1 || itemNumber > 5 || quantity <= 0) {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
            } else {
                double subtotal = calculatePrice(itemNumber, quantity);
 
                System.out.print("Are you a student? (Y/N): ");
                String studentResponse = input.next();
                boolean isAStudent = studentResponse.equalsIgnoreCase("Y");
 
                double discount = 0;
                double orderTotal = subtotal;
 
                if (isAStudent) {
                    discount = calculateDiscount(subtotal);
                    orderTotal = subtotal - discount;
                }
 
                System.out.println();
                System.out.printf("Subtotal: %.2f\n", subtotal);
                System.out.printf("Discount: %.2f\n", discount);
                System.out.printf("Order total: %.2f\n", orderTotal);
 
                totalItems += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discount;
                totalFinal += orderTotal;
            }
 
            System.out.println();
            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = input.next();
        }
 
        System.out.println();
        System.out.println("-- ORDER SUMMARY --");
        System.out.printf("Total items: %d\n", totalItems);
        System.out.printf("Total before discount: %.2f\n", totalBeforeDiscount);
        System.out.printf("Total discount: %.2f\n", totalDiscount);
        System.out.printf("Final amount: %.2f\n", totalFinal);
        System.out.println("Thank you for ordering!");
 
        input.close();
    }
}
