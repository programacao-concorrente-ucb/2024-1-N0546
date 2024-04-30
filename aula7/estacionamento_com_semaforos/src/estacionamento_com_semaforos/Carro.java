package estacionamento_com_semaforos;

import java.util.concurrent.Semaphore;

public class Carro extends Thread {
	private Semaphore estacionamento;
	
	public Carro(String nome, Semaphore estacionamento) {
		super(nome);
		this.estacionamento = estacionamento;
	}
		
	public void run() {
		// se o estacionamento estiver lotado (10 carros), 
		// eu espero algum carro sair
		try {
			//System.out.println("Ainda não adquiriu o semáforo!");
			this.estacionamento.acquire();
			//System.out.println("Agora adquiriu o semáforo!");
			// entro no estacionamento
			System.out.println(this.getName() + " entrou no estacionamento!");
			// espero 5 s
			Thread.sleep(10000);
			
			// saio do estacionamento
			System.out.println(this.getName() + " saiu do estacionamento!");

			this.estacionamento.release();

		} catch (InterruptedException e) {
			System.out.println("Thread interrompida!");
		}
		
		
	}
	
}
