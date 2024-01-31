package Model;
public class elevador {
    private int andarAtual;
    private boolean emMovimento;

    public elevador() {
        this.andarAtual = 0;
        this.emMovimento = false;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public boolean isEmMovimento() {
        return emMovimento;
    }

    public void moverPara(int destino) {
        if (!emMovimento) {
            emMovimento = true;
            System.out.println("Elevador se movendo para o andar " + destino);
        }
    }

    public void pararEm(int destino) {
        if (emMovimento) {
            andarAtual = destino;
            emMovimento = false;
            System.out.println("Elevador chegou ao andar " + destino);
        }
    }
}
