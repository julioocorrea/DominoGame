import java.util.Random;

public class Jogo {

   public void IniciarJogo(){
       Menu menu = new Menu();
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
           mesa.RegistrarJogadaInicial(MaiorPeca);
           pecasHumano.removerPeca(MaiorPeca);
           JogadaDoComputador(mesa);

       }
       else if(identificador[0].equals("computador")) {
           MaiorPeca=pecasComputador.IdentificarPecaPorIndice(Integer.parseInt(identificador[1]));
           outputs.ComputadorMaiorPeca(MaiorPeca);
           mesa.RegistrarJogadaInicial(MaiorPeca);
           pecasComputador.removerPeca(MaiorPeca);
       }

       while (pecasHumano.getInicio()!=null || pecasComputador.getInicio()!=null){
           outputs.VezHumano();
           pecasHumano.Imprimir();
           int opcao= menu.ApresentarMenu();
           if(opcao == 1){
            Peca pecaSelecionada=pecasHumano.IdentificarPecaPorIndice(menu.SolicitarPecaHumano());
            Peca pecaInicio = mesa.PecasJogadas.getInicio().peca;
            Peca pecaFim = mesa.PecasJogadas.getUltimo().peca;
            if(pecaInicio.contemNumero(pecaSelecionada.getNumero2())){
                if(pecaSelecionada.getNumero2() != pecaInicio.getNumero1()){
                    int num1 = pecaSelecionada.getNumero2();
                    int num2 = pecaSelecionada.getNumero1();
                    pecaSelecionada.setNumero1(num1);
                    pecaSelecionada.setNumero2(num2);
                }
                mesa.RegistrarJogadaNum1(pecaSelecionada);

            }
            else if (pecaFim.contemNumero(pecaSelecionada.getNumero1())){
                if(pecaFim.getNumero2() != pecaSelecionada.getNumero1()){
                    int num1 = pecaSelecionada.getNumero2();
                    int num2 = pecaSelecionada.getNumero1();
                    pecaSelecionada.setNumero1(num1);
                    pecaSelecionada.setNumero2(num2);
                }
                mesa.RegistrarJogadaNum2(pecaSelecionada);

            }

            pecasHumano.removerPeca(pecaSelecionada);
            mesa.PecasJogadas.Imprimir();
            outputs.VezComputador();
            JogadaDoComputador(mesa);
           }
           else if(opcao==2){
             outputs.VezComputador();
             JogadaDoComputador(mesa);
           }

           if(!mesa.ValidarSeTemJogadasPossiveis()) {
        	   mesa.VerificarGanhador();
        	   break;
           }
           
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
   
   public void JogadaDoComputador(Mesa mesa) {
	   Outputs outputs = new Outputs();
	   No atual = mesa.PecasComputador.getInicio();
	   Peca pecaPontaCima = mesa.PecasJogadas.getInicio().peca;
	   Peca pecaPontaBaixo = mesa.PecasJogadas.getUltimo().peca;
	   
       while (atual!=null){
           if(atual.peca.getNumero1() == pecaPontaCima.getNumero1()){
        	   atual.peca.InverterPeca();
        	   mesa.RegistrarJogadaNum1(atual.peca);
        	   mesa.PecasComputador.removerPeca(atual.peca);
        	   outputs.ImprimirMesa(mesa.PecasJogadas);
        	   return;
           }
           else if (atual.peca.getNumero2() == pecaPontaCima.getNumero1()) {
        	   mesa.RegistrarJogadaNum1(atual.peca);
        	   mesa.PecasComputador.removerPeca(atual.peca);
        	   outputs.ImprimirMesa(mesa.PecasJogadas);
        	   return;
           }
           atual=atual.proximo;
       }
       
       while (atual!=null){
           if(atual.peca.getNumero1() == pecaPontaBaixo.getNumero2()){
        	   mesa.RegistrarJogadaNum2(atual.peca);
        	   mesa.PecasComputador.removerPeca(atual.peca);
        	   outputs.ImprimirMesa(mesa.PecasJogadas);
        	   return;
           }
           else if (atual.peca.getNumero2() == pecaPontaBaixo.getNumero2()) {
        	   atual.peca.InverterPeca();
        	   mesa.RegistrarJogadaNum2(atual.peca);
        	   mesa.PecasComputador.removerPeca(atual.peca);
        	   outputs.ImprimirMesa(mesa.PecasJogadas);
        	   return;
           }
           atual=atual.proximo;
       }
       
   }
}