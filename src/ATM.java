import java.util.HashMap;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args){
        HashMap<String, Double> accs = new HashMap();


        System.out.println("Welcome to TIY Bank - Please input name on account to continue.");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while (true) {
            do {
                if (!accs.containsKey(name)) {
                    System.out.println("An account for " + name + " not found.  Would you like to add one");
                    System.out.println("and receive a $20 sign on bonus for this account?");
                    String s = scanner.nextLine();
                    if (s.equals("Yes")) {
                        accs.put(name, 20.0);
                    } else {
                        if (s.equals("No")) {
                            System.out.println("Must add account to continue.");
                        }
                    }
                }
            } while (!accs.containsKey(name));

            while (accs.containsKey(name)) {

                System.out.println("Welcome " + name + ", what may we help you with today?");
                System.out.println("Please make a selection below by either utilizing the number or name.");
                System.out.println("[1] Check Balance [2] Withdrawal Funds [3] Account Options [4] Cancel");

                double bal = accs.get(name);
                String request = scanner.nextLine();
                if (request.equals("Check Balance") || request.equals("1")) {
                        System.out.println("Your balance is at $" + bal + " " + name + " - better hustle.");
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
                    System.out.println("[1] Add New Account [3] Remove Account");
                    String acOp = scanner.nextLine();
                    if (acOp.equals("1") || acOp.equals("Add New Account")) {
                        System.out.println("What would you like to call this account?");
                        String accName = scanner.nextLine();
                        accs.put(accName, 0.0);
                        System.out.println("How much would you like to deposit?");
                        System.out.println("Please format with one decimal place.");
                        System.out.println("Example: 1.0, 20.0, 300.0");
                        double dep = scanner.nextDouble();
                        accs.put(name, dep);
                        //} else if (acOp.equals("Edit Account") || acOp.equals("2")) {
                        //        System.out.println("What would you like to do with your account?");
                        //        System.out.println("[1] Delete Account");
                        //        String delAc = scanner.nextLine();
                        //        if (delAc.equals("Delete Account") || delAc.equals("1")) {
                        //            System.out.println("Are you sure you wish to delete this account? Y/N");
                        //           do {
                        //                scanner.nextLine();
                        //                if (delAc.equals("Y")) {
                        //                    accs.remove(name);
                        //               } else if (delAc.equals("N")) {
                        //                    System.out.println("Just testing the system I guess?");
                        //                }
                        //                if (!delAc.equals("Y") || !delAc.equals("N")) {
                        //                    System.out.println("Invalid Input - Try Again.");
                        //                }
                        //            } while (delAc.equals("Y") || delAc.equals("N"));
                        //            scanner.nextLine();
                        //        }
                    } else if (acOp.equals("3") || acOp.equals("Remove Account")) {
                        do {
                            System.out.println("What's the name of the account you'd like to remove?");
                            String remAc = scanner.nextLine();
                            if (accs.containsKey(remAc)) {
                                accs.remove(remAc);
                                System.out.println("Account for " + remAc + " has been removed.");
                            } else if (!accs.containsKey(remAc)) {
                                System.out.println("Account not found.  Try again.");
                            }
                        } while (accs.containsKey(name));
                    }
                }
                else if (request.equals("Cancel") || request.equals("4")) {
                    System.out.println("Terminating Connection.");
                    System.out.println("Have a great day!");
                    System.exit(0);
                }
            }
        }
    }
}