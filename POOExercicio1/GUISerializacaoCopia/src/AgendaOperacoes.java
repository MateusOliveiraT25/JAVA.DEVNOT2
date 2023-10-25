
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AgendaOperacoes {
    private List<AgendaItem> agenda;
    private DefaultTableModel tableModel;
    private JTable table;

    public AgendaOperacoes(List<AgendaItem> agenda, DefaultTableModel tableModel, JTable table) {
        this.agenda = agenda;
        this.tableModel = tableModel;
        this.table = table;
    }

    public void agendarEvento(String dia, String hora, String usuario, String descricao) {
        AgendaItem agendaItem = new AgendaItem(dia, hora,usuario, descricao);
        agenda.add(agendaItem);
        tableModel.addRow(new Object[]{dia, hora,usuario, descricao});
    }

    public void atualizarEvento(int rowIndex, String dia, String hora, String usuario, String descricao) {
        if (rowIndex >= 0 && rowIndex < agenda.size()) {
            AgendaItem agendaItem = agenda.get(rowIndex);
            agendaItem.setDia(dia);
            agendaItem.setHora(hora);
             agendaItem.setUsuario(usuario);
            agendaItem.setDescricao(descricao);
             
            tableModel.setValueAt(dia, rowIndex, 0);
            tableModel.setValueAt(hora, rowIndex, 1);
             tableModel.setValueAt(usuario, rowIndex, 2);
            tableModel.setValueAt(descricao, rowIndex, 3);
        }
    }

    public void apagarEvento(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < agenda.size()) {
            agenda.remove(rowIndex);
            tableModel.removeRow(rowIndex);
        }
    }

    public void apagarTodosEventos() {
        agenda.clear();
        tableModel.setRowCount(0);
    }

    public void salvarAgenda(String fileName) {
        Serializacao.serializarAgenda(agenda, fileName);
    }

    public void atualizarEvento(int linhaSelecionada, String text, String text2, String text3, String text4,String text5) {
    }
}
