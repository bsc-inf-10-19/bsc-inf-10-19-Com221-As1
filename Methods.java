import java.util.*;
class Methods {
   public static Scanner input = new Scanner(System.in);
   public static void AccountMethods(Loan Student) {
    System.out.println();
    System.out.printf("  Welcome %s (%s, %s) to the loan menu" + 
                    "\n_______________________________________________________________________",
                    Student.getName(), Student.getAccountNumber(), Student.getProgramEnrolled());
    
                    LoanMenu(Student); 
   }             
   
   public static void LoanMenu(Loan Student){
      System.out.println("\n   LOAN MENU " + 
                       "\n-----------------");
System.out.println( 
       "1. Apply For Loan " +
       "\n2. Pay Back Loan " +
       "\n3. Available Loans " +
       "\n4. Logout");
System.out.print("Enter your option:: ");
int option = input.nextInt();
switch (option) {
   case 1: ApplyLoan(Student);
       break;

   case 2: PayBackLoan(Student);
       break;
   case 3: Student.getAllLoans();
           System.out.println();
           break;
   case 4: System.out.println(Student.getName() +  "\n<<<<<<<<<<<Logging out>>>>>>>>>>>...");
           LoanSystem.main(null);
   default: System.out.println("::::iNVALID OPTION::::");
   
}
LoanMenu(Student);
   }
   public static void ApplyLoan(Loan Student) {
      System.out.println();
      
      boolean isUndergraduate = (Student instanceof Undergraduate);
      System.out.println(":::SELECT LOAN TYPE::: " +
                      "\n---------------------------------" +
                      "\n1. Tuition Loan" +
                      "\n2. Subsistence Loan" +
                      
                      "\n3. " + (isUndergraduate ?   "Stationary" : "Research Grant") + 
                      "\n00. Loan Menu"); 
      System.out.print("Select Option:: ");
      int key = input.nextInt();

      switch (key) {
          case 1: System.out.print("Enter Tuition Loan Amount(MWK): ");
                  Student.applyForTuitionLoan(input.nextDouble());
              break;
          case 2: System.out.print("Enter Subsistence Loan Amount(MWK): ");
                  Student.applyForSubsistenceLoan(input.nextDouble());
                  break;
          case 3: 
              
              if(isUndergraduate){
                  System.out.print("Enter stationary Loan Amount(MWK): ");
                  ((Undergraduate)Student).applyForStationaryAllowance(input.nextDouble());   
              }
              
              else{ 
                  System.out.print("Enter research grant amount(MWK): ");
                  ((Postgraduate)Student).ApplyForResearchGrant(input.nextDouble());
              }
              break;
          case 00: LoanMenu(Student);

          default: System.out.println("!!!!invalid try again...");
              break;
      }
      LoanMenu(Student);
}
public static void PayBackLoan(Loan Student) {
   System.out.println();
   
   boolean isUndergraduate = (Student instanceof Undergraduate);
   System.out.println("LOAN REPAYMENT:: SELECT LOAN TYPE" +
                   "\n--------------------------------------" +
                   "\n1. Tuition" +
                   "\n2. Subsistence" +
    (isUndergraduate ? "\n3. Stationary" : "") + 
                   "\n00. Loan menu"); 
   System.out.print("Select  option::: ");
   int option = input.nextInt();

   switch (option) {
       case 1: System.out.print("Enter Tuition loan repayment amount(MWK): ");
               Student.repayTuitionLoan(input.nextDouble());
           break;
       case 2: System.out.print("Enter subsistence amount(MWK): ");
               Student.repaySubsistenceLoan(input.nextDouble());;
               break;
       case 3: 
           
           if(isUndergraduate){
               System.out.print("Enter stationary repayment amount(MWK): ");
               ((Undergraduate)Student).repayStationaryAllowance(input.nextDouble());;   
           }
           
           else{ 
               System.out.println("!!!!invalid Selection try again...");
           }
           break;
       case 00: LoanMenu(Student);

       default: System.out.println("!!!!invalid Selection try again...");
           break;
   }
   LoanMenu(Student);
}

 }

