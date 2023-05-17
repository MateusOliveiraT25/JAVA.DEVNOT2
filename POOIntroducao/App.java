package POOIntroducao;

public class App {
    public static void main(String[] args) {
        RegistroAluno aluno1 = new RegistroAluno();//obj1
        RegistroAluno aluno2 = new RegistroAluno();//obj2
        //modificar os atributos(set)
        aluno1.setNome("Ana Clara Pereira");
        aluno1.setEndereco("Rua Dr. Trajano, 234 - Centro");
        aluno1.setIdade(21);
        aluno1.setNotaMatematica(8);
        aluno1.setNotaPortugues(6);
        aluno1.setNotaCiencias(1);
        // Acessar os atributos(get)
        System.out.println("Nome:" +aluno1.getNome());
        System.out.println("Endereço:" +aluno1.getEndereco());
        System.out.println("Idade:" +aluno1.getIdade());
        System.out.println("Media:" +aluno1.getMedia());
        

     




       

    }
}
