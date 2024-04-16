package producer_consumer;

import java.util.Random;

public class Consumer extends Thread {
	private Buffer buffer;
	
	public Consumer(Buffer buffer, String name) {
		super(name); // chamar construtor da classe pai: new Thread(name);
		this.buffer = buffer;
	}
	
	public void run() {
		// consumir entre 1 e 5 produtos por vez
		int numProducts = new Random().nextInt(5) + 1;
		
		System.out.println(this.getName() + 
				" vai consumir " + numProducts);
		for(int i = 0; i < numProducts;i++){
			this.consume();
		}
		System.out.println(this.getName() +
				" terminou consumo!");

	}
	
	public void consume() {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			System.out.println("Thread foi interrompida!");
		}
		this.buffer.remove();
	}
}
