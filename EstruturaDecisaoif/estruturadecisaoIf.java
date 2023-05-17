package EstruturaDecisaoif;
import java.util.Scanner;
public class estruturadecisaoIf {
    Scanner sc = new Scanner (System.in);
    public void EstruturaDecisaoIf() {
        System.out.println("Qual é o preço do Produto");
        double precoProduto = sc.nextDouble();
        boolean produtoAltoValor = precoProduto >= 100 && precoProduto<200;
        double percentualDescontos = 0.0;
        if (produtoAltoValor) {//Estrutura de decisao if 
            // Desconto para produtos de alto valor.
            percentualDescontos = 5.0;
        }
        if(precoProduto>=200 && precoProduto<300) 
        { percentualDescontos= 10.0;
        }
        if(precoProduto >=300 && precoProduto<400){
            percentualDescontos =15.0;
        }
        if (precoProduto >=400 && precoProduto<500){
            percentualDescontos =20.0;
        }
        if (precoProduto >=500){
            percentualDescontos = 25.0;
        }

        // Regra de três
        double desconto = (precoProduto * percentualDescontos) / 100;
        double precoComDesconto = precoProduto -desconto;
        System.out.println("O produto saira por R$" + precoComDesconto);
        
    }
    public void decisaoIfElse(){
        System.out.println("Degite o preço do Produto");
        double precoProduto = sc.nextDouble();
        double percentualDescontos = 0.0;
        if(precoProduto<100){
         percentualDescontos = 0.0;
        } else if(precoProduto >= 100 
        && precoProduto<200)
        {
            percentualDescontos = 5.0;
        } else if (precoProduto <=200
        && precoProduto<300)
        { 
            percentualDescontos =10.0;

        } else {
           percentualDescontos = 15.0; 
        }
        

        // Regra de três
        double desconto = (precoProduto * percentualDescontos) / 100;
        double precoComDesconto = precoProduto -desconto;
        System.out.println("O produto saira por R$" + precoComDesconto);
    }
}
