package POOHeranca.Pessoas;

public abstract class   Pessoas  {
    //Superclasse - Atributos genericos
      String nome;
      String endereco;
      String nCpf;
      int idade;
      //Metodos - gets e sets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getnCpf() {
        return nCpf;
    }
    public void setnCpf(String nCpf) {
        this.nCpf = nCpf;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
      


        
    }

