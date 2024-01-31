package Controller;

import javax.swing.JOptionPane;

import Model.predio;
import View.PainelElevador;

public class movimentar {
    public static void main(String[] args) {
        predio predio = new predio(2, 10, 0); // Criar um prédio com 2 elevadores e 10 andares

        // Criar a instância do painel
        PainelElevador painel = new PainelElevador();

        // Ciclos do sistema (movimentação dos elevadores)
        for (int i = 0; i < 10; i++) {
            predio.atualizar();
            predio.exibirEstadoPredio();

            // Adicionar lógica para atualizar a parte gráfica
            // Aqui você deve chamar métodos do painel para atualizar o estado visual dos elevadores
            // Exemplo: painel.atualizarEstadoElevadores("Em Movimento", "Parado");

            // Aguarde por algum tempo (simulando uma pausa)
            try {
                Thread.sleep(1000); // Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


