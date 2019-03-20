public class Account{

   private double balance;

   public Account() {
     this.balance=0;
  }

  public double getBalance() {
     return balance;
  }

  public void deposit(double amount){
	    // Your code here
   balance += amount;
   System.out.println("new balance=" + balance + "$");
}

public void withdraw(double amount){
	    // Your code here
   if (amount > balance) {
      throw new NotEnoughMoneyException(amount, balance);
   }
   else {
      balance -= amount;
   }

   System.out.println("new balance=" + balance + "$");
}

////////////////////////////////////////////////////////////////////////////////////////////////////////
/*public static void accountConstructor() {
  Account a = new Account();
  //assertEquals(0, a.getBalance(), 0);

  System.out.println("0 = " + a.getBalance());

  a.deposit(15000.92);
 //assertEquals(15000.92, a.getBalance(), 0);

  System.out.println("15000.92 = " + a.getBalance());
}


public static void accountWithdrawException() {
  Account a = new Account();
  a.deposit(500);
  a.withdraw(300);
  //assertEquals(200, a.getBalance(), 0);
  System.out.println("200 = " + a.getBalance());


  try {
   a.withdraw(300);
   System.out.println("a.withdraw(300) was expected to throw NotEnoughMoneyException");
} 
catch (NotEnoughMoneyException e) {

   //assertEquals(200, a.getBalance(), 0);
   System.out.println("200 = " + a.getBalance());

   //assertEquals(100, e.getMissingAmount(), 0);
   System.out.println("100 = " + e.getMissingAmount());

}
}


public static void main(String[] args) {
   System.out.println("accountConstructor");
   accountConstructor();
   System.out.println();

   System.out.println("accountWithdrawException");
   accountWithdrawException();
}*/

}
