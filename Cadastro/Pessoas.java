package Cadastro.Pessoas;

public abstract class   Pessoas  {
    //Superclasse - Atributos genericos
      String nome;
      String nCpf;
     
      //Metodos - gets e sets
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getnCpf() {
        return nCpf;
    }
    public void setnCpf(String nCpf) {
        this.nCpf = nCpf;
    }
    


        
    }
