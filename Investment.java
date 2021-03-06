import java.util.Date;
import java.util.Calendar;
import java.util.*;

/**
 * An Account class for Investment account
 * 
 * @author Aldwin Hermanudin 
 * @version 13.5.2016
 */

public final class Investment extends Savings
{
    // instance variables - replace the example below with your own
    private Date startDate;
    private Date endDate;
    private int term;
    private double interestRate;
    /**
     * Constructor for objects of class Investment
     */
    public Investment(Customer savings_customer, double amount, int term_in_month)
    {
        super(savings_customer, amount);
        if (term_in_month < 6){
            term = 6;
        }
        else {
            term = term_in_month;
        }
        
        Calendar s = new GregorianCalendar();
        startDate = s.getTime();
        s.add(Calendar.MONTH, term);
        endDate = s.getTime();
        
        if (term <= 6) {
            interestRate = 0.05;
        }
        
        else if (term > 6 && term <= 12){
            interestRate = 0.06;
        }
        else {
            interestRate = 0.07;
        }
    }
    
    @Override
     public void withdraw(double amount) throws AmountOverDrawnException{
    
        double balance_temp = balance;
        double withdraw_result = balance_temp-amount;
        Calendar s = new GregorianCalendar();
        
        if(withdraw_result >=0 && s.getInstance().after(endDate)){
            balance = withdraw_result;
        }
        else if (s.getInstance().before(endDate)){
            double penalty_amount = balance * 0.2;
            double temp_penalty_balance = balance - penalty_amount;
            temp_penalty_balance -= amount;
            if (temp_penalty_balance >= 0){
                balance = temp_penalty_balance;
            }
            else {
                throw new AmountOverDrawnException(this);
            }
        }
        else{
            throw new AmountOverDrawnException(this);
        }
    }

    
    public void addDailyInterest(int days){
        
        double r = interestRate;
        double f = balance * Math.pow(1 + (r / 365), days);
        interestEarned = f - balance;
        balance = f;
    }
}
