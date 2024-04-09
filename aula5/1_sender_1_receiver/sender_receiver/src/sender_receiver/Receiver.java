package sender_receiver;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver extends Thread {
	private Data data;
	
	public Receiver(Data data) {
		this.data = data;
	}
	
	public void run() {
		while(true) {
			String message = data.receive();
			// gera número pseudoaleatório entre 3000 e 8000
			int randomTime = 
					ThreadLocalRandom.current().nextInt(3000, 8000);
			try {
				// espero entre 3 e 8 s
				Thread.sleep(randomTime);
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
			
			if(message == "END") {
				// última mensagem recebida
				System.out.println(
						"Não há mais mensagens a receber...");
				break;
			}
			
			
		}
	}
}
