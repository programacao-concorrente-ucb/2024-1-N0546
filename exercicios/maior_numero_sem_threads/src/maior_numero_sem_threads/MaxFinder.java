package maior_numero_sem_threads;

public class MaxFinder {
    private int[] array;
    private int max = Integer.MIN_VALUE;
    
    public MaxFinder(int[] array) {
        this.array = array;
    }
        
    public int getMax() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
