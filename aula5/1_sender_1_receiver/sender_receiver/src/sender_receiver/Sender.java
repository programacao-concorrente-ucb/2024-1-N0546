package sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Sender extends Thread {
	private Data data;
	private String[] messages;
	
	public Sender(Data data, String[] messages) {
		this.data = data;
		this.messages = messages;
	}
	
	public void run() {
		for(String message: this.messages) {
			// gera número pseudoaleatório entre 3000 e 8000
			int randomTime = 
					ThreadLocalRandom.current().nextInt(3000, 8000);
			try {
				// espero entre 3 e 8 s
				Thread.sleep(randomTime);
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
			// envio a mensagem
			data.send(message);
		}
	}
}
