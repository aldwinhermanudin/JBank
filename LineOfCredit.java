import java.util.*;

/**
 * Write a description of class LineOfCredit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineOfCredit extends Checking
{
    // instance variables - replace the example below with your own
    private double creditBalance;
    private double creditLimit;

    /**
     * Constructor for objects of class LineOfCredit
     */
    public LineOfCredit(Customer savings_customer, double credit_limit, double amount)
    {
        super(savings_customer, amount); // initialise instance variables
        creditBalance = amount;
        creditLimit = credit_limit;
    }

    public double getCreditBalance(){
        return creditBalance;
    }
    
    public double getCreditLimit(){
        return creditLimit;
    }
    
    public void setCreditBalance(double credit_balance){
        
        creditBalance = credit_balance;
    }
    
    public void setCreditLimit(double credit_limit){
        
        creditLimit = credit_limit;
    }
    
    protected void feeAssesment(){
        int days = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double deficit = creditLimit - creditBalance;
        double amt = deficit * Math.pow((1 + 0.21)/365,(365 * days));
        monthlyFee = amt - deficit;
        
    }
    
    public boolean withdraw(double amount) throws AmountOverDrawnException{
        if (amount > balance + creditBalance){
            throw new AmountOverDrawnException(this);
        }
        
        else if ( amount > balance ){
            balance = 0;
            creditBalance -= (amount - balance);
            return true;
        }
        
        else {
            balance = balance - amount;
            return true;
        }
    }
}
