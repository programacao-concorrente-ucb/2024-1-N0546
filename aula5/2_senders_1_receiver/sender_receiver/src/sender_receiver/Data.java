package sender_receiver;

public class Data {
	private String message;
	private boolean isSending = true;
	
	public synchronized void send(String message) {
		// só posso enviar se não tiver acontecendo
		// o recebimento. enquanto estiver recebendo, eu espero
		// espera -> wait();
		
		// enquanto não estou enviando, estou recebendo
		while(!isSending) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		// realizando envio...
		this.message = message;
		System.out.println("Mensagem enviada: " + this.message);
		// envio já terminou
		this.isSending = false;
		
		// notifico que já enviei e pode acontecer o recebimento
		notify();
	}
	
	public synchronized String receive() {
		// só posso receber se não tiver acontecendo
		// o envio. enquanto estiver enviando, eu espero
		// espera -> wait();
		
		// enquanto não estou recebendo, estou enviando
		while(isSending) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Thread foi interrompida!");
			}
		}
		// realizando recebimento...
		String receivedMessage = this.message;
		System.out.println("Mensagem recebida: " + receivedMessage);

		// recebimento já terminou
		this.isSending = true;
		
		// notifico que já recebi e pode acontecer o próximo envio
		notify();
		
		return receivedMessage;
	}
}
