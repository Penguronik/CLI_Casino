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

    public static void main(String[] args) {
        int bet = 25;
        System.out.println("You bet " + bet + "$");

        SlotMachine sm  = new SlotMachine();

        for (int i = 0; i < sm.getResults().length; i++) {
            System.out.print(sm.getResults()[i] + " ");
        }

        System.out.println();

        if (sm.winCheck()) {
            System.out.println("You win!");
            System.out.println("You won " + bet*4 + "$");
            System.out.println();
        }
        else {
            System.out.println("You lose!");
            System.out.println("You lost " + bet + "$");
            System.out.println();
        }

        if (sm.hanjiCheck()) {
            System.out.println("Ching cheng hanji");
        }
    }
}
