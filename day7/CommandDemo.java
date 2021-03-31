package InternExercise.day7;

public class CommandDemo {
	public static void main(String[] args) { //client
		Tv tv = new Tv();
		SetTopBox box = new SetTopBox();
		VGame vg = new VGame();
		SoundSystem ss = new SoundSystem();
		
		NewsChannelCommand newsCommand = new NewsChannelCommand(tv, box, vg, ss);
		PlayTennisCommand playCommand = new PlayTennisCommand(tv, box, vg, ss);
		SerialChannelCommand serialCommand = new SerialChannelCommand(tv, box, vg, ss);
		
		UniversalRemote remote = new UniversalRemote();
		remote.setCommand(newsCommand, 0);
		remote.setCommand(serialCommand, 1);
		remote.setCommand(playCommand, 2);
		
		remote.executeCommand(0);
	}
}

class UniversalRemote{ //invoker
	Command c[] = new Command[5];
	public void doRemote() {
		for(int i=0;i<5;i++) {
			c[i]=new DummyCommand();
		}
	}
	public void executeCommand(int slot) {
		c[slot].execute();
	}
	public void setCommand(Command command,int slot) {
		c[slot]=command;
	}
}

abstract class Command{ // command
	Tv sony;SetTopBox tata;VGame vGame;SoundSystem ss;
	abstract public void execute();
	public Command() {

	}
	public Command(Tv sony,SetTopBox tata,VGame vGame,SoundSystem ss) {
		this.sony=sony;
		this.tata=tata;
		this.vGame=vGame;
		this.ss=ss;
	}
}
class DummyCommand extends Command{ //concrete commands
	@Override
	public void execute() {
		System.out.println("Dummy command is being executed....");
	}
}
class NewsChannelCommand extends Command{
	public NewsChannelCommand(Tv sony,SetTopBox tata,VGame vGame,SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	@Override
	public void execute() {
		System.out.println("News channel command process starts..........");
		sony.switchOn();
		sony.av1Mode();
		ss.highSound();
		tata.newsChannel();
		System.out.println("Process over.....Enjoy the news....");
	}
}
class PlayTennisCommand extends Command{
	public PlayTennisCommand(Tv sony,SetTopBox tata,VGame vGame,SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	@Override
	public void execute() {
		System.out.println("Play Tennis command process starts..........");
		sony.switchOn();
		sony.av1Mode();
		ss.highSound();
		vGame.playTennis();
		System.out.println("Process over.....Enjoy the game....");
	}
}
class SerialChannelCommand extends Command{
	public SerialChannelCommand(Tv sony,SetTopBox tata,VGame vGame,SoundSystem ss) {
		super(sony,tata,vGame,ss);
	}
	@Override
	public void execute() {
		System.out.println("Serial channel command process starts..........");
		sony.switchOn();
		sony.av1Mode();
		tata.serialChannel();
		ss.lowSound();
		System.out.println("Process over.....Enjoy the Serial....");
	}
}

class Tv{
	public void switchOn() {
		System.out.println("tv is swtiched on...");
	}
	public void av1Mode() {
		System.out.println("av1 mode on....");
	}
}
class SetTopBox{
	public void newsChannel() {
		System.out.println("news channel on...");
	}
	public void serialChannel() {
		System.out.println("serial channel on...");
	}
}
class VGame{
	public void playTennis() {
		System.out.println("play tennis.......");
	}
}
class SoundSystem{
	public void lowSound() {
		System.out.println("low sound.......");
	}
	public void highSound() {
		System.out.println("high sound.......");
	}
}