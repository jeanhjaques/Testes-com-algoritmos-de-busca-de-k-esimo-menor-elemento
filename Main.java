import java.util.Arrays;
import java.util.Random;
public class Main{
	public static void main(String[] args){
		int vetorInteiros[] = {10,20,30,40,50,100,75};

		System.out.println(Arrays.toString(vetorInteiros));

		//System.out.println(KEsimoMenorElemento.randomizedSelect(vetorInteiros, 0, 6, 2));

		//System.out.println(KEsimoMenorElemento.kEsimoOrdenando(vetorInteiros, 2));

		//System.out.println(KEsimoMenorElemento.kEsimoUsandoHeapMin(vetorInteiros,2));

		int max = 50;
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