
public class Outputs {
	
	public void imprimirLista(No inicio) {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.peca.toString() + " "); // Imprime a peça atual
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println(); // Pula uma linha após imprimir todas as peças
    }
    
    
}
