package workshop1.app;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<String> cart = new LinkedList<>();
        int del;
        boolean stop = false;
        Console cons = System.console();
        System.out.println("Welcome to your shopping cart!");

        while (!stop) {
            String input = cons.readLine("> ");
            String[] terms = input.split(" ");
            String cmd = terms[0];

            switch (cmd) {
                case "list":
                if(cart.size()>0) {
                    for(int i = 0; i<cart.size();i++) {
                        System.out.printf("%d. %s\n", (i+1),cart.get(i));
                    }
                } else {
                    System.out.println("Your cart is empty!");
                }
                break;
                case "add":
                    for(int i=1; i<terms.length; i++) {
                        boolean found = false;
                        for (int j = 0; j<cart.size();j++){
                            if(terms[i].equals(cart.get(j))) {
                                found = true;
                                break;
                            }
                        }
                        if(!found) {
                            cart.add(terms[i]);
                            System.out.printf("Added %s to cart\n",terms[i]);
                        }
                    }
                    break;
                case "del":
                    if(terms.length <2 ) {
                        System.err.println("Please provide an index to delete!");
                    } else {
                        del = Integer.parseInt(terms[1]) -1;
                        if(del < cart.size()){
                            System.out.printf("Deleted %s from cart\n",cart.get(del));
                            cart.remove(del);
                        } else {
                            System.err.println("No such item");
                        }
                    }break;
                case "end":
                stop = true;
                break;

                default:
            } 

        }

        System.out.println("Thank you for shopping!");

    }

}