public class NotEnoughMoneyException extends IllegalStateException{

	private double amount;
	private double balance;

	public NotEnoughMoneyException(double amount, double balance){
		// Your code here
		this.amount = amount;
		this.balance = balance;
	}

	public double getAmount(){
		return amount;
	}

	public double getBalance(){
		return balance;
	}

	public double getMissingAmount(){
		// Your code here.
		return amount - balance;
	}

	public String getMessage(){
		return "You do not have enough money to withdraw " + amount + "$";
	}
}
