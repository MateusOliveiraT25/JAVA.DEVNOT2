import javax.swing.*;
    private static void criarGUI() {
        JFrame frame = new JFrame("Aplicação com Abas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Adicione as abas aqui
        tabbedPane.addTab("Calculadora", new Calculadora());
        tabbedPane.addTab("Calculadora de Custo de Viagem", new CalculadoraCustoViagem());
        tabbedPane.addTab("Calculadora de IMC", new FlowLayoutExemplo());

        frame.add(tabbedPane);

        frame.setVisible(true);
    }
}
