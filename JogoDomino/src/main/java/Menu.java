public class Menu {
    Outputs outputs = new Outputs();
    Inputs inputs = new Inputs();

    public int ApresentarMenu(){
        outputs.exibirMenu();
        return inputs.LerOpcao();
    }

    public int SolicitarPecaHumano(){
        outputs.SolicitarPecaHumano();
        return inputs.LerOpcao();
    }

}