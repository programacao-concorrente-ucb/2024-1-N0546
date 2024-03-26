package soma_primos;

public class Main {

	public static void main(String[] args) throws InterruptedException {
        int startInterval = 1;
        int endInterval = 20;

        int numThreads = 4;

        int intervalSize = (endInterval - startInterval + 1) / numThreads;
        int currentStart = startInterval;
        int currentEnd = startInterval + intervalSize - 1;
        int finalSum = 0;

        SomadorPrimos[] calculators = new SomadorPrimos[numThreads];
        for (int i = 0; i < numThreads; i++) {
            if (i == numThreads - 1) {
                currentEnd = endInterval;
            }
            calculators[i] = new SomadorPrimos(currentStart, currentEnd);
            calculators[i].start();
            currentStart = currentEnd + 1;
            currentEnd = currentStart + intervalSize - 1;
        }

        for (SomadorPrimos calculator : calculators) {
            calculator.join();
            finalSum += calculator.getSoma();
        }
        System.out.println("Soma dos primos no intervalo [" + startInterval + ", " + endInterval + "]: " + finalSum);

        
	}

}
