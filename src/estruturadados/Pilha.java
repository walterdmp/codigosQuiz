package estruturadados;

public class Pilha<T> {
	private T[] elementos;
	private int tamanho;

	public Pilha(int capacidade) {
		this.elementos = (T[])new Object[capacidade];
		this.tamanho = 0;
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

	public void empilha(T elemento) {
		aumentaCapacidade();
		this.elementos[tamanho] = elemento;
		this.tamanho++;
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}

	public T topo() {
		if(this.estaVazia()) {
			return null;
		}
		return this.elementos[tamanho -1];
	}
	
	public T desempilhar() {
		if(this.estaVazia()) {
			return null;
		}
		T elemento = this.elementos[tamanho -1];
		tamanho--;
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
