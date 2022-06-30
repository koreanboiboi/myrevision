package workshop2.app;

import java.io.Console;

public class Main {

    public static void main(String[] args) {

        
        Console cons = System.console();
        System.out.println("Welcome to Bank System");
        System.out.println("-----------------------------");

        boolean stop = false;
        boolean start = true;

        while (start) {
            System.out.println("Select your account\n1.Savings Account\n2.Fixed Deposit Account");
            String choice = cons.readLine("> ");

            switch (choice) {
                case "1":
                    // BankAccount
                    System.out.println("This is a savings acct");
                    BankAccount acct = new BankAccount("Fred");
                    while (!stop) {
                        System.out.println("*Select option*\n1.Deposit\n2.Withdraw\n3.Check Account INFO");
                        System.out.println("Press anything else to exit\n");
                        String input = cons.readLine("> ");

                        switch (input) {
                            case "1":
                                Float deposit = Float.parseFloat(cons.readLine("Please enter the amount to deposit:\n"));
                                acct.setBalance(acct.getBalance() + deposit);
                                System.out.printf("$%.2f deposited into account\n\n", deposit);
                                break;

                            case "2":
                                Float withdraw = Float.parseFloat(cons.readLine("Please enter the amount to withdraw:\n"));
                                if (withdraw <= acct.getBalance()) {
                                    acct.setBalance(acct.getBalance() - withdraw);
                                    System.out.printf("$%.2f withdrawn from account\n\n", withdraw);
                                } else {
                                    System.out.println("You do not have sufficient fund to withdraw\n");
                                }
                                break;

                            case "3":
                                System.out.printf("Name:%s\nAccount Number:%s\nBalance:$%f\n\n", acct.getName(),
                                        acct.getId(), acct.getBalance());
                                break;
                            default:
                                stop = true;
                        }
                    }
                    break;
                case "2":
                    // FixedDeposit
                    FixedDeposit fDeposit = new FixedDeposit("Fred", 0f);
                    System.out.println("This is a fixed deposit acct");
                        while(!stop){
                            Float fd = Float.parseFloat(cons.readLine("Please enter the amount to deposit:\n"));
                            if(fd>=10000){
                            fDeposit.setBalance(fDeposit.getBalance()+fd);
                            System.out.printf("Fixed deposit amount of $%.2f has been placed\n",fd);
                            System.out.printf("The maturity amount is $%.2f\n\n",fd+fDeposit.getBalance());
                            stop = true;
                            } else {
                                System.out.println("The minimum amount required is $10,000\n");
                            }
                    }
                        
                    
                    break;
                default:
                start = false;
            }

        }

        System.out.println("Thank you for banking with us!");

    }

}
