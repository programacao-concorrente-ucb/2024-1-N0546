package maior_numero;

public class MaxFinder extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int max = Integer.MIN_VALUE;
    
    public MaxFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }
    
    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
    }
    
    public int getMax() {
        return max;
    }
}
