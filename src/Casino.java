import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        boolean invalid;
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Casino Simulator by Noam Borenstein, Roni Kant, and Tomer Lapid");
        do {
            System.out.print("Please enter the balance you'd like to start with: ");
            try {
                user.setBalance(sc.nextDouble());
                invalid = false;
            } catch (Exception e) {
                System.out.println("Invalid input");
                invalid = true;
            }
        }while(invalid);

        System.out.println("You will be starting with a balance of: " + user.getBalance() + "\n What would you like to play?");
        do {
            System.out.print("Enter 'bj' for Blackjack and 'slots' for the Slot Machine: ");
            if (sc.nextLine().equals("bj")) {
                new Blackjack(user);
                invalid = false;
            } else if (sc.nextLine().equals("slots")) {
                new SlotMachine();
                invalid = false;
            } else {
                System.out.println("Invalid input");
                invalid = true;
            }
        }while(invalid);
    }
}
