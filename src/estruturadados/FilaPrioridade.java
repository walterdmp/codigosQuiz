package estruturadados;

public class FilaPrioridade<T> {

	private T[] elementos;
	private int tamanho;
	private int inicio;

	public FilaPrioridade(int capacidade) {
		this.elementos = (T[])new Object[capacidade];
		this.tamanho = 0;
		this.inicio = 0;
	}

	public void enfileira(T elemento) {
		Comparable<T> chave = (Comparable<T>) elemento;
		int i;
		for(i = 0; i < this.tamanho; i++) {
			if(chave.compareTo(this.elementos[i]) < 0) {
				break;
			}
		}
		adiciona(i, elemento);
	}

	public boolean adiciona(int posicao, T elemento) {
		aumentaCapacidade();
		if(!(posicao >=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		for(int i = this.tamanho - 1; i >= posicao; i--) {
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;

		return true;
	}

	private void aumentaCapacidade() {
		if(this.tamanho == this.elementos.length) {
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
			for(int i = 0; i < this.tamanho; i++) {
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}	 
}
