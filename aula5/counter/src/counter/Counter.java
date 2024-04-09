package counter;

public class Counter {
	private Integer value;
	
	public Counter(Integer value) {
		this.value = value;
	}
	
	public synchronized void increment(String threadName) {
		// somente uma thread vai acessar esse método por vez
		System.out.println(threadName + " entrou no método increment...");
		this.value++;
		System.out.println(threadName + " saiu do método increment...");

		// int tmp = this.value;
		// this.value = tmp + 1;
	}
	
	public Integer getValue() {
		return this.value;
	}
}
