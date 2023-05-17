package CalculadoraDescontos;

/**
 * CalculadoraDescontos
 */
import java.util.Scanner;
public class CalculadoraDescontos {
    public  void calcular20(){
      java.util.Scanner sc = new Scanner(System.in);("Informe o 
      Preço do Produto")
        double precoProduto = sc.nextDouble();
      final int desconto20 = 20;
      double precoComDesconto = precoProduto
      - (precoProduto*desconto20/100);
      System.out.println("O Preço com Desconto é"
      +precoComDesconto+"Reais");
      }
      

     
    }