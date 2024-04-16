package producer_consumer;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buffer {
	private Queue<Integer> buffer;
	private Lock lock;
	private Condition bufferIsNotFull; // buffer não cheio
	private Condition bufferIsNotEmpty; // buffer não vazio
	static Integer MAX_CAPACITY = 10;
	
	
	public Buffer(Queue<Integer> buffer, Lock lock) {
		this.buffer = buffer;
		this.lock = lock;
		this.bufferIsNotFull = this.lock.newCondition();
		this.bufferIsNotEmpty = this.lock.newCondition();

	}
	
	public void add(Integer product) {
		this.lock.lock();
		
		// enquanto buffer tá cheio
		while(this.buffer.size() == MAX_CAPACITY) {
			// espero...
			try {
				this.bufferIsNotFull.await();
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida");
			}
		}
		System.out.println("Adicionando produto");
		
		this.buffer.add(product);
		
		// indico consumidores que há produtos para consumir
		this.bufferIsNotEmpty.signalAll();
		
		this.lock.unlock();
		
	}
	
	public void remove() {
		this.lock.lock();
		
		// enquanto buffer tá cheio
		while(this.buffer.size() == 0) {
			// espero...
			try {
				this.bufferIsNotEmpty.await();
			} catch (InterruptedException e) {
				System.out.println("Thread interrompida");
			}
		}
		System.out.println("Removendo produto");
		
		this.buffer.remove();
		
		// indico produtores que há espaço para produzir
		this.bufferIsNotFull.signalAll();
		
		this.lock.unlock();
		
	}
}
