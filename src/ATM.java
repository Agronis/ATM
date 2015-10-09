import java.util.HashMap;
import java.util.Scanner;

public class ATM {

    public static void run() throws Exception {
        HashMap<String, Double> accs = new HashMap();


        System.out.println("Welcome to TIY Bank - Please input name on account to continue.");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (!accs.containsKey(name)) {
            System.out.println("An account for " + name + " not found.  Would you like to add one");
            System.out.println("and receive a $20 sign on bonus for this account?");
            String s = scanner.nextLine();
            if (s.equals("Yes")) {
                accs.put(name, 20.0);
            } else if (s.equals("No")) {
                System.out.println("Must add account to continue.");
            }
        }

        while (true) {

            System.out.println("Welcome " + name + ", what may we help you with today?");
            System.out.println("Please make a selection below by either utilizing the number or name.");
            System.out.println("[1] Check Balance [2] Withdrawal Funds [3] Account Options [4] Cancel");

            String request = scanner.nextLine();
            double bal = accs.get(name);
            if (request.equals("Check Balance") || request.equals("1")) {
                System.out.println("Your balance is at $" + accs.get(name) + " " + name + " - better hustle.");
            } else if (request.equals("Withdrawal Funds") || request.equals("2")) {

                System.out.println("You don't have much " + name + " but how much would you like?");
                int wd = scanner.nextInt();
                if (wd <= bal) {
                    System.out.println("Request accepted - please take your money.");
                    System.out.println("Your balance is now " + (bal - wd));
                    accs.put(name, (bal - wd));
                } else {
                    System.out.println("Hold up " + name + "! You must not realize you're practically broke.");
                }

            } else if (request.equals("Account Options") || request.equals("3")) {
                System.out.println("[1] Add New Account [2] Edit Account [3] Remove Account");
                String addAcc = scanner.nextLine();
                if (addAcc.equals("1") || addAcc.equals("Add New Account")) {
                    System.out.println("What would you like to call this account?");
                    String accName = scanner.nextLine();
                    accs.put(accName, 0.0);
                    System.out.println("How much would you like to deposit?");
                    System.out.println("Please format with one decimal place.");
                    System.out.println("Example: 1.0, 20.0, 300.0");
                    double dep = scanner.nextDouble();
                    accs.put(name, dep);
                }
                    //} else if (request.equals("2") || request.equals("Edit Account")) {
                    // edit account info here
                    ///} else {
                    // if (request.equals("3") || request.equals("Remove Account")) {
                    // delete account info here
                }
                if (request.equals("Cancel") || request.equals("4")) {
                    System.out.println("Terminating Connection.");
                    System.out.println("Have a great day!");
                    System.exit(0);

                }

            }
        }
    }
}