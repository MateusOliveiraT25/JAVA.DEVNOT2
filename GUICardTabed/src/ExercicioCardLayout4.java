<<<<<<< HEAD
/*import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class ChartWithTabs extends JFrame {

    public ChartWithTabs(String title) {
        super(title);

        // Criação do JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Criação do gráfico de barras e sua aba
        CategoryDataset barDataset = createBarDataset();
        JFreeChart barChart = ChartFactory.createBarChart(
                "Gráfico de Barras",
                "Categorias",
                "Valores",
                barDataset
        );
        ChartPanel barChartPanel = new ChartPanel(barChart);
        tabbedPane.addTab("Gráfico de Barras", barChartPanel);

        // Criação do gráfico de pizza e sua aba
        DefaultPieDataset pieDataset = createPieDataset();
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Gráfico de Pizza",
                pieDataset,
                true, // Lendas
                true,
                false
        );
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        tabbedPane.addTab("Gráfico de Pizza", pieChartPanel);

        // Adição do JTabbedPane ao JFrame
        add(tabbedPane);

        // Configurações da janela
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private CategoryDataset createBarDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, "Série1", "Categoria1");
        dataset.addValue(4.0, "Série1", "Categoria2");
        dataset.addValue(3.0, "Série1", "Categoria3");
        dataset.addValue(5.0, "Série1", "Categoria4");

        return dataset;
    }

    private DefaultPieDataset createPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue("Categoria1", 1.0);
        dataset.setValue("Categoria2", 4.0);
        dataset.setValue("Categoria3", 3.0);
        dataset.setValue("Categoria4", 5.0);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChartWithTabs example = new ChartWithTabs("Gráficos com Abas");
            example.setVisible(true);
        });
    }
}

=======
/*import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class ChartWithTabs extends JFrame {

    public ChartWithTabs(String title) {
        super(title);

        // Criação do JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Criação do gráfico de barras e sua aba
        CategoryDataset barDataset = createBarDataset();
        JFreeChart barChart = ChartFactory.createBarChart(
                "Gráfico de Barras",
                "Categorias",
                "Valores",
                barDataset
        );
        ChartPanel barChartPanel = new ChartPanel(barChart);
        tabbedPane.addTab("Gráfico de Barras", barChartPanel);

        // Criação do gráfico de pizza e sua aba
        DefaultPieDataset pieDataset = createPieDataset();
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Gráfico de Pizza",
                pieDataset,
                true, // Lendas
                true,
                false
        );
        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        tabbedPane.addTab("Gráfico de Pizza", pieChartPanel);

        // Adição do JTabbedPane ao JFrame
        add(tabbedPane);

        // Configurações da janela
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private CategoryDataset createBarDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, "Série1", "Categoria1");
        dataset.addValue(4.0, "Série1", "Categoria2");
        dataset.addValue(3.0, "Série1", "Categoria3");
        dataset.addValue(5.0, "Série1", "Categoria4");

        return dataset;
    }

    private DefaultPieDataset createPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue("Categoria1", 1.0);
        dataset.setValue("Categoria2", 4.0);
        dataset.setValue("Categoria3", 3.0);
        dataset.setValue("Categoria4", 5.0);

        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChartWithTabs example = new ChartWithTabs("Gráficos com Abas");
            example.setVisible(true);
        });
    }
}

>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348
*/