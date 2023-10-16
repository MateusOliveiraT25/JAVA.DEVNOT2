import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class TodoList extends JFrame {
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;

    public TodoList() {
        super("TodoListApp");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(480, 400);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[]{"Todas", "Ativas", "Concluídas"});
        clearCompletedButton = new JButton("Limpar Concluídas");

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        taskList.setDropMode(DropMode.ON);
        taskList.setTransferHandler(new TaskTransferHandler());

        deleteButton.setTransferHandler(new TaskTransferHandler());
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TransferHandler handler = deleteButton.getTransferHandler();
                handler.exportAsDrag(deleteButton, e, TransferHandler.COPY);
            }
        });
        
addButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        addTask();
    }
});
        
        markDoneButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                markTaskDone();
            }
        });

        filterComboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                filterTasks();
            }
        });

        clearCompletedButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clearCompletedTasks();
            }
        });

        this.add(mainPanel);
    }

    private void deleteSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Object[] options = {"Sim", "Não"};
            int choice = JOptionPane.showOptionDialog(this,
                    "Você tem certeza que deseja excluir esta tarefa?",
                    "Confirmação de Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == 0) {
                tasks.remove(selectedIndex);
                updateTaskList();
                JOptionPane.showMessageDialog(this, "Tarefa excluída com sucesso!");
            } else {
                // Operação de Não
            }
        }
    }

    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    private void markTaskDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            task.stopTimer();
            updateTaskList();
        }
    }

    private void filterTasks() {
        String filter = (String) filterComboBox.getSelectedItem();
        listModel.clear();
        for (Task task : tasks) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !task.isDone()) ||
                    (filter.equals("Concluídas") && task.isDone())) {
                listModel.addElement(task.getDescription());
            }
        }
    }

    private void clearCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        tasks.removeAll(completedTasks);
        updateTaskList();
    }

    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task.getDescription() + (task.isDone() ? " (Concluída)" : ""));
        }
    }

    private class Task {
        private String description;
        private boolean done;
        private Timer timer;
        private int elapsedTime;

        public Task(String description) {
            this.description = description;
            this.done = false;
            this.elapsedTime = 0;

            this.timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    elapsedTime++;
                    System.out.println("Tempo decorrido para a tarefa '" + description + "': " + elapsedTime + " segundos");
                }
            });
        }

        public void startTimer() {
            timer.start();
        }

        public void stopTimer() {
            timer.stop();
        }

        public String getDescription() {
            return description;
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }

    private static class TaskTransferable implements Transferable {
        static final DataFlavor TASK_FLAVOR = new DataFlavor(Task.class, "Task");
        private Task task;

        public TaskTransferable(Task task) {
            this.task = task;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{TASK_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(TASK_FLAVOR);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) {
            if (isDataFlavorSupported(flavor)) {
                return task;
            }
            return null;
        }
    }

    public void run() {
// Exibe a janela
this.setVisible(true);
    }
}
