package metodos;

import javax.swing.JOptionPane;

public class ListaCircular{

	public No  primeiro;
	public No  noAtual;
	public  int numNo = 0;
	public int indiceNoAtual = 0;
	
	public ListaCircular() {
		this.primeiro = null;
	}
  	
	public void adiciona(int valor) {
		numNo++;
		No novo_no = new No(valor);
		
		if(this.primeiro== null) {
			this.primeiro =novo_no;
			noAtual = this.primeiro;
			this.primeiro.inserirProximo(novo_no);
			this.primeiro.inserirAnterior(novo_no);
			 JOptionPane.showMessageDialog(null, "Valor Adicionado");
		}else {
		    No temp = this.primeiro;
		    //apenas 1 nó
		    if(temp.obterProximo() == temp) {
	    		temp.inserirProximo(novo_no);
	    		temp.inserirAnterior(novo_no);
	    		novo_no.inserirAnterior(temp);
	    		novo_no.inserirProximo(temp);
	    		 JOptionPane.showMessageDialog(null, "Valor Adicionado"); 
	    	//o nó inserido é menor que o primeiro nó
		    }else if(((Integer) novo_no.obterValor()).compareTo((Integer) this.primeiro.obterValor() ) == -1) {
	    	        	
		    	novo_no.inserirProximo(this.primeiro);
		    	novo_no.inserirAnterior(this.primeiro.obterAnterior());
		    	this.primeiro.obterAnterior().inserirProximo(novo_no);
		    	this.primeiro.inserirAnterior(novo_no);
		    	
		    	this.primeiro = novo_no;
		    	noAtual = this.primeiro.obterAnterior();
		    	 JOptionPane.showMessageDialog(null, "Valor Adicionado");
		    	    	
		    }else{
		    	
	    		//enquanto o novo nó for maior que o temp (até encontrar alguém maior
		    	//que ele
			    while( (((Integer) novo_no.obterValor()).compareTo((Integer) temp.obterValor() ) == 1)) { 
			     	temp = temp.obterProximo();
			
			    	//fechou um ciclo
			    	if(temp == this.primeiro)
			    		break;
			    }
			
			  
	    		novo_no.inserirProximo(temp);
	    		temp.obterAnterior().inserirProximo(novo_no);
				novo_no.inserirAnterior(temp.obterAnterior());
				temp.inserirAnterior(novo_no);
				 JOptionPane.showMessageDialog(null, "Valor Adicionado");
	    	}			
		}
	}

	
    public void inserirOrdenado(Integer valor) {
    	numNo++;
        No novoNo = new No(valor);
        No noAtual = this.primeiro;
        if (noAtual == null) {
        	novoNo.inserirProximo(novoNo);
            this.primeiro=novoNo;
        } else if (((Integer) noAtual.obterValor()).compareTo((Integer) novoNo.obterValor()) >= 0) {
            while (noAtual.obterProximo() != this.primeiro) {
                noAtual = noAtual.obterProximo();
            }
            noAtual.inserirProximo(novoNo);
            novoNo.inserirProximo(this.primeiro);
            this.primeiro=novoNo;
        } else {
            while (noAtual.obterProximo() != this.primeiro &&
                    ((Integer) noAtual.obterProximo().obterValor()).compareTo((Integer) novoNo.obterValor()) < 0) {
                noAtual = noAtual.obterProximo();
            }
            novoNo.inserirProximo(noAtual.obterProximo());
            noAtual.inserirProximo(novoNo);
        }

        
    }
	
	
	
	public void remove(int valor) {
		
		No n= buscaProximo(valor);
		
		if(n != null) {
			JOptionPane.showMessageDialog(null, "Valor removido!");
			
			if(numNo==0) {
			
			}
			numNo--;
			if(n == this.primeiro) {
				
				this.primeiro.obterAnterior().inserirProximo(this.primeiro.obterProximo());
				this.primeiro.obterProximo().inserirAnterior(this.primeiro.obterAnterior());
				this.primeiro = this.primeiro.obterProximo();
				
			}else {
				
				n.obterAnterior().inserirProximo(n.obterProximo());
				n.obterProximo().inserirAnterior(n.obterAnterior());
				
			}
			
		}else if(n==null) {
			JOptionPane.showMessageDialog(null, "A remoção falhou,Valor não existe!");
			
		}
		
		
	}
	
	
	public No busca(Integer valor) {
		No temp = this.primeiro;
		if(temp!=null) {
			
		
		while(valor.compareTo((Integer) temp.obterValor()) == 1) { 
			temp = temp.obterProximo();
	
	    	//fechou um ciclo ou passou do valor
	    	if((temp == this.primeiro) || (valor.compareTo( (Integer) temp.obterValor() ) == -1)) 
	    		return null;
	    	
	    }
		}
	
		return temp;
		 
		
	}
	
	public No indiceActual(Integer valor) {
		No temp = this.primeiro;
		if(temp!=null) {
	for(int i=0; i < valor;i++) {
		temp=temp.obterProximo();
	}
		}
		return temp;
		
		
	}
	
	
	public No buscaProximo(Integer valor) {
		
		boolean prior = true;
		boolean next = true;
			
		
		//valor buscado é menor que o currenteNode?
		if(valor.compareTo((Integer) noAtual.obterValor())  == -1 )  {
						
			//estou em 90% do final da lista
			if(indiceNoAtual < numNo*0.9) {
				prior = false;
			}
			
		}else if(valor.compareTo( (Integer) noAtual.obterValor())  == 1 )  {
			
			//estou em 10% do final da lista
			if(indiceNoAtual < numNo*0.1) {
				next = false;
			}
			
		}else {
			return noAtual;
		}
			
		No stop = noAtual;
		
		if( (prior) || (!next))
			this.obterNoAnterior();
		else if( (next) || (!prior)) 
			this.obterNoProximo();
		
		
		while(valor.compareTo((Integer) noAtual.obterValor() ) != 0) { 
			if( (prior) || (!next))
				this.obterNoAnterior();
			else if( (next) || (!prior)) 
				this.obterNoProximo();
		
			//fechou um ciclo
			if(noAtual == stop)
				return null;
		}
		
	
		return noAtual;
		 
		
	}
	
	
	public No obterNoProximo() {
		indiceNoAtual++;
		noAtual = noAtual.obterProximo();
		return noAtual;
	}
	
	public No  obterNoAnterior() {
		indiceNoAtual--;
		noAtual = noAtual.obterAnterior();
		return noAtual;
	}

	public void resetCurrentNode() {
		this.noAtual = this.primeiro.obterAnterior();
	}
	
	public String toString() {
		String s = "";
		resetCurrentNode();
		No stop = noAtual;
		
		
		do {
			obterNoProximo();
			s+= noAtual .obterValor().toString() + " => ";
		}while(noAtual !=  stop);
		
			return s+primeiro;
		
		
	} 
	
	public void removeTudo() {
	
		resetCurrentNode();
		No stop = noAtual;
		
		
		do {
			obterNoProximo();
			noAtual.inseriValor(null);
			
		}while(noAtual !=  stop);
		numNo=0;
		primeiro=null;
		
		
		
	} 
	

	
	
	
}
