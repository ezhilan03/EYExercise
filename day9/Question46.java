package InternExercise.day9;

public class Question46 {
	public static void main(String[] args) {
		CitiBank2 bank = new CitiBank2("Ezhilan", "ABC", "savings", 1000);
		bank.depositAmount(100);
		bank.displayDetails();
	}

}

class CitiBank2 {
String name;
String acc_no;
String acc_type;
float balance;
	

public CitiBank2(String name, String acc_no, String acc_type, float balance) {
	super();
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
	System.out.println("Account Holder: "+this.name);
	System.out.println("Balance: "+this.balance);
	System.out.println("Thank you");
}

}