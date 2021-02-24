package day5;

public class ClassesAndObjectDemo {
	public static void main(String[] args) {
		Pepsi pp = new Pepsi();
		Kalimark kk= new Kalimark();
		kk.makeBovontoCola();
	}
	
}

abstract class Cola {
	abstract void makeCola(); 
}
class Pepsi{
	void makePepsiCola() {
		Kalimark cc4 = new Kalimark();
	}
}
class Kalimark{
	public void makeBovontoCola() {
		//anonymous inner class
		new Cola() {
			@Override
			void makeCola() {
				System.out.println("Campa cola anonymous cola");
			}
		}.makeCola();
	}
	
//	public void makeBovontoCola() {
//		//local inner class
//	    class CampaCola extends Cola{
//			int campoMoney=100;
//			@Override
//			public void makeCola() {
//				System.out.println("Campa cola"+campoMoney);
//			}
//		}
//	    Cola cc3 = new CampaCola();
//	    cc3.makeCola();
	}
	
//		public Cola trojanMethod() {
//			return new CampaCola();
//		}
	
//	class CampaCola extends Cola{
//		int campoMoney=100;
//		 public void makeCola() {
//			System.out.println("Campa cola");
//		}
//	}
}