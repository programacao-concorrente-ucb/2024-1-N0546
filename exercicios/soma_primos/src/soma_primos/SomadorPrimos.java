package soma_primos;

public class SomadorPrimos extends Thread {
    private int start;
    private int end;
    private int soma;
    
	public SomadorPrimos(int start, int end) {
		this.start = start;
		this.end = end;	
	}
	
    private boolean ehPrimo(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
            	return false;
            }
        }
        return true;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (ehPrimo(i)) {
                soma += i;
            }
        }
    }

    public long getSoma() {
        return soma;
    }
}
