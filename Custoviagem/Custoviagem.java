
/**
 * CustoViagem
 */
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Custoviagem {

    public static void main(String[] args) {
        // Valores da viagem
        int distanciaPercorrida = Integer.parseInt(JOptionPane.showInputDialog("Digite a distância percorrida (em km):"));
        double consumoTransporte = Double.parseDouble(JOptionPane.showInputDialog("Digite o consumo do transporte (em km/l):"));
        double precoCombustivelPorLitro = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do combustível (em R$/litro):"));

        // Cálculo do custo total da viagem
        double quantidadeLitrosCombustivel = distanciaPercorrida / consumoTransporte;
        double custoTotal = quantidadeLitrosCombustivel * precoCombustivelPorLitro;

        // Formatação do valor do custo total da viagem
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String custoFormatado = "R$" + df.format(custoTotal);

        // Mensagem com o resultado
        String mensagem = "Distância percorrida: " + distanciaPercorrida + " km\n"
                + "Consumo do transporte: " + consumoTransporte + " km/l\n"
                + "Preço do combustível: R$" + precoCombustivelPorLitro + " por litro\n"
                + "Quantidade de litros de combustível: " + df.format(quantidadeLitrosCombustivel) + " litros\n"
                + "Custo total da viagem: " + custoFormatado;

        JOptionPane.showMessageDialog(null, mensagem, "Resultado da Viagem", JOptionPane.INFORMATION_MESSAGE);
    }
}
