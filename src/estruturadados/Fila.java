package estruturadados;

public class Fila <T> {
	private T[] elementos;
	private int tamanho;
	private int inicio;

	public Fila(int capacidade) {
		this.elementos = (T[])new Object[capacidade];
		this.tamanho = 0;
		this.inicio = 0;
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

	public void enfileira(T elemento) {
		aumentaCapacidade();
		this.elementos[tamanho] = elemento;
		this.tamanho++;
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}

	public T espiar() {
		if(this.estaVazia()) {
			return null;
		}
		return this.elementos[inicio]; //deixou 0
	}
	
	public T desenfileirar() {
		if(this.estaVazia()) {
			return null;
		}
		T elemento = this.elementos[inicio]; //deixou 0
		tamanho--;
		inicio++;
		return elemento;
	}

	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");

		for(int i = 0; i < this.tamanho - 1 ; i++) {
			s.append(elementos[i]);
			s.append(", ");
		}

		if(this.tamanho > 0) {
			s.append(elementos[this.tamanho - 1]);
		}
		s.append("]");

		return s.toString();


	}
}
