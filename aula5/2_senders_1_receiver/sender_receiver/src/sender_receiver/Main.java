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
		
		String[] messages2 = {
				"so long",
				"and thanks for all the fish",
				"END"
		};
		
		Sender sender = new Sender(data, messages);
		Sender sender2 = new Sender(data, messages2);

		Receiver receiver = new Receiver(data, 2);
		
		sender.start();
		sender2.start();

		receiver.start();
	}

}
