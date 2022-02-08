import java.util.ArrayList;

import java.util.Scanner;
public class LoanSystem {
   static Scanner input = new Scanner(System.in);
    
    public static void main(String [] args) {
        System.out.println(" ");
        System.out.println("\t------LOAN MANAGEMENT SYSTEM" +
            "\n_______________");
            home();
    }
    public static void home(){
        System.out.println("" + 
        "\n1. Create account" +
        "\n2. Account Login" +
        "\n3. List All Loan Accounts" +
        "\n4. About" +
        "\n5. Exit");
        System.out.print("\nEnter your option ");
        int choice = input.nextInt();
        switch(choice){
            case 1: createAccount();break;
            case 2: accountLogin() ; break;
            case 3: ListAllAccounts(); break;
            
            case 4: exit();
            default: System.out.println("invalid" +
                            " Try again: \n");
                    home(); 
        }
        
        main(null);
}

 
 public static void ListAllAccounts() {
    System.out.println();
    if(Loan.loanAccount.isEmpty()){
        System.out.println("No Account  ");
        
    }
    else{
        System.out.println("AccountNumber \t Loan Amount" + 
                        "\n-------------------------------------");
        for(int i =0; i<Loan.loanAccount.size(); i++){
            System.out.printf("%6s \t\t %12.2f", Loan.loanAccount.get(i).getAccountNumber(),
                                Loan.loanAccount.get(i).getTotalLoans() );
            System.out.println();
        }
    }
    System.out.println("\n---------------------------------------------------");
}
//Account creation method
public static void createAccount() {
    System.out.println();
    System.out.println("\t...Create An Account..." +
                "\n---------------------------------------");
    System.out.println(" 1. Undergraduate Account" +
                        "\n2. PostGraduate Account" +
                        "\n3. Main menu" + 
                        "\n4. Exit");
    System.out.print("Enter option: ");
    int choice = input.nextInt();
    if(choice ==1 ||choice ==2){
        System.out.println();
        System.out.print("Enter first name :::: ");
        String name = input.next();
        System.out.print("Enter last name  :::: ");
        name = name +" " + input.next();
        System.out.print("Enter Program  :::: ");
        String programEnrolled = input.next();
        System.out.print("Enter Current Year :::: ");
        int Currentyear = input.nextInt();
        // Creating Undergraduate account
        if(choice ==1){
            
            if(Currentyear < 1 || Currentyear > 4){
                System.out.println("\n!!!!___Invalid year  :( ");
                createAccount();
            }
            
            else{
                Loan.loanAccount.add(new Undergraduate(name, programEnrolled, Currentyear));
                System.out.println("\n__________!!Account Created Succesfully!!__________" + 
                    
                    "\n----Your Account Number is: " + Loan.loanAccount.get( Loan.loanAccount.size() -1 ).getAccountNumber());
                System.out.println("---log into your account on the main menu---");
                System.out.println("---------------------------------------");
                return;

            }
        }
        
        else {
             //checks if he has entered a valid current year
             if(Currentyear < 1 || Currentyear > 3){
                System.out.println("\n Invalid year  :( \n");
                createAccount();
            }
            
            else{
                Loan.loanAccount.add(new Postgraduate(name, programEnrolled, Currentyear));
                System.out.println("\n__________!!Account Created!!__________" + 
                    "\n---Your Account Number is: " + Loan.loanAccount.get( Loan.loanAccount.size() -1 ).getAccountNumber());
                    System.out.println("--- log into your account on the menu---");
                    System.out.println("----------------------------------------------------------");
                return;

            }
        }

    }
    
    if(choice == 3) {
        main(null);
        return;
    }
    //
    else if(choice == 4)exit();
    // Allows user to retry creating an account after a wrong input
    else {
        System.out.println("___INVALID CHOICE___:(  " +
                            "Try again \n");
        createAccount();
    }
}
// Student log in menu...   
public static void accountLogin(){
    System.out.println("\tLogin" +
                "\n-----------------------");
    System.out.print("Enter your Account number : ");
    //covert user account number code to uppercase
    String accountNum = input.next().toUpperCase();
    if(accountNum.length() != 5){
        System.out.println("\n!!!You have entered an invalid length of account number" +
                    "\nFormat:: YYXXX, where Y is a letter and X is a digit." );
        System.out.print("1. Try again" +  
                        "\n2. Main menu " + 
                        "\nEnter your option: " );
        
        if(input.nextInt() ==1)
            accountLogin();
        else main(null);
    }
    
    else{
        boolean isAccountPresent = false;
        int accountIndex = -1;
        
        for(int i=0; i<Loan.loanAccount.size() ; i++){
            
            if(accountNum.equals(Loan.loanAccount.get(i).getAccountNumber())){
                isAccountPresent = true;
                accountIndex = i;
                break;
            }
        }
        
        if(isAccountPresent){
            
            Methods.AccountMethods(Loan.loanAccount.get(accountIndex));
            main(null);
        }
        
        else{
            System.out.println(" Account number " + accountNum + " does not exits" +
                        "\n------------------------------------------------------------------");
            main(null); 
        }
    }
    
}

public static void exit() {
    System.out.println("\n\t::::Thanks For Choosing Loan Management System :) "+
                "\n--------------------------------------------------");
    System.exit(0);
}
 }

