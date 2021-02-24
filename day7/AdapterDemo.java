package day7;

public class AdapterDemo {
	public static void main(String[] args) {
		IndianSocket ss =new ShakthiSocket();
		AmericanPlug ap = new LenovoPlug();
		IndianAdapter ia = new IndianAdapter(ap);
		ss.roundPinHole(ia);
	}
}

class IndianAdapter extends IndianPlug{
	AmericanPlug ap;
	public IndianAdapter(AmericanPlug ap) {
		this.ap=ap;
	}
	@Override
	public void roundPin() {
		ap.boxPin();
		
	}
}

abstract class IndianPlug{
	public abstract void roundPin();
}
abstract class IndianSocket{
	public abstract void roundPinHole(IndianPlug ip);
}
abstract class AmericanPlug{
	public abstract void boxPin();
}
abstract class AmericanSocket{
	public abstract void roundPinHole(AmericanPlug ap);
}

class ShakthiSocket extends IndianSocket{
	@Override
	public void roundPinHole(IndianPlug ip) {
		ip.roundPin();
	}
}
class LenovoPlug extends AmericanPlug{
	@Override
	public void boxPin() {
		System.out.println("box pin is working");
		
	}
}