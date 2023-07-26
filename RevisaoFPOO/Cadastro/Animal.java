package RevisaoFPOO.Cadastro;
java.util.Scanner sc = new Scanner(System.in);
public abstract class Animal {
    //Atributos
    String nome;
    double peso;
    String especie;
    String proprietario;
    //Métodos
   //construtor cheio
    public Animal(String nome, double peso, String especie, String proprietario) {
        this.nome = nome;
        this.peso = peso;
        this.especie = especie;
        this.proprietario = proprietario;
    }
    // declarar construtor vazio
    public Animal()();

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(String string) {
        this.peso = string;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getProprietario() {
        return proprietario;
    }
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }
}
