public class Lista {
    private No inicio; // Referência para o primeiro nó da lista
    private No ultimo; // Referência para o último nó da lista
    private int tamanho;// Referência para o tamanho da lista

    public No getInicio() {
		return inicio;
	}
    
    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

	public No getUltimo() {
		return ultimo;
	}
	
    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }
    
    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

	// Verifica se a lista está vazia
    public boolean estaVazia() {
        return inicio == null;
    }

    // Insere uma nova peça na lista
    public void inserir(Peca novo) {
        No novoNo = new No(); // Cria um novo nó para a nova peça
        novoNo.peca = novo; // Atribui a nova peça ao nó

        if (estaVazia()) { // Se a lista está vazia
            inicio = novoNo; // O novo nó é tanto o início quanto o último da lista
            ultimo = novoNo;
        } else { // Se a lista já possui elementos
            ultimo.proximo = novoNo; // O próximo nó do último nó se torna o novo nó
            novoNo.anterior = ultimo; // O nó anterior do novo nó é o antigo último nó
            ultimo = novoNo; // O novo nó agora é o último nó da lista
        }
    }
    
    public void inserirNoComeco(Peca peca) {
        No noDaVez = new No();
        noDaVez.peca = peca;
        if (inicio == null) {
            inicio = noDaVez;
            ultimo = noDaVez;
        } else {
            noDaVez.proximo = inicio;
            inicio.anterior = noDaVez;
            inicio = noDaVez;
        }
        tamanho++;
    }
    
    public void removerPeca(Peca pecaRemover) {
        No atual = inicio;
        while (atual != null) {
            if (atual.peca.equals(pecaRemover)) { // Verifica se a peça atual é a que queremos remover
                if (atual == inicio) {
                    inicio = inicio.proximo; // Se a peça a ser removida é a primeira da lista
                    if (inicio != null) {
                        inicio.anterior = null;
                    }
                } else if (atual == ultimo) {
                    ultimo = ultimo.anterior; // Se a peça a ser removida é a última da lista
                    if (ultimo != null) {
                        ultimo.proximo = null;
                    }
                } else {
                    atual.anterior.proximo = atual.proximo; // Se a peça a ser removida está no meio da lista
                    atual.proximo.anterior = atual.anterior;
                }
                return; // Sai do método após remover a peça
            }
            atual = atual.proximo; // Move para o próximo nó
        }
    }
    
    public void Imprimir() {
    	Outputs otp = new Outputs();
    	otp.imprimirLista(inicio);
    }
}