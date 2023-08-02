package Exception;

import javax.swing.JOptionPane;

public class ExemploTryCatch {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Calculadora: Escolhas as operações");
        boolean rodando = true;
        while (rodando)
            try {
                int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Soma\n 2-Sub\n 3-Div\n 4-Mult\n 5-Sair "));
                if (acao1 == 1) {// Soma

                    int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
                    int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));

                    Integer.parseInt(JOptionPane.showInputDialog(null, "O resultado "
                            + (numero1 + numero2)));
                }

                else if (acao1 == 2) {// Soma

                    int numero3 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
                    int numero4 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));

                    Integer.parseInt(JOptionPane.showInputDialog(null, "O resultado "
                            + (numero3 - numero4)));
                } else if (acao1 == 3) {// Soma
                    int numero5 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
                    int numero6 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));

                    Integer.parseInt(JOptionPane.showInputDialog(null, "O resultado  "
                            + (numero5 / numero6)));
                }

                else if (acao1 == 4) {// Soma
                    int numero7 = Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
                    int numero8 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));

                    Integer.parseInt(JOptionPane.showInputDialog(null, "O resultado  "
                            + (numero7 * numero8)));
                } else {
                    rodando = false;
                }

            } catch (NumberFormatException erro1) {
                JOptionPane.showMessageDialog(null, "Erro - Valor digitado não é um inteiro");
                      
            } catch (ArithmeticException erro2) {
                JOptionPane.showMessageDialog(null, "Erro - não Dividirás por Zero!!!");
                       
            } catch (Exception erro3) {
                JOptionPane.showMessageDialog(null, "Aconteceu um erro");
                       
            }finally   {

              JOptionPane.showMessageDialog(null, "Tente Novamente");
                      

    }

}
}