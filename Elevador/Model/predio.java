package Model;
import javax.swing.JOptionPane;

public class predio {
    private elevador[] elevadores;
    private int[] andares;

    public predio(int quantidadeElevadores, int numeroAndares, int numeroSubsolo) {
        int totalAndares = numeroAndares + Math.abs(numeroSubsolo); // Garante que o total de andares seja não negativo
        elevadores = new elevador[quantidadeElevadores];
        for (int i = 0; i < quantidadeElevadores; i++) {
            elevadores[i] = new elevador();
        }

        andares = new int[totalAndares];
    }

    public void chamarElevadorParaAndar() {
        // Lógica de escolher um elevador disponível (pode ser mais complexo em uma implementação real)
        int elevadorIndex = 0;

        // Solicitar ao usuário o andar desejado usando JOptionPane
        int andarDestino = obterAndarDesejado();
        
        elevadores[elevadorIndex].moverPara(andarDestino);
        andares[andarDestino] = elevadorIndex;
    }

    private int obterAndarDesejado() {
        try {
            String andarDestinoStr = JOptionPane.showInputDialog("Informe o andar desejado:");
            if (andarDestinoStr == null) {
                // Usuário clicou em Cancelar ou fechou a janela
                return 0;  // Andar inválido, tratado como o térreo
            }

            int andarDestino = Integer.parseInt(andarDestinoStr);
            return validarAndar(andarDestino);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o andar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;  // Andar inválido, tratado como o térreo
        }
    }

    private int validarAndar(int andar) {
        // Certifique-se de que o andar esteja dentro dos limites do prédio
        int totalAndares = andares.length;
        return Math.max(0, Math.min(totalAndares - 1, andar));
    }

    public void atualizar() {
        for (elevador elevador : elevadores) {
            if (elevador.isEmMovimento()) {
                // Simular movimento do elevador
                // Neste exemplo, apenas atualizamos o estado do elevador
            }
        }
    }

    public void exibirEstadoPredio() {
        System.out.println("Estado do Prédio:");

        for (int i = 0; i < andares.length; i++) {
            System.out.print("Andar " + i + ": ");
            if (andares[i] != 0) {
                System.out.print("Elevador no andar " + andares[i]);
            } else {
                System.out.print("Sem elevador");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void chamarElevadorParaAndar(int andarDestino) {
        // Lógica de escolher um elevador disponível (pode ser mais complexo em uma implementação real)
        int elevadorIndex = escolherElevadorDisponivel();
    
        elevadores[elevadorIndex].moverPara(andarDestino);
        andares[andarDestino] = elevadorIndex;
    }
    
    private int escolherElevadorDisponivel() {
        // Lógica simples: Escolhe o primeiro elevador disponível
        for (int i = 0; i < elevadores.length; i++) {
            if (!elevadores[i].isEmMovimento()) {
                return i;
            }
        }
        // Se nenhum elevador estiver disponível, escolhe o primeiro (pode ser mais elaborado em uma implementação real)
        return 0;
    }
}