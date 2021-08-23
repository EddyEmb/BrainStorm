package metodos;


public class No {

	No prior;
	No next;
	Object data;	
	
	public No(Object data) {
		this.data = data;
	}
	public No(Object data, No prior, No next) {
		this.data = data;
		this.prior = prior;
		this.next = next;
	}
	
	public No obterAnterior() {
		return prior;
	}
	public void inserirAnterior(No prior) {
		this.prior = prior;
	}
	public No obterProximo() {
		return next;
	}
	public void inserirProximo(No next) {
		this.next = next;
	}
	public Object obterValor() {
		return data;
	}
	public void inseriValor(Object  data) {
		this.data = data;
	}
	public String toString() {
		return this.data.toString();
	}
}

