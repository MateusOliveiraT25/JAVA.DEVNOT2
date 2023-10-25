<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.TransferHandler;
import javax.swing.JFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.awt.Color;

public class TodoList extends JFrame {
    // Atributos
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
    private JLabel timerLabel;
    private Timer timer;

    // Construtor
    public TodoList() {
        // Configuração da janela
        super("TodoListApp");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(480, 400);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(TodoList.this, "Janela aberta!");
            }

            public void windowClosing(WindowEvent e) {
                Object[] options = { "Sim", "Não" };
                int choice = JOptionPane.showOptionDialog(TodoList.this,
                        "Deseja Fechar a Janela?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (choice == 0) { // 0 representa "Sim" no array
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                } else if (choice == 1) {
                    // Não faz nada, apenas fecha o diálogo de confirmação
                }

            }

            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(TodoList.this, "Janela fechada!");
            }
        });
        // Adicione o ComponentListener ao JFrame
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // O código a ser executado quando a janela for redimensionada
                int novaLargura = getWidth();
                int novaAltura = getHeight();
                System.out.println("Janela redimensionada para " + novaLargura + "x" + novaAltura);
            }
        });

        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        timerLabel = new JLabel("Tempo decorrido: 0 segundos");
        mainPanel.add(timerLabel, BorderLayout.SOUTH);
        // Alterar as cores dos botões
        addButton.setBackground(Color.GREEN);
        deleteButton.setBackground(Color.RED);
        markDoneButton.setBackground(Color.BLUE);
        clearCompletedButton.setBackground(Color.ORANGE);
        // Alterar a cor de fundo da lista
        taskList.setBackground(Color.WHITE);
        // Alterar a cor de fundo do painel principal
        mainPanel.setBackground(Color.GRAY);

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);

        // Configuração do MouseListener e KeyListener para o botão "Excluir"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedTask();
            }
        });
        deleteButton.setForeground(Color.WHITE); // Define a cor do texto como branco

        // Configuração do InputMap e ActionMap para o botão "Excluir" e a tecla
        // "Delete"
        InputMap inputMap = deleteButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = deleteButton.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "deleteTask");
        actionMap.put("deleteTask", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedTask();
            }
        }); // Adiciona o ActionListener para o botão "Adicionar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        // InputMap: Mapeia eventos de entrada (teclas, etc.) para nomes de ações.
        // ActionMap: Mapeia nomes de ações para objetos de ação reais.
        // Configuração do InputMap e ActionMap para o botão "Adicionar" e a tecla Enter
        InputMap addInputMap = addButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        ActionMap addActionMap = addButton.getActionMap();

        addInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "addTask");
        addActionMap.put("addTask", new AbstractAction() {
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
        markDoneButton.setForeground(Color.WHITE); // Define a cor do texto como branco
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
    }

    // Método para excluir a tarefa selecionada
    private void deleteSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Object[] options = { "Sim", "Não" };
            int choice = JOptionPane.showOptionDialog(this,
                    "Você tem certeza que deseja excluir esta tarefa?",
                    "Confirmação de Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == 0) { // 0 representa "Sim" no array
                tasks.remove(selectedIndex);
                updateTaskList();
                JOptionPane.showMessageDialog(this, "Tarefa excluída com sucesso!");
            } else {

            }
        }
    }

    // Método para adicionar uma nova tarefa
    // Método para adicionar uma nova tarefa
    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription, this); // Passe a referência para a instância de TodoList
            newTask.startTimer(); // Inicie o timer
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    // Método para marcar uma tarefa como concluída
    private void markTaskDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    // Método para filtrar as tarefas com base na seleção do JComboBox
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

    // Método para limpar as tarefas concluídas da lista
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

    // Método para atualizar a lista de tarefas na GUI
    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            String taskDescription = task.getDescription();
            if (task.isDone()) {
                taskDescription += " ";
            }
            listModel.addElement(taskDescription);
        }
    }

    // Classe interna Task com timer
    public class Task {
        private String description;
        private boolean done;
        private Timer timer;
        private int elapsedTime; // em segundos
        private TodoList todoList; // Referência para a instância de TodoList

        public Task(String description, TodoList todoList) {
            this.description = description;
            this.done = false; // Por padrão, a tarefa não está concluída
            this.elapsedTime = 0;
            this.todoList = todoList; // Inicializa a referência

            // Inicializa o timer com um ActionListener
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Atualize o tempo decorrido na instância de TodoList
                    todoList.updateTimerLabel(description, elapsedTime);
                    elapsedTime++;
                }
            });
            timer.start(); // Inicie o timer
        }

        public void startTimer() {
            timer.start();
        }

        public void stopTimer() {
            timer.stop();
        }

        public String getDescription() {
            if (done) {
                return description + " (Concluída)";
            } else {
                return description;
            }
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }

    public void updateTimerLabel(String description, int elapsedTime) {
        // Atualize a label timerLabel com a descrição e o tempo decorrido
        timerLabel.setText("Tempo decorrido para a tarefa '" + description + "': " + elapsedTime + " segundos");
    }

    // Classe principal para representar uma tarefa
    private static class TaskTransferable {
        static final DataFlavor TASK_FLAVOR = new DataFlavor(Task.class, "Task");
    }

    // Método principal para executar a aplicação
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.setVisible(true);
    }

    // TransferHandler para a JList
    private class TaskTransferHandler extends TransferHandler {
        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(TaskTransferable.TASK_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            Transferable transferable = support.getTransferable();
            try {
                Task task = (Task) transferable.getTransferData(TaskTransferable.TASK_FLAVOR);
                tasks.add(task);
                updateTaskList();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }

    }

    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

}
=======
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.TransferHandler;

public class TodoList extends JFrame {
    // Atributos
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
    private JLabel timerLabel;
    private Timer timer;

    // Construtor
    public TodoList() {
        // Configuração da janela
        super("TodoListApp");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setSize(480, 400);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                JOptionPane.showMessageDialog(TodoList.this, "Janela aberta!");
            }

            public void windowClosing(WindowEvent e) {
                Object[] options = { "Sim", "Não" };
                int choice = JOptionPane.showOptionDialog(TodoList.this,
                        "Deseja Fechar a Janela?",
                        "Confirmação",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (choice == 0) { // 0 representa "Sim" no array
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                } else if (choice == 1) {
                    // Não faz nada, apenas fecha o diálogo de confirmação
                }

            }

            @Override
            public void windowClosed(WindowEvent e) {
                JOptionPane.showMessageDialog(TodoList.this, "Janela fechada!");
            }
        });
        // Adicione o ComponentListener ao JFrame
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // O código a ser executado quando a janela for redimensionada
                int novaLargura = getWidth();
                int novaAltura = getHeight();
                System.out.println("Janela redimensionada para " + novaLargura + "x" + novaAltura);
            }
        });

        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Adicione suporte para arrastar e soltar
        TaskTransferHandler transferHandler = new TaskTransferHandler();
        taskList.setTransferHandler(transferHandler);
        taskList.setDropMode(DropMode.INSERT);

        // Inicializa campos de entrada, botões e JComboBox
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");

        timerLabel = new JLabel("Tempo decorrido: 0 segundos");
        mainPanel.add(timerLabel, BorderLayout.SOUTH);

        // Alterar as cores dos botões
        addButton.setBackground(Color.GREEN);
        deleteButton.setBackground(Color.RED);
        markDoneButton.setBackground(Color.BLUE);
        clearCompletedButton.setBackground(Color.ORANGE);
        // Alterar a cor de fundo da lista
        taskList.setBackground(Color.WHITE);
        // Alterar a cor de fundo do painel principal
        mainPanel.setBackground(Color.GRAY);

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);

        // Configuração do MouseListener e KeyListener para o botão "Excluir"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedTask();
            }
        });
        deleteButton.setForeground(Color.WHITE);  // Define a cor do texto como branco

        // Configuração do InputMap e ActionMap para o botão "Excluir" e a tecla "Delete"
        InputMap inputMap = deleteButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = deleteButton.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "deleteTask");
        actionMap.put("deleteTask", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedTask();
            }
        });

        // Adiciona o ActionListener para o botão "Adicionar"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        // InputMap: Mapeia eventos de entrada (teclas, etc.) para nomes de ações.
        // ActionMap: Mapeia nomes de ações para objetos de ação reais.
        // Configuração do InputMap e ActionMap para o botão "Adicionar" e a tecla Enter
        InputMap addInputMap = addButton.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW);
        ActionMap addActionMap = addButton.getActionMap();

        addInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "addTask");
        addActionMap.put("addTask", new AbstractAction() {
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
        markDoneButton.setForeground(Color.WHITE);  // Define a cor do texto como branco

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
    }

    // Método para excluir a tarefa selecionada
    private void deleteSelectedTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Object[] options = { "Sim", "Não" };
            int choice = JOptionPane.showOptionDialog(this,
                    "Você tem certeza que deseja excluir esta tarefa?",
                    "Confirmação de Exclusão",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == 0) { // 0 representa "Sim" no array
                tasks.remove(selectedIndex);
                updateTaskList();
                JOptionPane.showMessageDialog(this, "Tarefa excluída com sucesso!");
            }
        }
    }

    // Método para adicionar uma nova tarefa
    private void addTask() {
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription, this); // Passe a referência para a instância de TodoList
            newTask.startTimer(); // Inicie o timer
            tasks.add(newTask);
            updateTaskList();
            taskInputField.setText("");
        }
    }

    // Método para marcar uma tarefa como concluída
    private void markTaskDone() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
            Task task = tasks.get(selectedIndex);
            task.setDone(true);
            updateTaskList();
        }
    }

    // Método para filtrar as tarefas com base na seleção do JComboBox
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

    // Método para limpar as tarefas concluídas da lista
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

    // Método para atualizar a lista de tarefas na GUI
    private void updateTaskList() {
        listModel.clear();
        for (Task task : tasks) {
            String taskDescription = task.getDescription();
            if (task.isDone()) {
                taskDescription += " ";
            }
            listModel.addElement(taskDescription);
        }
    }

    // Classe interna Task com timer
    public class Task {
        private String description;
        private boolean done;
        private Timer timer;
        private int elapsedTime; // em segundos
        private TodoList todoList; // Referência para a instância de TodoList

        public Task(String description, TodoList todoList) {
            this.description = description;
            this.done = false; // Por padrão, a tarefa não está concluída
            this.elapsedTime = 0;
            this.todoList = todoList; // Inicializa a referência

            // Inicializa o timer com um ActionListener
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Atualize o tempo decorrido na instância de TodoList
                    todoList.updateTimerLabel(description, elapsedTime);
                    elapsedTime++;
                }
            });
            timer.start(); // Inicie o timer
        }

        public void startTimer() {
            timer.start();
        }

        public void stopTimer() {
            timer.stop();
        }

        public String getDescription() {
            if (done) {
                return description + " (Concluída)";
            } else {
                return description;
            }
        }

        public boolean isDone() {
            return done;
        }

        public void setDone(boolean done) {
            this.done = done;
        }
    }

    public void updateTimerLabel(String description, int elapsedTime) {
        // Atualize a label timerLabel com a descrição e o tempo decorrido
        timerLabel.setText("Tempo decorrido para a tarefa '" + description + "': " + elapsedTime + " segundos");
    }

    // Classe Transferable para a tarefa
    private class TransferableTask implements Transferable {
        public static final DataFlavor TASK_FLAVOR = new DataFlavor(Task.class, "Task");
        private Task task;

        public TransferableTask(Task task) {
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
            return task;
        }
    }

    // TransferHandler para a JList
    private class TaskTransferHandler extends TransferHandler {
        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(TransferableTask.TASK_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }

            Transferable transferable = support.getTransferable();
            try {
                Task task = (Task) transferable.getTransferData(TransferableTask.TASK_FLAVOR);
                tasks.add(task);
                updateTaskList();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }
    }

       public void run() {
        // Exibe a janela
        this.setVisible(true);
    }
}
>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348
