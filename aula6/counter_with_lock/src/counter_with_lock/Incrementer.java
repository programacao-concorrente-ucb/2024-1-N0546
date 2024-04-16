package counter_with_lock;

public class Incrementer extends Thread {
	private Counter counter;
	
	public Incrementer(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
//		System.out.println(this.getName() + 
//				" está incrementando...");
		this.counter.increment(this.getName());
	}
}
