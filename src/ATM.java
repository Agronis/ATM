import java.util.Scanner;

public class ATM {
    public static void run() throws Exception {
        System.out.println("Welcome to TIY Bank - Please input name on account to continue.");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            throw new Exception("Account not found.  Terminating connection.");
        }
        System.out.println("Welcome " + name + ", what may we help you with today?");
        System.out.println("Please make a selection below by either utilizing the number or name.");
        System.out.println("[1] Check Balance [2] Withdrawal Funds [3] Cancel");

        String request = scanner.nextLine();
        if (request.equals("Check Balance") || request.equals("1")) {
            System.out.println("Your balance is at $100 " + name + " - better hustle.");
        } else if (request.equals("Withdrawal Funds") || request.equals("2")) {

            System.out.println("You don't have much " + name + " but how much would you like?");

            int wd = scanner.nextInt();
            if (wd <= 100) {
                System.out.println("Request accepted - please take your money.");
                System.out.println("Your balance is now " + (100 - wd));
                System.out.println("Have a great day!");
                System.out.println("Terminating connection.");
            } else {
                System.out.println("Hold up " + name + "! You must not realize you're practically broke.");
            }

        } else if (request.equals("Cancel") || request.equals("3")) {
            System.out.println("Terminating Connection.");
            System.out.println("Have a great day!");

        }

    }
}
