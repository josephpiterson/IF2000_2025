package domain;

public class SavingAccount extends Account{
    
    //Atributes
    private String initialDate;
    private int months;
    private float interest;

    //Constructor

    public SavingAccount(String initialDate, int months, float interest) {
        this.initialDate = initialDate;
        this.months = months;
        this.interest = interest;
    }

    public SavingAccount(String initialDate, int months, float interest, String accountNumber, double balance, Person client) {
        super(accountNumber, balance, client);
        this.initialDate = initialDate;
        this.months = months;
        this.interest = interest;
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }
    
    @Override
    public void deposit(double amount) {
        super.setBalance(this.getBalance()+amount);
    }

    @Override
    public void withdraw(double amount) {
        if(amount<=this.getBalance())
            super.setBalance(this.getBalance()-amount);
        else
            System.out.println("You dont have enough money");
    }

    @Override
    public double interestcalculation() {
        
        double total;
        total = this.getMonths()
                *super.getBalance()
                *this.getInterest();
        
        return super.getBalance()+total; 
    }//endInterestCalculation

    @Override
    public String toString() {   
        String result="\nAccount Type: SAVING ACCOUNT"
                +"\n---------------------------------"
                +"\n Initial date of account: "+this.getInitialDate()
                +"\n Months of saving: "+this.getMonths()
                +"\n Interest: "+this.getInterest()
                +"\n Gained Interest: "+((this.getMonths()
                                          *super.getBalance()/100)
                                          +this.getInterest()
                                        )
                +"\n Balance after interest: "+this.getBalance()+((this.getMonths()
                                          *super.getBalance()/100)
                                          +this.getInterest()
                                        );             
        return super.toString()+result; 
    }//endOfToString()
    
    
    
}//endClass