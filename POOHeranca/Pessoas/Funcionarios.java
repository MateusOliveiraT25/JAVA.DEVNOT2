package POOHeranca.Pessoas;

public class Funcionarios  extends Pessoas{
    int nCadastro;
    String setor;

    public int getnCadastro() {
        return nCadastro;
    }
    public void setnCadastro(int nCadastro) {
        this.nCadastro = nCadastro;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
}
