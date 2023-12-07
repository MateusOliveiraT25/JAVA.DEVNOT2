package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Clientes;

public class ClientesControl {
    // Atributos
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodos();

        // Obtém os clientes atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada cliente como uma nova linha na tabela Swing
            tableModel.addRow(new Object[]{cliente.getNome(), cliente.getCpf()});
        }
    }

    public void cadastrarUsuario(String nome, String cpf) {
        boolean cadastroSucesso = new ClientesDAO().cadastrarUsuario(nome, cpf);

        if (cadastroSucesso) {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            // Adicione aqui qualquer lógica adicional após o cadastro do usuário
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário. Verifique os dados e tente novamente.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        }

        // Atualiza a tabela de exibição após o cadastro do usuário
        atualizarTabela();
    }
  // Método para obter um cliente por seu CPF
  public Clientes obterClientePorCPF(String cpf) {
    return new ClientesDAO().obterClientePorCpf(cpf);
}


    // Método para atualizar os dados de um cliente no banco de dados
    public void atualizar(String nome, String cpf) {
        new ClientesDAO().atualizar(nome, cpf);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um cliente do banco de dados
    public void apagar(String cpf) {
        new ClientesDAO().apagar(cpf);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão

        // Cria o banco de dados caso não tenha sido criado
        new ClientesDAO().criaTabela();
        // Incluindo elementos do banco na criação do painel
        atualizarTabela();
    }

    public boolean cadastrar(String text, String text2, String string, String string2, String string3) {
        return false;
    }
}
