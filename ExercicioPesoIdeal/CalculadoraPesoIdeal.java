package ExercicioPesoIdeal;

import java.util.Scanner;

public class CalculadoraPesoIdeal {
    Scanner sc = new Scanner(System.in);

    public void exercicio() {
        System.out.println("Informe seu nome ");
        String nome = sc.nextLine();

        System.out.println("Informe a altura");
        double altura = sc.nextDouble();

        System.out.println("Informe a idade");
        double idade = sc.nextDouble();

        System.out.println("Informe o sexo: 1- Feminino; 2-Masculino;");
        double sexo = sc.nextDouble();

        System.out.println("Informe  o peso");
        double peso = sc.nextDouble();

        double pesoIdeal;

        double imc = peso / (altura * altura);

        if (sexo == 1) {// Feminino
            pesoIdeal = 62.1 * altura - 44.7;
        } else { // Masculino
            pesoIdeal = 72.7 * altura - 58;
        }
        System.out.println(nome + " seu IMC é " + imc+".");

        System.out.println(nome + " seu peso ideal é " + pesoIdeal + " Kg.");

        if (imc < 20) {
            System.out.println(nome + " esta abaixo do peso");
        }

        else if (imc > 27) {
            System.out.println(nome + " esta acima do peso");
        }

        else {
            System.out.println(nome + " esta no peso normal");
        }

        if (imc < 20) {
            System.out.println(nome + " é recomendado atividade dificil");
        }

        else if (imc > 27) {
            System.out.println(nome + " é recomendado atividade leve");
        }

        else {
            System.out.println(nome + " é recomendado atividade moderada");
        }

        if ((imc < 20) && (idade > 16 && idade < 25)) {
            System.out.println("é recomendado luta");
        } else if ((imc <= 20) && (idade > 25 && idade < 35)) {
            System.out.println("é recomendado musculação intensa");
        } else if ((imc <= 20) && (idade > 36 && idade < 45)) {
            System.out.println("é recomendado luta ou musculação intensa");
        } else if ((imc <= 20) && (idade > 46 && idade < 55)) {
            System.out.println("é recomendado pilates");
        } else if ((imc <= 20) && (idade > 56 && idade < 65)) {
            System.out.println("é recomendado luta");
        } else if ((imc <= 20) && (idade >= 66)) {
            System.out.println("é recomendado pilates ");
        }

        if ((imc > 20 && imc < 27) && (idade > 16 && idade < 25)) {
            System.out.println("é recomendado musculação moderada, corrida ou Dança");
        } else if ((imc > 20 && imc < 27) && (idade > 25 && idade < 35)) {
            System.out.println("é recomendado musculação moderada  ou Dança");
        } else if ((imc > 20 && imc < 27) && (idade > 36 && idade < 45)) {
            System.out.println("é recomendado musculação moderada, Dança ou corrida");
        } else if ((imc > 20 && imc < 27) && (idade > 46 && idade < 55)) {
            System.out.println("é recomendado corrida, musculação moderada ou Dança");
        } else if ((imc > 20 && imc < 27) && (idade > 56 && idade < 65)) {
            System.out.println("é recomendado Corrida ou Dança");
        } else if ((imc > 20 && imc < 27) && (idade >= 66)) {
            System.out.println("é recomendado Dança e olhe lá");
        }

        else if ((imc >= 27) && (idade > 16 && idade < 25)) {
            System.out.println("é recomendado Musculação Leve ");
        } else if ((imc >= 27) && (idade > 25 && idade < 35)) {
            System.out.println("é recomendado Ioga ");
        } else if ((imc >= 27) && (idade > 36 && idade < 45)) {
            System.out.println("é recomendado Ioga ");
        } else if ((imc >= 27) && (idade > 46 && idade < 55)) {
            System.out.println("é recomendado Ioga,Musculação Leve ");
        } else if ((imc <= 27) && (idade > 56 && idade < 65)) {
            System.out.println("é recomendado Ioga, Musculação Leve");
        } else if ((imc >= 27) && (idade >= 66)) {
            System.out.println("é recomendado Ioga, Musculação Leve");
        } else {
        }

    }
}
