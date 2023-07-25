package Cadastro.Pessoas;

public class ContaPJ extends Pessoas {
   
    String nCnpj;
    double Endereco;

    public String getnCnpj() {
        return nCnpj;
    }

    public void setnCnpj(String nCnpj) {
        this.nCnpj = nCnpj;
    }

      public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }
}
