package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        // digitação de senhas
        boolean login = true;
        while (login) {
            String nomeUsuario = JOptionPane.showInputDialog("Informe nome de usuario");
            String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento [dd/mm/aa/]");
            dataNascimento = dataNascimento.replace("/", "");
            String senhaDigitada = JOptionPane.showInputDialog("Informe uma Senha de 6 Digitos");
            try {
                if (nomeUsuario.equals(senhaDigitada)) {
                    throw new Exception("Senha igual ao nome de usuário");
                }
                if (senhaDigitada.equals(dataNascimento )) {
                    throw new Exception("Senha igual a data de nascimento");
                } else if (senhaDigitada.length() != 6) {
                    throw new Exception("A senha deve conter 6 digitos");
                }
             else if (isSequencial(senhaDigitada)) {
                throw new SenhaInvalidaException("Senha não pode ser uma sequência numérica");
            }

                JOptionPane.showMessageDialog(null, "Login bem sucedido!");
                login = false; // Encerra o loop
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.CLOSED_OPTION);
            }
        }
    }
  // Função para verificar se a senha é uma sequência numérica
    private static boolean isSequencial(String senha) {
        for (int i = 0; i < senha.length() - 1; i++) {
            char currentDigit = senha.charAt(i);
            char nextDigit = senha.charAt(i + 1);

            if (nextDigit != currentDigit + 1) {
                return false;
            }
        }
        return true;
    
    }
}

// Classe para exceção personalizada
class SenhaInvalidaException extends Exception {
    public SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
