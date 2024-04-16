
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
    
    public void ImprimirMesa(Lista PecasJogadas){
 	   	No atual = PecasJogadas.getInicio();
	    while (atual!=null){
	    	ImprimirPeca(atual.peca);
	        atual=atual.proximo;
	    }
    }

    public void ImprimirPeca(Peca peca){
        System.out.println(peca.toString());
    }
    
    public void ImprimirPecaAoContrario(Peca peca){
        StringBuilder sb = new StringBuilder();
        sb.append(" -------\n");
        sb.append("| ").append(peca.getNumero2());
        sb.append("     |\n");
        sb.append("|  ___  |\n");
        sb.append("|       |\n");
        sb.append("|     ").append(peca.getNumero1()).append(" |\n");
        sb.append(" -------\n");
        System.out.println(sb.toString());
    }
    public void exibirMenu(){
        System.out.println("******************");
        System.out.println("*     MENU       *");
        System.out.println("******************");
        System.out.println("* 1. Jogar       *");
        System.out.println("* 2. Passar a vez*");
        System.out.println("******************");
        System.out.println("Escolha uma opção:");
    }
    public void VezHumano(){
        System.out.println("Sua vez de jogar...");
        System.out.println("Aqui estão suas peças disponíveis");
    }
    public void VezComputador(){
     System.out.println("O computador irá jogar...");
    }
    public void SolicitarPecaHumano(){
        System.out.println("Digite o indíce da peça a ser jogada");
        System.out.println("Exemplo: primeira peça da lista de peças disponiveis - indice = 0, segunda - indice = 1, etc");

    }
    public void computadorVenceu() {
		System.out.println("\n----------------------------------"
				 + "\n   O computador venceu a partida\n"
				 + "----------------------------------\n");
    }
    public void HumanoVenceu() {
		System.out.println("\n----------------------------------"
				 + "\n   Você venceu a partida\n"
				 + "----------------------------------\n");
    }
    public void Empate() {
		System.out.println("\n----------------------------------"
				 + "\n   A partida empatou\n"
				 + "----------------------------------\n");
    }
    public void PecaIncorreta(){
        System.out.println("Peça inválida! Passou a vez");
    }
}