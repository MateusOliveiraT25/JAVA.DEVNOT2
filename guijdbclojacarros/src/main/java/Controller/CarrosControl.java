package Controller;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.Carros;
public class CarrosControl {
    // Atributos
private List<Carros> carros;
private DefaultTableModel tableModel;
private JTable table;
// Construtor
public CarrosControl(List<Carros> carros, DefaultTableModel tableModel, JTable table)
{
this.carros = carros;
this.tableModel = tableModel;
this.table = table;}
// Método para atualizar a tabela de exibição com dados do banco de dados
private void atualizarTabela() {
    tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    carros = new CarrosDAO().listarTodos();
    // Obtém os carros atualizados do banco de dados
    for (Carros carro : carros) {
    // Adiciona os dados de cada carro como uma nova linha na tabela Swing
    tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),
    
    carro.getAno(), carro.getPlaca(), carro.getValor() });
    }
    }
    // Método para cadastrar um novo carro no banco de dados
    public boolean cadastrar(String marca, String modelo, int i, String placa, int
    j) {
    new CarrosDAO().cadastrar(marca, modelo, i, placa, j);
    // Chama o método de cadastro no banco de dados
    atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    return false;
}
// Método para atualizar os dados de um carro no banco de dados
public void atualizar(String marca, String modelo, int i, String placa, int
j) {
new CarrosDAO().atualizar(marca, modelo, i, placa, j);
// Chama o método de atualização no banco de dados
atualizarTabela(); // Atualiza a tabela de exibição após a atualização
}
// Método para apagar um carro do banco de dados
public void apagar(String placa) {
new CarrosDAO().apagar(placa);
// Chama o método de exclusão no banco de dados
atualizarTabela(); // Atualiza a tabela de exibição após a exclusão

//Cria o banco de dados caso não tenha sido criado
new CarrosDAO().criaTabela();
// incluindo elementos do banco na criação do painel
atualizarTabela();
}
}
