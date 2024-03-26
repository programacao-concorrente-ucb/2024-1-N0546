package operacoes_aritmeticas;

public class Main {
	public static void main(String[] args) {
		Soma soma = new Soma(41, 1);
		Subtracao sub = new Subtracao(50, 8);
		Divisao div = new Divisao(84, 2);
		Multiplicacao mult = new Multiplicacao(21, 2);

		soma.start();
		sub.start();
		div.start();
		mult.start();
	}

}
