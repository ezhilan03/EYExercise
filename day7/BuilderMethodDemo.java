package InternExercise.day7;

public class BuilderMethodDemo {
	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("12gbHDD","8gbRAM").setBluetooth("bluetoothenabled").build();
		System.out.println(computer);
	}
}

class Computer{
	//fixed properties
	private String hdd;
	private String ram;
	
	//optional properties
	private String bluetooth;
	private String graphicsCard;
	
	public Computer(ComputerBuilder builder) {
		this.hdd=builder.hdd;
		this.ram=builder.ram;
		this.bluetooth=builder.bluetooth;
		this.graphicsCard=builder.graphicsCard;
	}
	
	
	@Override
	public String toString() {
		return "Computer [hdd=" + hdd + ", ram=" + ram + ", bluetooth=" + bluetooth + ", graphicsCard=" + graphicsCard
				+ "]";
	}


	static class ComputerBuilder{
		private String hdd;
		private String ram;
		private String bluetooth;
		private String graphicsCard;
		
		public ComputerBuilder(String hdd,String ram) {
			this.hdd=hdd;
			this.ram=ram;
		}
		
		public final String getHdd() {
			return hdd;
		}

		public final void setHdd(String hdd) {
			this.hdd = hdd;
		}

		public final String getRam() {
			return ram;
		}

		public final void setRam(String ram) {
			this.ram = ram;
		}

		public final String getBluetooth() {
			return bluetooth;
		}

		public final ComputerBuilder setBluetooth(String bluetooth) {
			this.bluetooth = bluetooth;
			return this;
		}

		public final String getGraphicsCard() {
			return graphicsCard;
		}

		public final ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}

		
		public Computer build() {
			return new Computer(this);
		}
	}
}