package POOExercicio1;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args){
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Fabiana");
        pessoa1.setAltura(1.67);
        pessoa1.setDiaNascimento(28);
        pessoa1.setMêsNascimento(3);
        pessoa1.setAnoNascimento(1997);
        pessoa1.imprimir();
        System.out.println("Idade"+pessoa1.getIdade());


    }
}
