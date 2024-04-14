public class Mesa {
    Lista PecasHumano;
    Lista PecasComputador;
    Lista PecasJogadas;

    public Mesa(Lista PecasHumanos, Lista PecasComputador){
        PecasJogadas = new Lista();
        this.PecasHumano = PecasHumanos;
        this.PecasComputador = PecasComputador;

    }
    public void RegistrarJogada(Peca peca){
        PecasJogadas.inserir(peca);
    }
}
