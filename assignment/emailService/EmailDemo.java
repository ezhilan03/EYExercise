package EYExercise.assignment.emailService;

public class EmailDemo {
	public static void main(String[] args) throws Exception{
		EmailService sender = new EmailService();
		sender.sendMail("invoice");
	}
}

