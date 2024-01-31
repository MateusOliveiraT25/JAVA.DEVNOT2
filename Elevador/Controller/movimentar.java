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

    private int obterAndarDesejado() {
        try {
            String andarDestinoStr = JOptionPane.showInputDialog("Informe o andar desejado:");
            if (andarDestinoStr == null) {
                // Usuário clicou em Cancelar ou fechou a janela
                return 0;  // Andar inválido, tratado como o térreo
            }

            return Integer.parseInt(andarDestinoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o andar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;  // Andar inválido, tratado como o térreo
        }
    }

  
}
