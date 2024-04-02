package counter;

public class Counter {
	private Integer value;
	
	public Counter(Integer value) {
		this.value = value;
	}
	
	public void increment() {
		this.value++;
	}
	
	public Integer getValue() {
		return this.value;
	}
}
