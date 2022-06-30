package workshop2.app;

public class FixedDeposit extends BankAccount {

    private float interest = .05f;
    private int duration = 1;
    
    public FixedDeposit(String name, float initialBal) {
        // call the parent's class default constructor
        super(name, initialBal);
    }
    public FixedDeposit(String name, float initialBal, float interest) {
        super(name, initialBal); // ..
        this.interest = interest;
    }
    public FixedDeposit(String name, float initialBal, float interest, int duration) {
        this(name, initialBal, initialBal); // .
        this.duration = duration;
    }

    @Override
    public float getBalance() {
        
        return super.getBalance()*interest*duration;
    }
    

    
    
}
