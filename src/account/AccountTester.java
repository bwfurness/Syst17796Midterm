/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;
import java.util.Scanner;
/**
 *
 * @author Sivagama
 */
public class AccountTester {
    
    public static void main(String[] args) {
        /*here assumed that 500 accounts can be created
        for the given bank*/
        Account ac[]=new Account[500];
        
        System.out.println("Please enter the amount by which you want to open an account:");
        
        Scanner sc=new Scanner(System.in);
        double bal=sc.nextDouble();
        
        System.out.println("Please enter the unique user name:");
        sc.nextLine();
        String user=sc.nextLine();
        
		// it doesn't explicitly say to, but I'm going to give an error message if the arguments are illegal.
		// this will work even if the arguments being illegal change.
		try {
			Account a=new Account(bal,user);
			ac[0]=a;

			System.out.println("The balance is: "+a.getBalance());  
			System.out.println("The InterestRate per month is "+a.getInterestRate());
			a.applyInterest();
			System.out.println("The balance after applying interest is: " + a.getBalance());
			a.applyInterest(11); // apply the interest over 11 more months.
			System.out.printf("The balance after applying interest for one year is: %.2f", a.getBalance());
		} catch (IllegalArgumentException e){
			System.out.println("Unable to create account: " + e.getMessage());
		}
    }
}
