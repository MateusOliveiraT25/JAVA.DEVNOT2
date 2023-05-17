package exercicioifElse;
import java.util.Scanner;
public class exercicios {
    Scanner sc = new Scanner (System.in);
    public void exercicio1(){
        System.out.println("Qual é o valor 1");
        double valor1 = sc.nextDouble();
        System.out.println("Qual é o valor 2");
        double valor2 = sc.nextDouble();
        if( valor1 > valor2){
            System.out.println("O maior valor é"+
            valor1);}
            else if (valor1<valor2){
                System.out.println("O maior valor é"+
                valor2);}
                else{
                    System.out.println("Os valores sao iguais");
                } }
                public void exercicio2(){
                    System.out.println("Qual é a data de nascimento");
                int data1  = sc.nextInt();
                int data2 = 2007;
                if( data1 <= data2) {
                    System.out.println("Poderá votar");}
                    else
                        System.out.println("Não poderá votar");
                    
                }
                public void exercicio3(){
                    System.out.println("Qual é a senha");
                    int senha = sc.nextInt();
                    int senha2 = 1234;
                    if( senha == senha2){
                        System.out.println("ACESSO PERMITIDO");}
                        else
                        System.out.println("ACESSO NEGADO");
                    }
                    public void exercicio4(){System.out.println("Quantas maçãs");
                    double maças = sc.nextDouble();
                    double preço1 = 0.30;
                    double preço2 = 0.25;
                    double preçoTotal1 = maças*preço1;
                    double preçoTotal2 = maças*preço2;
                    if( maças <= 11 ) { System.out.println ("Total é R$ " + preçoTotal1);}
                        else
                       { System.out.println("Total é R$ " + preçoTotal2);}
                    }
                 // resolução exe5 ifelse
                // para resolução do exercicios deve observar
                // as combinações possiveis entre 3 nº
                public void exercicio5() {
                    System.out.println("Informe o 1º Valor:");
                    int v1 = sc.nextInt();
                    System.out.println("Informe o 2º Valor:");
                    int v2 = sc.nextInt();
                    System.out.println("Informe o 3º Valor:");
                    int v3 = sc.nextInt();
                    // v1<v2<v3
                    if (v1 < v2 && v2 < v3) {
                        System.out.println(" A Ordem é " + v1 + ", " + v2 + ", " + v3);
                    } else if (v1 < v3 && v3 < v2) {// v1<v3<v2
                        System.out.println(" A Ordem é " + v1 + ", " + v3 + ", " + v2);
                    } else if (v2 < v1 && v1 < v3) {// v2<v1<v3
                        System.out.println(" A Ordem é " + v2 + ", " + v1 + ", " + v3);
                    } else if (v2 < v3 && v3 < v1) {// v2<v3<v1
                        System.out.println(" A Ordem é " + v2 + ", " + v3 + ", " + v1);
                    } else if (v3 < v1 && v1 < v2) { // v3<v1<v2
                        System.out.println(" A Ordem é " + v3 + ", " + v1 + ", " + v2);
                    } else {// v3<v2<v1
                        System.out.println(" A Ordem é " + v3 + ", " + v2 + ", " + v1);
                    }
                }
            
                // resolução exe6 IfElse
                public void exercicio6() {
                    System.out.println("Informe a altura");
                    double altura = sc.nextDouble();
                    System.out.println("Informe o sexo: 1- Feminino; 2-Masculino;");
                    int sexo = sc.nextInt();
                    double pesoIdeal;
                    if (sexo == 1) {// Feminino
                        pesoIdeal = 62.1 * altura - 44.7;
                    } else { // Masculino
                        pesoIdeal = 72.7 * altura - 58;
                    }
                    System.out.println("Seu peso idel é " + pesoIdeal + " Kg");
            
                }
            
                // exe7 - ler 2 notas e a frequencia de um aluno
                // calcular a média
                // se media > 50 e frequencia > 70- aluno aprovado
                public void exercicio7() {
                    System.out.println("Informe a 1ª nota do aluno:");
                    int nota1 = sc.nextInt();
                    System.out.println("informe a 2ª notado aluno:");
                    int nota2 = sc.nextInt();
                    int media = (nota1 + nota2) / 2;
                    System.out.println("a Média do aluno é " + media);
                    System.out.println("Informe a frequencia do aluno:");
                    int frequencia = sc.nextInt();
                    if (media >= 50 && frequencia >= 75) {
                        System.out.println("Aluno Aprovado");
                    } else {
                        System.out.println("Aluno Reprovado");
                    }
                }
                 // resolucao exercicio extra 1 par impar
    public void exercicio8() {
        System.out.println("Informe um nº inteiro:");
        int numero = sc.nextInt();
        // calcula o resto(operador %) da divisão por 2
        int restoDivisao2 = numero % 2;
        if (restoDivisao2 == 0) {
            System.out.println(numero + " É Par");
        } else {
            System.out.println(numero + " É Ímpar");
        }
    }

    // resolução exe extra 2 (nota digitada)
    public void exercicio9() {
        System.out.println("Informe sua nota:");
        int nota = sc.nextInt();
        if (nota >= 7) {
            System.out.println("Aluno Aprovado");
        } else if (nota >= 5) {
            System.out.println("Aluno poderá fazer a Recuperação");
        } else {
            System.out.println("Aluno Reprovado");
        }
    }

    // resolução exeExtra3 (vogal Consoante)
    public void exeExtra3() {
        System.out.println("Digite uma letra");
        String letra = sc.nextLine();
        if (letra == "a" || letra == "e" || letra == "i" || letra == "o" || letra == "u") {
            System.out.println(letra + " É vogal");
        } else {
            System.out.println(letra + " É consoante");
        }
    }

    // resolução exeExtra4 (reajuste salário)
    public void exercicio10() {
        System.out.println("Informe o salário");
        double salario = sc.nextDouble();
        if (salario <= 1280) {
            salario *= 1.20; // 20% de aumento usando uma operação de atribuição
        } else if (salario <= 1700) {
            salario *= 1.15; // 15% de aumento por operação de atribuição
        } else if (salario <= 2500) {
            salario *= 1.10; // 10% de aumento por operação de atribuição
        } else {
            salario *= 1.05; // 5% de aumennto por operação de atribuição
        }
    }

    // resolução exeExtra5 (calculo de impostos no salário)
    public void exercicio11() {
        System.out.println("Informe o Valor Recebido por Hora Trabalhada");
        double valorHora = sc.nextDouble();
        System.out.println("Informe a Quant. de Horas Trabalhadas");
        int horasTrabalhadas = sc.nextInt();
        double salarioBruto = valorHora*horasTrabalhadas;
        int taxaIR;
        if (salarioBruto<900){
            taxaIR=0;//isento IR =0
        } else if(salarioBruto<=1500){
            taxaIR=5;//IR = 5%
        } else if(salarioBruto<=2500){
            taxaIR=10;//IR = 10%
        } else{
            taxaIR = 20;//IR = 20%
        }
        double calculoIR = salarioBruto*taxaIR/100;
        double taxaINSS = salarioBruto*10/100;
        double taxaFGTS = salarioBruto*11/100;
        double taxaImpSindical = salarioBruto*3/100;
        double totalDesconto = calculoIR+taxaINSS+taxaImpSindical;
        double salarioLiquido = salarioBruto-totalDesconto;
        System.out.println("Salario Bruto = R$ "+salarioBruto);
        System.out.println("Imposto de Renda = R$ "+calculoIR);
        System.out.println("INSS = R$ "+taxaINSS);
        System.out.println("FGTS = R$ "+taxaFGTS);
        System.out.println("Taxa Sindical = R$ "+taxaImpSindical);
        System.out.println("Salario Líquido = R$ "+salarioLiquido);
    }
}
          