import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AgendaUsuarios extends JPanel {
    private JTextField inputDia;
    private JTextField inputHora;
    private JTextField inputUsuario; // Added description field
     private JTextField inputDescricao;
    private DefaultTableModel tableModel;
    private JTable table;

    private List<AgendaItem> agenda = new ArrayList<>();
    private int linhaSelecionada = -1;

    public AgendaUsuarios() {

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Dia");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Usuario"); // Added description column
        tableModel.addColumn("Descrição"); 
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        inputDia = new JTextField(8);
        inputHora = new JTextField(5);
          inputUsuario = new JTextField(15);
        inputDescricao = new JTextField(20);
         // Added description field
        JButton cadastrarButton = new JButton("Agendar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar Todos");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Dia:"));
        inputPanel.add(inputDia);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Usuario:"));
        inputPanel.add(inputUsuario);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        // Deserialization when opening the app
        File arquivo = new File("agenda.txt");
        if (arquivo.exists()) {
            agenda = Serializacao.deserializarAgenda("agenda.txt"); // Change deserialization method
            atualizarTabela();
        }
        // tratamentos de eventos 
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputDia.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputHora.setText(table.getValueAt(linhaSelecionada, 1).toString());
                     inputUsuario.setText(table.getValueAt(linhaSelecionada, 2).toString());
                    inputDescricao.setText(table.getValueAt(linhaSelecionada, 3).toString()); // Set description
                }
            }
        });
        AgendaOperacoes operacoes = new AgendaOperacoes(agenda, tableModel, table);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.agendarEvento(inputDia.getText(), inputHora.getText(),inputUsuario.getText(), inputDescricao.getText()); // Modify to add an agenda item
                inputDia.setText("");
                inputHora.setText("");
                inputUsuario.setText("");
                inputDescricao.setText(""); // Clear description field
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarEvento(linhaSelecionada, inputDia.getText(), inputHora.getText(), inputUsuario.getText(), inputDescricao.getText()); // Modify to update agenda item
            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarEvento(linhaSelecionada); // Modify to delete an agenda item
            }
        });
        apagarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarTodosEventos(); // Modify to delete all agenda items
            }
        });
      /*  salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarAgenda("agenda.txt"); // Modify to save the agenda
            }
        }); */
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (AgendaItem item : agenda) {
            tableModel.addRow(new Object[]{item.getDia(), item.getHora(), item.getDescricao()});
        }
    }
}
