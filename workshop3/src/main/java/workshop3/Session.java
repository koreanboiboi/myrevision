package workshop3;

import java.io.Console;
import java.util.List;


public class Session {

    private Repository repository;
    private Cart currCart;

    public Session(Repository repo) {
        this.repository = repo;
    }

    public void start(){
        Console cons = System.console();
        boolean stop = false;
        currCart = new Cart("anonymous");

        while(!stop){
            String input = cons.readLine("> ");
            String[] terms = input.split(" ");

                switch(terms[0]) {
                    case "cart":
                    System.out.println("List of shopping carts");
                    System.out.println(repository.getShoppingCarts());
                    break;

                    case "list":
                    System.out.printf("Items in %s's shopping cart",currCart.getUsername());
                    printList(currCart.getContents());
                    break;

                    case "add":
                    int before = currCart.getContents().size();
                    for(int i=1; i< terms.length;i++){
                        currCart.add(terms[i]);
                    }
                    int addedCount = currCart.getContents().size() - before;
                    System.out.printf("Added %d item(s) to %s's cart\n", addedCount,currCart.getUsername());
                    break;

                    case "delete":
                    int idx = Integer.parseInt(terms[1]);
                    String item = currCart.delete(idx - 1);
                    System.out.printf("Removed %s from %s's cart", item, currCart.getUsername());
                    break;

                    case "load":
                    currCart = repository.load(currCart.getUsername());
                    System.out.printf("Loaded %s shopping cart. There are %s item(s)\n", currCart.getUsername(),currCart.getContents().size());
                    break;

                    case "save":
                    repository.save(currCart);
                    System.out.println("Saved!");
                    break;

                    case "login":
                    currCart = new Cart(terms[1]);
                    System.out.printf("%s login OK",terms[1]);
                    break;

                    case "users":
                    List<String> allCarts = repository.getShoppingCarts();
                    this.printList(allCarts);
                    break;

                    case "end":
                    stop = true;
                    break;

                    default:
                    System.err.printf("Unknown input : %s\n", terms[0]);



                }System.out.println("");
        } System.out.println("Thank you for shopping with us");
    }

    private void printList(List<String> list) {
        if(list.size() <= 0){
            System.out.println("No record found!");
            return;
        }
        for(int i = 0; i<list.size();i++){
            System.out.printf("%d. %s\n", (i+1),list.get(i));
        }
    }
    
}
