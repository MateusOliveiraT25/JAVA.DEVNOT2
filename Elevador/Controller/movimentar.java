package Controller;

import javax.swing.JOptionPane;

import Model.predio;

public class movimentar {
    public void run() {
        predio predio = new predio(2, 10, 0); // Criar um prédio com 2 elevadores e 10 andares

        // Chamar elevadores para andares específicos
        predio.chamarElevadorParaAndar(obterAndarDesejado());
        predio.chamarElevadorParaAndar(obterAndarDesejado());

        // Ciclos do sistema (movimentação dos elevadores)
        for (int i = 0; i < 10; i++) {
            predio.atualizar();
            predio.exibirEstadoPredio();
        }
    }
}