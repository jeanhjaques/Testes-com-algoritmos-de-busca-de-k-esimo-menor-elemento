import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main{

	/*
	Implementado por:
	Jean Henrique - 201619060485
	Clara Sanabria - 201719060207

	*/
	public static void main(String[] args){

		Scanner ler = new Scanner(System.in);

		System.out.println("Defina o valor de MAX: ");
		int max = ler.nextInt();

		Random random = new Random();


		System.out.println("      n     |      k     |    kth     |  1-quickSort  |   2-minHeap   |");

		for(int i = 10; i<=max;i=i+10){

			int k = random.nextInt(i-1);
			int[] vetorTeste = new int[i];

			int kEsimo;

			//Preenche o vetor com números inteiros aleatórios
            for(int j=0; j<vetorTeste.length; j++){
                vetorTeste[j] = random.nextInt();
            }

            //Testa usando ordenação quicksort
            long tempoInicial = System.nanoTime();
            kEsimo = KEsimoMenorElemento.kEsimoOrdenando(vetorTeste, k);
            long tempoFinal = System.nanoTime();

            long tempoOrdenacao = tempoFinal - tempoInicial;
            tempoInicial = 0;
            tempoFinal = 0;

            String tempoOrdenacaoFormatado = String.format("%.6f",(double)tempoOrdenacao/1000000000);


            //Testa usando heapMin
            tempoInicial = System.nanoTime();
            kEsimo = KEsimoMenorElemento.kEsimoUsandoHeapMin(vetorTeste, k);
            tempoFinal = System.nanoTime();

            long tempoHeap = tempoFinal - tempoInicial;
            tempoInicial = 0;
            tempoFinal = 0;

            String tempoHeapFormatado = String.format("%.6f",(double)tempoHeap/1000000000);

            System.out.println("     "+i+"          "+k+"        "+kEsimo+"       "+tempoOrdenacaoFormatado+"         "+tempoHeapFormatado);
		}

	}
}