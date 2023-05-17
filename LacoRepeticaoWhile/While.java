package LacoRepeticaoWhile;
import java.util.Scanner;
public class While {
    Scanner sc = new Scanner(System.in);
    public void exemplo1() {
        int iteracao = 0;
        while (iteracao<10) {
            System.out.println("O numero da iteracao é " + iteracao);
            iteracao += 1;
            //System.out.println("O numero da iteracao é " + iteracao); = 10
        }
        public void adivinhar() {
            Randon rd = new  Randon();
            int nSorteado = rd.nextInt(bound:10);
            boolean tenteNovamente;
            while (tenteNovamente) {
                System.out.println("Digite um nº");
                tenteNovamente = false;
                int nDigitado = sc.nextInt("Acertou Miseravel");
                if(nDigitado==nSorteado)


            }
        







        }
}
}