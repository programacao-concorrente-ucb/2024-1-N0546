package counter_with_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		int numExec = 0;
		ReentrantLock lock = new ReentrantLock();
		while(true) {
			Counter counter = new Counter(0, lock);
			
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
			System.out.println("Valor final do contador: " + counter.getValue());

			if(counter.getValue() != 4) {
				System.out.println("Num. de execuções: " + numExec);
				System.out.println("Valor final do contador: " + counter.getValue());
				break;
			}
		}
	}
}
