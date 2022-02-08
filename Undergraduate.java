 class Undergraduate extends Loan {
    private double StationaryLoan;
    private double StationaryLoanInterest;
    private final double StationaryLoanInterestRate = 0.15;

    public Undergraduate(String Name,String ProgramEnrolled, int CurrentYear){
        super(Name,ProgramEnrolled,CurrentYear,0.11,4,"UG");
     
    }
    public void applyForStationaryAllowance(double amount){
        double AmountToBePaid = AnnualCompoundInterest(amount, this.StationaryLoanInterestRate);
        this.StationaryLoan += AmountToBePaid;
        this.StationaryLoanInterest = AmountToBePaid - amount;
        System.out.println("---Stationary Loan  granted---");
    }
    public void repayStationaryAllowance(double amount){
        
        if(this.StationaryLoan <= 0){
            System.out.printf("You don't have any stationary loan right now..." + 
                            "\nMWK%.2f returned \n", amount );
            return;
        }
        double Extra = 0 ; 
        if(this.StationaryLoan - amount <= 0){
            System.out.println("You've repaid your stationary loan Allowance.");
            
             
            if(this.StationaryLoan - amount < 0.00) {
                Extra = amount - this.StationaryLoan;
                System.out.printf("The extra money: MWK%.2f returned \n", Extra );
            }
            this.StationaryLoan = 0 ;
            this.StationaryLoanInterest = 0 ; 
        }
         
        else{ 
            System.out.printf("You've paid MWK%.2f to your stationary loan Allowance\n", amount);
            this.StationaryLoan -= amount;
        }
    }
    public double getStationaryAllowance(){
        return this.StationaryLoan;
    }

    @Override
    public void getAllLoans() {
   
        //when the user has no loans
        if(super.getTuitionLoan() == 0 && super.getSubsistenceLoan() == 0 && this.StationaryLoan == 0 ){
            System.out.println("\nYou don't have any LoanS ");
            return;
        }
        super.getAllLoans();
        System.out.printf("\nStationary  \t\t %12.2f \t\t %9.2f \n", this.StationaryLoan, this.StationaryLoanInterest);
    }
@Override
public double getTotalLoans() {
    return super.getTotalLoans() + this.StationaryLoan;
}
  }
