/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package account;

/**
 *
 * @author Sivagama
 */
public class Account {

    
        private double balance;
        private double interestRate=0.23;
        private String user;
 
     /**constructor that takes the initial balance
      * @param initialBalance 
	  * @param givenUser
      */
        public Account(double initialBalance,String givenUser)
        {
            if (initialBalance >= 50){
				balance=initialBalance;
				user=givenUser;
				System.out.println("Account Created");
			}else{
				throw new IllegalArgumentException("Initial balance must be greater than 50"); // throwing an exception because as this is a creator, and we cannot simply return null.
			}
            //Note that the initial balance must be greater than 50.       
        }

		public void applyInterest(int months){
			for (int i = 0; i < months; i++){
				applyInterest();
			}
		}
		
		public void applyInterest(){
			credit(percentToDecimal(getInterestRate()) * getBalance());
		}
		
		private double percentToDecimal(double percent){
			return percent / 100; // just so that if something changes with percent we can use it in one spot.
		}
		
     /**The method for depositing amount and 
      * updating balance
	  * 
	  * @param amount
	  */
        public void credit(double amount)
        {
            balance=getBalance()+amount;
        }

     /**The method for debit(withdrawing amount) and 
      * updating balance */
        public void debit(double amount)
        {
            balance=getBalance()-amount;

        }
        
     /**The getter for the balance
     * @return the balance
     */
        public double getBalance() 
        {
        return balance;
        }

    /**The getter for InterestRate
     * @return the interestRate
     */
        public double getInterestRate() 
        {
            return interestRate;
        }

    /**user is the read only field
     * @return the user
     */
    public String getUser() {
        return user;
    }
    
    
}//class end
