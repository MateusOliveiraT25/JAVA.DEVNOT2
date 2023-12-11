package Controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Clientes;

public class ClientesControl {
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
        // Inicialize o tableModel se for nulo
        if (this.tableModel == null) {
            this.tableModel = new DefaultTableModel();
            // Adicione as colunas necessárias ao tableModel, se necessário
            this.tableModel.addColumn("Nome");
            this.tableModel.addColumn("CPF");
        }
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        clientes = new ClientesDAO().listarTodos();
        for (Clientes cliente : clientes) {
            tableModel.addRow(new Object[]{cliente.getNome(), cliente.getCpf()});
        }
    }

    public void cadastrarUsuario(String nome, String cpf) {
        boolean cadastroSucesso = new ClientesDAO().cadastrarUsuario(nome, cpf);

        if (cadastroSucesso) {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar usuário. Verifique os dados e tente novamente.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
        }

        atualizarTabela();
    }

    public Clientes obterClientePorCPF(String cpf) {
        try {
            return new ClientesDAO().obterClientePorCpf(cpf);
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter cliente por CPF: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void atualizarCliente(String nome, String cpf) {
        new ClientesDAO().atualizar(nome, cpf);
        atualizarTabela();
    }

    public void apagarCliente(String cpf) {
        new ClientesDAO().apagar(cpf);
        atualizarTabela();
    }

    public void cadastrarUsuario() {
    }
}
