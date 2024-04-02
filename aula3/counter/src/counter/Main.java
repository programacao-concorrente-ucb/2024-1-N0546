package counter;

public class Main {
	public static void main(String[] args) {
		int numExec = 0;
		while(true) {
			Counter counter = new Counter(0);
			
			Incrementer inc1 = new Incrementer(counter);
			Incrementer inc2 = new Incrementer(counter);
			Incrementer inc3 = new Incrementer(counter);
			Incrementer inc4 = new Incrementer(counter);
			
			inc1.start();
			inc2.start();
			inc3.start();
			inc4.start();
			
			try {
				inc1.join();
				inc2.join();
				inc3.join();
				inc4.join();
			} catch (InterruptedException e) {
				System.out.println("Erro ao chamar joins...");
				e.printStackTrace();
			}
			numExec++;
			if(counter.getValue() == 2) {
				System.out.println("Num. de execuções: " + numExec);
				System.out.println("Valor final do contador: " + counter.getValue());
				break;
			}
		}
	}
}
