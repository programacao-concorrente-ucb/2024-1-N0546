package producer_consumer;

import java.util.Random;

public class Producer extends Thread {
	private Buffer buffer;
	
	public Producer(Buffer buffer, String name) {
		super(name); // chamar construtor da classe pai: new Thread(name);
		this.buffer = buffer;
	}
	
	public void run() {
		// produzir entre 1 e 5 produtos por vez
		int numProducts = new Random().nextInt(5) + 1;
		
		System.out.println(this.getName() + 
				" vai produzir " + numProducts);
		for(int i = 0; i < numProducts;i++){
			this.produce();
		}
		System.out.println(this.getName() + 
				" terminou produção!");

	}
	
	public void produce() {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println("Thread foi interrompida!");
		}
		
		int product = new Random().nextInt(1000);
		this.buffer.add(product);
	}
}
