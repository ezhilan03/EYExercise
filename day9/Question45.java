package EYExercise.day9;

public class Question45 {

	public static void main(String[] args) {
		Digibank bank = new Digibank();
		bank.assignValues("Ezhilan", "ABC", "savings", 1000);
		bank.depositAmount(100);
		bank.displayDetails();
	}

}

class Digibank {
	String name;
	String acc_no;
	String acc_type;
	float balance;
	
	public void assignValues(String name, String acc_no, String acc_type, float balance) {
		this.name = name;
		this.acc_no = acc_no;
		this.acc_type = acc_type;
		this.balance = balance;
	}
	
	public void depositAmount(float amount) {
		checkBalance();
		balance=balance+amount;
		System.out.println("Successfully Deposited!!!");
		checkBalance();
	}
	
	public void checkBalance() {
		System.out.println("\nYour balance is: "+balance);
	}
	
	public void displayDetails() {
		System.out.println("Wecome to DIGIBANK");
		System.out.println("Account details");
		System.out.println("Account Holder: "+name);
		System.out.println("Balance: "+balance);
		System.out.println("Thank you");
	}
}