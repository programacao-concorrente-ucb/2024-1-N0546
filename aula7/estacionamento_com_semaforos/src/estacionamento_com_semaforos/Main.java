package estacionamento_com_semaforos;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		Semaphore estacionamento = new Semaphore(10);
		
		for(int i = 0; i < 50;i++) {
			new Carro("carro " + i, estacionamento).start();
		}

	}

}
