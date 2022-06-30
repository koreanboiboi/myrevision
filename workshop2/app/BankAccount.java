package workshop2.app;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BankAccount {

    private String name="";
    private String id = UUID.randomUUID().toString().substring(0, 8);
    private float balance = 0;
    private List<String> transaction = new LinkedList<>();


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public List<String> getTransaction() {
        return transaction;
    }
    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }
    
    public BankAccount(String name) {
        this.name = name;
    }
    public BankAccount(String name, float initialBal) {
        this.name = name;
        this.balance = initialBal;
    }
    
}
