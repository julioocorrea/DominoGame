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
    
    public Boolean ValidarSeTemJogadasPossiveis() {
 	   Peca pecaPontaCima = PecasJogadas.getInicio().peca;
 	   Peca pecaPontaBaixo = PecasJogadas.getUltimo().peca;
 	   No atual = PecasComputador.getInicio();
 	   
       while (atual!=null){
           if(atual.peca.getNumero1() == pecaPontaCima.getNumero1()){
        	   return true;
           }
           else if (atual.peca.getNumero2() == pecaPontaCima.getNumero1()) {
        	   return true;
           }
           atual=atual.proximo;
       }
       
       atual = PecasHumano.getInicio();
       
       while (atual!=null){
           if(atual.peca.getNumero1() == pecaPontaBaixo.getNumero2()){
        	   return true;
           }
           else if (atual.peca.getNumero2() == pecaPontaBaixo.getNumero2()) {
        	   return true;
           }
           atual=atual.proximo;
       }
       
       return false;
 	   
    }
    
    public void VerificarGanhador() {
        Outputs outputs = new Outputs();
    	if (PecasComputador.estaVazia()) {
    	       outputs.computadorVenceu();
    	}
    	else if (PecasHumano.estaVazia()) {
    		outputs.HumanoVenceu();
    	}
    	else {
    		if (PecasComputador.getTamanho() > PecasHumano.getTamanho()) {
    			outputs.HumanoVenceu();
    		}
    		else if (PecasComputador.getTamanho() < PecasHumano.getTamanho()) {
    			outputs.computadorVenceu();
    		}
    		else {
    			outputs.Empate();
    		}
    	}
    }
}