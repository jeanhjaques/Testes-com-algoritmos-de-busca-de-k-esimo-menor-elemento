import java.util.Random;
import java.util.Arrays;
public class KEsimoMenorElemento{
 
	//1ª estratégia
	//Encontra o K-ésimo elemento ordenando o vetor e retornando k
	//Recebe um vetor e um K e retona o K-ésimo menor elemento.
	public static int kEsimoOrdenando(int[] vetor, int k){
		int[] vetorOrdenado = Ordenacao.quickSort(vetor);
		return vetorOrdenado[k];
	}

	//-----------------------------------------------------------------------------------------
	//2ª estratégia
	//Encontra o K-ésimo elemento do vetor gerando um heap min com seus valores
	//Recebe um vetor e um K e retona o K-ésimo menor elemento.
	public static int kEsimoUsandoHeapMin(int[] vetor, int k){
		MinHeap minHeap = new MinHeap(vetor.length);

		//insere valores no heap
		for(int i=0; i<vetor.length;i++){
			minHeap.insert(vetor[i]);
		}

		//remove até chegar no K
		for(int i=0; i<k;i++){
			minHeap.remove();
		}

		return minHeap.remove();
	}

	//-----------------------------------------------------------------------------------------
	//3ª estratégia
	//Usando randomizedSelect
	//Este código foi feito seguindo o pseudo código do livro do Cormen e mesmo assim está apresentando bugs
	public static int randomizedSelect(int[] vetor, int p, int r, int k){
		if(p == r){
			return vetor[p];
		}
		int q = randomizedPartition(vetor, p, r);
		int i = q - p + 1;
		if(i == k){
			return vetor[q];
		}
		else if(i<k){
			return randomizedSelect(vetor, p, q-1,i);
		}
		else{
			return randomizedSelect(vetor,q+1,r, i-k);
		}
	}



	private static int partition(int[] vetor, int p, int r){
		int x = vetor[r];
		int i = p - 1;
		for(int j = p; j<r-1; j++){
			if(vetor[j]<= x){
				i = i + 1;
				int aux = vetor[i];
				vetor[i] = vetor [j];
				vetor[j] = aux;
			}
		}
		int aux = vetor[i+1];
		vetor[i+1] = vetor[r];
		vetor[r] = aux;
		return i+1;
	}

	private static int randomizedPartition(int[] vetor, int p, int r){
		Random random = new Random();
		int i = random.nextInt(r) + p;  //seleciona um numero aleatório em p e r
		int aux = vetor[r];
		vetor[r] = vetor[i];
		vetor[i] = aux;
		return partition(vetor, p, r);
	}

	//-----------------------------------------------------------------------------------------
	//4ª estratégia Usando Select
	public static int select(int[] vetor, int k){
		System.out.println(Arrays.toString(vetor));

		if(vetor.length == 1){
			return vetor[0];
		}

        //1- Calcula a quantidade de partes e a possibilidade de haver um resto
		int partes = vetor.length / 5;
		int restoDasPartes = vetor.length % 5;

		int vetorPartes[][] = new int[partes][5];
		int vetorResto[] = new int[restoDasPartes];;
		if(restoDasPartes != 0){
			for(int i=0; i<restoDasPartes; i++){
				vetorResto[i] =  vetor[(vetor.length-1)-i];
			}
		}
		int iteradorPartes = 0;


		//1-divide o vetor adicionando os valores em uma matriz de partes
		for(int i= 0; i<vetor.length-restoDasPartes; i = i+5){
			for(int j=0;j<5;j++){
				vetorPartes[iteradorPartes][j] = vetor[j+i];
			}
			iteradorPartes++;
		}

		//2- Ordena os elementos das partes
		for(int i = 0; i<partes; i++){
			vetorPartes[i] = Ordenacao.insertionSort(vetorPartes[i]);
		}
		vetorResto = Ordenacao.insertionSort(vetorResto);


		//2- Calcula a mediana das partes e salva num vetor
		int vetorMedianas[] = new int[partes+1];
		for(int i = 0; i<partes; i++){
			vetorMedianas[i] = calculaMedianaVetor(vetorPartes[i]);
		}
		if(restoDasPartes != 0){
			vetorMedianas[partes] = calculaMedianaVetor(vetorResto);
		}



		//Código incompleto, encontramos dificuldades em entender a recursão deste algoritmo.
		return 0; // retorno adicionado só para não dar erro de falta de retorno já que o método está incompleto.
	}

	//recebe um vetor e retorna a mediana de seus elementos.
	private static int calculaMedianaVetor(int[] vetor){
		int esq=0;
		int dir=vetor.length-1;
		int meio;
		meio=(esq+dir)/2;
		return vetor[meio];
	}
}

	
