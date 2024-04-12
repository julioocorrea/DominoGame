public class Peca {
    private int numero1;
    private int numero2;

    // Construtor
    public Peca(int numero1, int numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    // Método para verificar se a peça é uma dupla
    public boolean ehDupla() {
        return numero1 == numero2;
    }

    // Método para verificar se um número está presente na peça
    public boolean contemNumero(int numero) {
        return numero1 == numero || numero2 == numero;
    }

    // Método para imprimir a peça de forma legível
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" -------\n");
        sb.append("| ").append(numero1);
        sb.append("     |\n");
        sb.append("|  ___  |\n");
        sb.append("|       |\n");
        sb.append("|     ").append(numero2).append(" |\n");
        sb.append(" -------\n");
        return sb.toString();
    }

    // Getters e Setters
    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
}