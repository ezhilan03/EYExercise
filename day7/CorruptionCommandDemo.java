package InternExercise.day7;

public class CorruptionCommandDemo {	
	static ESeva eseva;
	static{
		Police police=new Police();
		Hospital hospital=new Hospital();
		Corporation corporation=new Corporation();
		FoodSafety foodsafety=new FoodSafety();
		eseva=new ESeva();
		eseva.setCommand(new HotelOpenCommand(police, hospital, corporation, foodsafety), 0);
		eseva.setCommand(new ForeignDeathCommand(police, hospital, corporation, foodsafety), 1);
		eseva.setCommand(new OrphanDeathCommand(police, hospital, corporation, foodsafety), 2);
		}
	public static void main(String[] args) {
		
		eseva.executeCommand(2);
	}
}
class ESeva{
	Commands c[]=new Commands[5];
	public ESeva() {
		for(int i=0;i<5;i++) {
			c[i]=new DummyCommand();
		}
	}
	public void executeCommand(int slot) {
		c[slot].execute();
	}
	public void setCommand(Commands c,int slot) {
		this.c[slot]=c;
	}
	class DummyCommand extends Commands{
		@Override
		public void execute() {
			System.out.println("I dummy yet to be operational........");
		}
	}
}
abstract class Commands{
	Police police;Hospital hospital;Corporation corporation;FoodSafety foodsafety;
	public Commands() {
		// TODO Auto-generated constructor stub
	}
	public Commands(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		this.police = police;
		this.hospital = hospital;
		this.corporation = corporation;
		this.foodsafety = foodsafety;
	}
	public abstract void execute();
}
class HotelOpenCommand extends Commands{
	public HotelOpenCommand(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		super(police, hospital, corporation, foodsafety);
	}
	@Override
	public void execute() {
		System.out.println("hotel opening process started........");
			foodsafety.checkPremises();
			corporation.doInspection();
			police.doPoliceCertificate();
			foodsafety.giveFssCertificate();
		System.out.println("Hotel opening process over...now run the hotel............");
	}
}
class ForeignDeathCommand extends Commands{
	public ForeignDeathCommand(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		super(police, hospital, corporation, foodsafety);
	}
	@Override
	public void execute() {
		System.out.println("Foreign death Certificate process started........");
			police.doPoliceInvestigation();
			police.doPoliceCertificate();
			corporation.doInspection();
			hospital.doPostmortem();
			corporation.giveDeathCertificate();
			hospital.arrangeTransport();
		System.out.println("Foreign Death Certificate process over...now send the body............");
	}
}
class OrphanDeathCommand extends Commands{
	public OrphanDeathCommand(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		super(police, hospital, corporation, foodsafety);
	}
	@Override
	public void execute() {
			System.out.println("Orphan death process started........");
			hospital.doPostmortem();
			police.doPoliceInvestigation();
			police.doPoliceCertificate();
			corporation.giveDeathCertificate();
		System.out.println("Orphan death process over...now bury the body............");
	}
}
class Police{
	public void doPoliceInvestigation() {
		System.out.println("police doing investigation....");
	}
	public void doPoliceCertificate() {
		System.out.println("police certificate given....");
	}
}
class Hospital {
	public void doPostmortem() {
		System.out.println("postmortem done by hospital...");
	}
	public void arrangeTransport() {
		System.out.println("body transport arranged...");
	}
}
class Corporation {
	public void giveDeathCertificate() {
		System.out.println("death certificate given....");
	}
	public void doInspection() {
		System.out.println("inspection done by corporation...");
	}
}
class FoodSafety{
	public void checkPremises() {
		System.out.println("premises checked by FSS officials...");
	}
	public void giveFssCertificate() {
		System.out.println("FSS certificate given..........");
	}
}