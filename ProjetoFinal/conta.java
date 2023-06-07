package ProjetoFinal;

import java.util.Scanner;

public class conta {
    Scanner sc = new Scanner(System.in);
    // atributos
    int pessoaFisica;
    int pessoaJuridica;
    String cpf;
    String cnpj;
    int nConta;
    String Nome;
    int saldo;
    // métodos
    // construtor

    public conta(Scanner sc, int pessoaFisica, int pessoaJuridica, String cpf, String cnpj, int nConta, String nome,
            int saldo) {
        this.sc = sc;
        this.pessoaFisica = pessoaFisica;
        this.pessoaJuridica = pessoaJuridica;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nConta = nConta;
        Nome = nome;
        this.saldo = saldo;
    }
    // set e get
    

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(int pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public int getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(int pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }


    

    public int criarConta(){
        System.out.println("Escolha o Tipo de Conta PF(1) PJ(2)");
        int nConta = sc.nextInt();

        if(sc.nextInt() ==1);
        pessoaFisica[i+1000].setcpf(rd.nextInt())
    }}