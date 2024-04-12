public class Player {
    private String nome;
    private Lista listaPecas; // Lista de peças do jogador

    // Construtor
    public Player(String nome) {
        this.nome = nome;
        this.listaPecas = new Lista(); // Inicializa a lista de peças do jogador
    }

    // Método para adicionar uma peça à lista de peças do jogador
    public void adicionarPeca(Peca peca) {
        listaPecas.inserir(peca);
    }

    // Método para imprimir as peças do jogador
    public void imprimirPecas() {
        System.out.println("Peças do jogador " + nome + ":");
        listaPecas.Imprimir();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Lista getListaPecas() {
        return listaPecas;
    }

    public void setListaPecas(Lista listaPecas) {
        this.listaPecas = listaPecas;
    }
}