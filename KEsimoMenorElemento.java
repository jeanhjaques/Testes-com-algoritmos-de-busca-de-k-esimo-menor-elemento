public class KEsimoMenorElemento{
	public static int randomizedSelect(int[] vetor, int p, int r, int k){
		if(p == r){
			return vetor[p];
		}
		int q = randomizedPartition(vetor, p, r);
		int i = q - p + 1;
		if(k == i){
			return vetor[q];
		}
		else if(k<i){
			return randomizedSelect(vetor, p, q-1,k);
		}
		else{
			return randomizedSelect(vetor,q+1,r, k-1);
		}
	}

	public static int randomizedPartition(int[] vetor, p, r){
		i = random(p,r);
		int aux = vetor[r];
		vetor[r] = vetor[i];
		vetor[i] = aux;
		return partiton(vetor, p, r);
	}

	public static int partition(int[] vetor, p, r){
		x = vetor[r];
		i = p - 1;
		//continua na pagina 192
		//for(int j = p; j<r-1; j++)
	}

	public static int select(vetor[], p, r, i){
		//buscar em https://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/median.html
	}
}