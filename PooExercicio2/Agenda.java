package PooExercicio2;

public class Agenda {
    String Nome;
    int idade;
    double altura;
    //contrutor default
    //sets e gets
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
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
