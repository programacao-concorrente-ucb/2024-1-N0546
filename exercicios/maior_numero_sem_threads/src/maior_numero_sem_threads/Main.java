package maior_numero_sem_threads;

import java.util.Random;

public class Main {
    public static int[] gerarArrayAleatorio(int tamanho, int min, int max) {
        int[] array = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
    
    public static void showArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
	public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int tamanhoArray = 100000;
        int min = 1;
        int max = 1000000;
        int[] array = gerarArrayAleatorio(tamanhoArray, min, max);
        
        MaxFinder maxFinder = new MaxFinder(array);
        //showArray(array);
        
        int maxInArray = maxFinder.getMax();
        

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        
        // Exibe o resultado
        System.out.println("O maior número no array é: " + maxInArray);
        System.out.println("Tempo decorrido: " + elapsedTime + " milliseconds");

	}
}
