<<<<<<< HEAD
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

public class CadastroUsuarios extends JPanel {
    private JTextField inputNome;
    private JTextField inputIdade;
    private DefaultTableModel tableModel;
    private JTable table;

    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;

    public CadastroUsuarios() {
        
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Idade");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        inputNome = new JTextField(20);
        inputIdade = new JTextField(5);
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar Todos");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Idade:"));
        inputPanel.add(inputIdade);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        //deserialização quando abre o app
        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt");
            atualizarTabela();
        }
        //tratamentos de eventos
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputIdade.setText(table.getValueAt(linhaSelecionada, 1).toString());

                }
            }
        });
        OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrarUsuario(inputNome.getText(), inputIdade.getText());
                inputNome.setText("");
                inputIdade.setText("");
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuario(linhaSelecionada, inputNome.getText(),

                        inputIdade.getText());

            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });
        apagarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarTodosUsuarios();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuarios();
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
        }
    }

}
=======
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class CadastroUsuarios extends JFrame{
    private JTextField inputNome;
private JTextField inputIdade;
private DefaultTableModel tableModel;
private JTable table;
private List<Usuario> usuarios = new ArrayList<>();
private int linhaSelecionada = -1;
//metodos
public CadastroUsuarios() {
setTitle("Cadastro de Usuários");
setSize(600, 300);
setDefaultCloseOperation(2);
setLocationRelativeTo(null);
tableModel = new DefaultTableModel();
tableModel.addColumn("Nome");
tableModel.addColumn("Idade");
table = new JTable(tableModel);
JScrollPane scrollPane = new JScrollPane(table);
inputNome = new JTextField(20);
inputIdade = new JTextField(5);
JButton cadastrarButton = new JButton("Cadastrar");
JButton atualizarButton = new JButton("Atualizar");
JButton apagarButton = new JButton("Apagar");
JButton apagarTodosButton = new JButton("Apagar Todos");
JButton salvarButton = new JButton("Salvar");
JPanel inputPanel = new JPanel();
inputPanel.add(new JLabel("Nome:"));
inputPanel.add(inputNome);
inputPanel.add(new JLabel("Idade:"));
inputPanel.add(inputIdade);
inputPanel.add(cadastrarButton);
inputPanel.add(atualizarButton);
inputPanel.add(apagarButton);
inputPanel.add(apagarTodosButton);
inputPanel.add(salvarButton);
setLayout(new BorderLayout());
add(inputPanel, BorderLayout.NORTH);
add(scrollPane, BorderLayout.CENTER);

class OperacoesUsuarios {
private List<Usuario> usuarios;
private DefaultTableModel tableModel;
private JTable table;
public OperacoesUsuarios(List<Usuario> usuarios, DefaultTableModel tableModel, JTable
table) {
this.usuarios = usuarios;
this.tableModel = tableModel;
this.table = table;
}
public void cadastrarUsuario(String nome, String idade) {
int idadeInt = Integer.parseInt(idade);
Usuario usuario = new Usuario(nome, idadeInt);
usuarios.add(usuario);
atualizarTabela();
}
public void atualizarUsuario(int linhaSelecionada, String nome, String idade) {
if (linhaSelecionada != -1) {
int idadeInt = Integer.parseInt(idade);
Usuario usuario = new Usuario(nome, idadeInt);
usuarios.set(linhaSelecionada, usuario);
atualizarTabela();
}
}
public void apagarUsuario(int linhaSelecionada) {
if (linhaSelecionada != -1) {
usuarios.remove(linhaSelecionada);
atualizarTabela();
}
}
public void apagarTodosUsuarios() {
usuarios.clear();
atualizarTabela();
}
public void salvarUsuarios() {
Serializacao.serializar("dados.txt", usuarios);
}

private void atualizarTabela() {
tableModel.setRowCount(0);
for (Usuario usuario : usuarios) {
tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
}
}
}
File arquivo = new File("dados.txt");
if (arquivo.exists()) {
usuarios = Serializacao.deserializar("dados.txt");
atualizarTabela();
}
table.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent evt) {
linhaSelecionada = table.rowAtPoint(evt.getPoint());
if (linhaSelecionada != -1) {
inputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
inputIdade.setText(table.getValueAt(linhaSelecionada, 1).toString());

}
}
});
OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);
cadastrarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.cadastrarUsuario(inputNome.getText(), inputIdade.getText());
inputNome.setText("");
inputIdade.setText("");
}
});
atualizarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.atualizarUsuario(linhaSelecionada, inputNome.getText(),

inputIdade.getText());

}
});
apagarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.apagarUsuario(linhaSelecionada);
}
});
apagarTodosButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.apagarTodosUsuarios();
}
});
salvarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.salvarUsuarios();
}
});
}
private void atualizarTabela() {
tableModel.setRowCount(0);
for (Usuario usuario : usuarios) {
tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
}
}
public void run(){
    pack();
    setVisible(true);
}
}

>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348
