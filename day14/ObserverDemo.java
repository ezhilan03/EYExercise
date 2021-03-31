package InternExercise.day14;

import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm alarm = new FireAlarm();
		Teacher shoaib = new Teacher();
		Student student1 = new Student();
		
		
		alarm.addObserver(shoaib);
		alarm.addObserver(student1);
		
		alarm.setAlarm();
	}
}

class MultiThreadObservable extends Observable{
	Vector <Observer> vector = new Vector<Observer>();
	@Override
	public synchronized void addObserver(Observer o) {
		vector.add(o);
	}
	@Override
	public void notifyObservers(Object arg) {
		ExecutorService es = Executors.newFixedThreadPool(vector.size());
		Enumeration<Observer> en = vector.elements();
		while(en.hasMoreElements()) {
			Observer obs =en.nextElement();
			es.execute(()->{
				obs.update(this,arg);
			});
		}
	}
}

class FireAlarm extends MultiThreadObservable{
	public void setAlarm() {
		setChanged();
		notifyObservers("Fire Fire Fire Fire Fire");
	}
}

class Student implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		run();
	}
	public void run() {
		System.out.println("Student is running");
	}
}
class Teacher implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		run();
	}
	public void run() {
		System.out.println("Teacher is thinking");
		try {Thread.sleep(10000);}catch(Exception e) {}
		System.out.println("Teacher is running");
	}
}