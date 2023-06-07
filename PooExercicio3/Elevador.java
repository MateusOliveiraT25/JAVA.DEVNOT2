package PooExercicio3;

public class Elevador {
    //atributos
    int qtdPessoasAtual;
    int qtdMaxPessoas;
    int nMaxAndares;
    int andarAtual;
    //métodos
    //construtor
    public Elevador(int qtdMaxPessoas, int nMaxAndares) {
        this.qtdMaxPessoas = qtdMaxPessoas;
        this.nMaxAndares = nMaxAndares;
    }
    //set get
    public int getQtdPessoasAtual() {
        return qtdPessoasAtual;
    }
    public void setQtdPessoasAtual(int qtdPessoasAtual) {
        this.qtdPessoasAtual = qtdPessoasAtual;
    }
    public int getAndarAtual() {
        return andarAtual;
    }
    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }
    //métodos próprios
    //inicializa
    public void inicializa() {
        andarAtual = 0;
        qtdPessoasAtual = 0;
    }
    //entrar
    public int entrar(){
        if(qtdPessoasAtual<qtdMaxPessoas){
        qtdPessoasAtual++;
        } else{
            System.out.println("Não Vai Entrar +Ninguém");
        }
        return qtdPessoasAtual;
    }
    //sair
    public int sair(){
        if(qtdPessoasAtual>0){
        qtdPessoasAtual--;
        } else{
            System.out.println("Não tem ninguém para sair");
        }
        return qtdPessoasAtual;
    }
    //subir
    public int subir(int nAndares){
        if(andarAtual+nAndares <= nMaxAndares){
            andarAtual+=nAndares;
        }else{
            System.out.println("Informe um nº válido");
        }
        return andarAtual;
    }
    //descer
    public int descer(int nAndares){
        if(andarAtual-nAndares >= 0){
            andarAtual-=nAndares;
        }else{
            System.out.println("Informe um nº válido");
        }
        return andarAtual;
    }

    
    
}
