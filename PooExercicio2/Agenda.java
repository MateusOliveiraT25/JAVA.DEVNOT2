package PooExercicio2;

public class Agenda {
    //atributos
    String Nome;
    int idade;
    double altura;
    //metodos
    //contrutor default / parametros
    
    //sets e gets
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public Agenda(String nome, int idade, double altura) {
        Nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
   
    public void imprimir(){
        System.out.println("Nome"+Nome);
        System.out.println("Altura"+altura);
        System.out.println("Data Nascimento" + idade);
    
       }
      
}
