import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class BarChartExample extends JFrame {

    public BarChartExample(String title) {
        super(title);

        // Criação do conjunto de dados
        CategoryDataset dataset = createDataset();

        // Criação do gráfico
        JFreeChart chart = ChartFactory.createBarChart(
                "Exemplo de Gráfico de Barras", // Título do gráfico
                "Categorias",                   // Rótulo do eixo X
                "Valores",                      // Rótulo do eixo Y
                dataset                         // Conjunto de dados
        );

        // Configuração opcional do gráfico (por exemplo, adicionar cores, legendas, etc.)

        // Criação do painel de gráfico
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(560, 370));

        // Adição do painel de gráfico ao JFrame
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Adição de dados ao conjunto de dados
        dataset.addValue(1.0, "Série1", "Categoria1");
        dataset.addValue(4.0, "Série1", "Categoria2");
        dataset.addValue(3.0, "Série1", "Categoria3");
        dataset.addValue(5.0, "Série1", "Categoria4");

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BarChartExample example = new BarChartExample("Exemplo de Gráfico de Barras");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}

