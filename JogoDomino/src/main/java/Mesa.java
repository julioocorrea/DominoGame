public class Mesa {
    Lista PecasHumano;
    Lista PecasComputador;
    Lista PecasJogadas;

    public Mesa(Lista PecasHumanos, Lista PecasComputador){
        PecasJogadas = new Lista();
        this.PecasHumano = PecasHumanos;
        this.PecasComputador = PecasComputador;

    }
    public void RegistrarJogadaInicial(Peca peca){
        PecasJogadas.inserir(peca);
    }
    public void RegistrarJogadaNum1(Peca peca){
        PecasJogadas.inserirNoComeco(peca);
    }
    public void RegistrarJogadaNum2(Peca peca){
        PecasJogadas.inserir(peca);
    }
}