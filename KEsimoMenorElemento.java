import java.util.Random;
public class KEsimoMenorElemento{
 
	//Encontra o K-ésimo elemento ordenando o vetor e retornando k
	public static int kEsimoOrdenando(int[] vetor, int k){
		int[] vetorOrdenado = Ordenacao.quickSort(vetor);
		return vetorOrdenado[k];
	}

	//Encontra o K-ésimo elemento do vetor gerando um heap min com seus valores
	//Remove valores até chegar em K, então retorna K que deverá ser o K-ésimo elemento
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

	/*
	public static int select(vetor[], p, r, i){
		//buscar em https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/median.html
	}
	*/
}