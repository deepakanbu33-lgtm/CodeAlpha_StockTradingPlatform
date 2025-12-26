import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class User {
    double balance = 10000;
    HashMap<String, Integer> portfolio = new HashMap<>();
}

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();

        Stock apple = new Stock("APPLE", 150);
        Stock google = new Stock("GOOGLE", 200);

        while (true) {
            System.out.println("\n1. Buy Stock\n2. Sell Stock\n3. View Portfolio\n4. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter stock name (APPLE/GOOGLE): ");
                String name = sc.next();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();

                double cost = (name.equals("APPLE") ? apple.price : google.price) * qty;
                if (user.balance >= cost) {
                    user.balance -= cost;
                    user.portfolio.put(name, user.portfolio.getOrDefault(name, 0) + qty);
                    System.out.println("Stock bought successfully!");
                } else {
                    System.out.println("Insufficient balance!");
                }

            } else if (choice == 2) {
                System.out.print("Enter stock name: ");
                String name = sc.next();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();

                if (user.portfolio.getOrDefault(name, 0) >= qty) {
                    user.portfolio.put(name, user.portfolio.get(name) - qty);
                    user.balance += qty * 100;
                    System.out.println("Stock sold successfully!");
                } else {
                    System.out.println("Not enough stock!");
                }

            } else if (choice == 3) {
                System.out.println("Balance: " + user.balance);
                System.out.println("Portfolio: " + user.portfolio);

            } else {
                break;
            }
        }
        sc.close();
    }
}