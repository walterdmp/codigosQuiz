package estruturadados;

public class No<T> {
	private T elemento;
	private No proximo;
	
	public No(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}
	
	public No(T elemento, No proximo) {
		super();
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("No [elemento=").append(elemento).append(", proximo=").append(proximo).append("]");
        return builder.toString();
    }
	
	
}
