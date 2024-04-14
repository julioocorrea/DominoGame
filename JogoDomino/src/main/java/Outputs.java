
public class Outputs {
	
	public void imprimirLista(No inicio) {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.peca.toString() + " "); // Imprime a peça atual
            atual = atual.proximo; // Move para o próximo nó
        }
        System.out.println(); // Pula uma linha após imprimir todas as peças
    }
    public void MensagensIniciais(){
     System.out.println("Jogo iniciado!");
     System.out.println("Buscando jogador com a maior peça...");
    }

    public  void HumanoMaiorPeca(Peca peca){
        System.out.println("Você possuí a maior peça!");
        System.out.println("Ela será posicionada para iniciar o jogo");
        ImprimirPeca(peca);
        System.out.println("O computador fará a primeira jogada");
    }

    public void ComputadorMaiorPeca(Peca peca){
        System.out.println("O computador possui a maior peça!");
        System.out.println("Ela será posicionada para iniciar o jogo");
        ImprimirPeca(peca);
        System.out.println("Você fará a primeira jogada");
    }

    public  void ImprimirPeca(Peca peca){
        System.out.println(peca.toString());
    }
}
