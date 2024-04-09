package sender_receiver;

public class Main {

	public static void main(String[] args) {
		Data data = new Data();
		String[] messages = {
				"mensagem 1",
				"mensagem 2",
				"mensagem 3",
				"mensagem 4",
				"END"
		};
		
		
		Sender sender = new Sender(data, messages);
		Receiver receiver = new Receiver(data);
		
		sender.start();
		receiver.start();
	}

}
