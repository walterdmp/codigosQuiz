package estruturadados;

import java.util.Arrays;
import java.util.Iterator;

public class Vetor <T>{
	
	private T[] elementos;
	private int tamanho;
	
	public Vetor(int capacidade) {
		this.elementos = (T[])new Object[capacidade];
		this.tamanho = 0;
	}
	
	public boolean adiciona(T elemento) {
		aumentaCapacidade();
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		} else {
			return false;
		}
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
	
	public boolean remove(int posicao, T elemento) {
		if(!(posicao >=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		for(int i = posicao; i < this.elementos.length - 1; i++) {
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
		
		
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
	
	public Object busca(int posicao) {
		if(!(posicao >=0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao inválida");
		}
		return this.elementos[posicao];
	}
	
	public int busca(T elemento) {
		for(int i = 0; i < this.tamanho; i++) {
			if(this.elementos[i].equals(elemento)) {
				return i;
			}
		} 
		return -1;
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
