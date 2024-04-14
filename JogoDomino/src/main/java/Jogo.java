import java.util.Random;

public class Jogo {

   public void IniciarJogo(){
       Outputs outputs = new Outputs();
       Lista pecasHumano = gerarPecas(14);
       Lista pecasComputador = gerarPecas(14);
       Mesa mesa = new Mesa(pecasHumano,pecasComputador);
       outputs.MensagensIniciais();
       String [] identificador = BuscarMaiorPeca(pecasHumano,pecasComputador).split(",");
       Peca MaiorPeca;
       if(identificador[0].equals("humano")){
           MaiorPeca=pecasHumano.IdentificarPecaPorIndice(Integer.parseInt(identificador[1]));
           outputs.HumanoMaiorPeca(MaiorPeca);
           mesa.RegistrarJogada(MaiorPeca);
           pecasHumano.removerPeca(MaiorPeca);

       }
       else if(identificador[0].equals("computador")) {
           MaiorPeca=pecasComputador.IdentificarPecaPorIndice(Integer.parseInt(identificador[1]));
           outputs.ComputadorMaiorPeca(MaiorPeca);
           mesa.RegistrarJogada(MaiorPeca);
           pecasComputador.removerPeca(MaiorPeca);
       }


   }

    public Lista gerarPecas(int quantidade) {
        Lista pecas = new Lista();
        Random rand = new Random();
        for (int i = 0; i < quantidade; i++) {
            int num1 = rand.nextInt(7);
            int num2 = rand.nextInt(7);
            Peca peca = new Peca(num1, num2);
            pecas.inserir(peca);
        }
        return pecas;
   }

   //Retorna uma string para conseguir mapear se a maior peça é do humano ou do PC e qual o indice dela
   public String BuscarMaiorPeca(Lista PecasHumano, Lista PecasComputador){
       No atual = PecasHumano.getInicio();
       int maiorPecaHumano = 0;
       int indiceMaiorPecaHumano=0;
       while (atual!=null){
           if(atual.peca.getNumero1()+atual.peca.getNumero2()>maiorPecaHumano){
               maiorPecaHumano=atual.peca.getNumero1()+atual.peca.getNumero2();
               indiceMaiorPecaHumano= PecasHumano.BuscarIndice(atual.peca);
           }
           atual=atual.proximo;
       }
       atual = PecasComputador.getInicio();
       int maiorPecaComputador=0;
       int indiceMaiorPecaComputador=0;
       while (atual!=null){
           if(atual.peca.getNumero1()+atual.peca.getNumero2()>maiorPecaComputador){
               maiorPecaComputador=atual.peca.getNumero1()+atual.peca.getNumero2();
               indiceMaiorPecaComputador = PecasComputador.BuscarIndice(atual.peca);
           }
           atual=atual.proximo;
       }
       if(maiorPecaComputador>maiorPecaHumano){
           return "computador," + indiceMaiorPecaComputador;
       }
       else{
           return "humano," + indiceMaiorPecaHumano;
       }
   }
}
