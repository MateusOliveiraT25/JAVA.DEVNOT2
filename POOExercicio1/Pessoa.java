package POOExercicio1;

public class Pessoa {
    //Atributos(nome,altura,dataNascimento)
    String nome;
    double altura;
    int diaNascimento;
    int mêsNascimento;
    int anoNascimento;
    //Conrutores
    public Pessoa(String nome, double altura, int diaNascimento, int mêsNascimento, int anoNascimento) {
        this.nome = nome;
        this.altura = altura;
        this.diaNascimento = diaNascimento;
        this.mêsNascimento = mêsNascimento;
        this.anoNascimento = anoNascimento;
    }
    public Pessoa() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public int getDiaNascimento() {
        return diaNascimento;
    }
    public void setDiaNascimento(int diaNascimento) {
        this.diaNascimento = diaNascimento;
    }
    public int getMêsNascimento() {
        return mêsNascimento;
    }
    public void setMêsNascimento(int mêsNascimento) {
        this.mêsNascimento = mêsNascimento;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    
   public void imprimir(){
    System.out.println("Nome"+nome);
    System.out.println("Altura"+altura);
    System.out.println("Data Nascimento" +diaNascimento+"/"+mêsNascimento+"/"+anoNascimento);

   }
   public int getIdade(){
  
    if(diaNascimento<=30 && mêsNascimento<=5){
    int idade = 2023 - anoNascimento;
    }else{
      int  idade = 2023 - anoNascimento -1;
    }
    return  Idade();

    
   }}