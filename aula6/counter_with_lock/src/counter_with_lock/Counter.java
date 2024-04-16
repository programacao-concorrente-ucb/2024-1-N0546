package counter_with_lock;

import java.util.concurrent.locks.Lock;

public class Counter {
	private Integer value;
	private Lock lock;
	
	public Counter(Integer value, Lock lock) {
		this.value = value;
		this.lock = lock;
	}
	
	public void increment(String threadName) {
		this.lock.lock();
		// somente uma thread vai acessar esse método por vez
		System.out.println(threadName + " entrou no método increment...");
		this.value++;
		System.out.println(threadName + " saiu do método increment...");

		// int tmp = this.value;
		// this.value = tmp + 1;
		this.lock.unlock();
	}
	
	public Integer getValue() {
		return this.value;
	}
}
