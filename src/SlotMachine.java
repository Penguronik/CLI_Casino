import java.util.Random;
import java.util.Scanner;

public class SlotMachine {

    String[] results = new String[3];

    public SlotMachine() {
        String[] symbols = {"7", "诺姆", "♠", "$", "£", "♣", "♦", "❤", "€"};

        this.results[0] = symbols[(int) (Math.random()*(9))];
        this.results[1] = symbols[(int) (Math.random()*(9))];
        this.results[2] = symbols[(int) (Math.random()*(9))];
    }

    public String[] getResults() {
        return this.results;
    }

    public boolean winCheck() {
        return this.results[0].equals(this.results[1]) && this.results[0].equals(this.results[2]);
    }

    public boolean hanjiCheck() {
        return this.results[0].equals("诺姆") && this.results[1].equals("诺姆") && this.results[3].equals("诺姆");
    }

    public static void playSlots() {

        User user = new User(1000000);

        Scanner sc = new Scanner(System.in);

        String betStr;
        double bet = 0;
        boolean invalidBet;

        betStr = sc.nextLine();

        // getting the users bet
        do {
            try {
                bet = Double.parseDouble(betStr);
                invalidBet = bet < 0 || bet > user.getBalance();
            } catch (NumberFormatException e) {
                invalidBet = true;
            }
        } while (invalidBet);

        System.out.println("You bet " + bet + "$");

        // setting the payout multiplier
        int multiplier;
        if (bet < 100) {
            multiplier = 4;
            System.out.println("Win multiplier: " + multiplier);
            System.out.println();
        }
        else if (bet < 1000) {
            multiplier = 5;
            System.out.println("Win multiplier: " + multiplier);
            System.out.println();
        }
        else if (bet < 5000) {
            multiplier = 8;
            System.out.println("Win multiplier: " + multiplier);
            System.out.println();
        }
        else if (bet < 12500) {
            multiplier = 10;
            System.out.println("Win multiplier: " + multiplier);
            System.out.println();
        }
        else {
            multiplier = 12;
            System.out.println("Win multiplier: " + multiplier);
            System.out.println();
        }

        // initialize the SlotMachine
        SlotMachine sm  = new SlotMachine();

        // print the machine
        for (int i = 0; i < sm.getResults().length; i++) {
            System.out.print(sm.getResults()[i] + " ");
        }

        System.out.println();

        // add winnings or subtract loss and tell the player if they won
        if (sm.winCheck()) {
            System.out.println("You win!");
            System.out.println("You won " + bet * multiplier + "$");
            System.out.println();
            user.setBalance(user.getBalance() + (bet*multiplier));
        }
        else {
            System.out.println("You lose!");
            System.out.println("You lost " + bet + "$");
            System.out.println();
            user.setBalance(user.getBalance() - bet);
        }

        if (sm.hanjiCheck()) {
            System.out.println("Ching cheng hanji");
        }
    }
}
