package EstruturaSwitchCase;
import java.util.Scanner;
public class SwitchCase {
    Scanner sc = new Scanner (System.in);
    public void letras() {
        System.out.println("Digite uma letra");
        String letras = sc.nextLine();
        switch (letras) {
            case "a":System.out.println(letras+"é");
            break;
            case "e":System.out.println(letras+"é");
            break;
            case "i":System.out.println(letras+"é");
            break;
            case "o":System.out.println(letras+"é");
            break;
            case "u":System.out.println(letras+"é");
            break;
            default:System.out.println(letras+"é consoante");
            break;}
        }
        public void nmes (){
            System.out.println("Digite um mês");
            int nomeMes = sc.nextInt();
            String nomeMes=("");
            switch (nomeMes) {
            case 1:nomeMes = "Janeiro";
            break;
            case 2:nomeMes = "Fevereiro";
            break;
            case 3:nomeMes = "Março";
            break;
            case 4:nomeMes = "Abril";
            break;
            case 5:nomeMes = "Maio";
            break;
            case 6:nomeMes = "Junho";
            break;
            case 7:nomeMes = "Julho";
            break;
            case 8:nomeMes = "Agosto";
            break;
            case 9:nomeMes = "Setembro";
            break;
            case 10:nomeMes = "Outubro";
            break;
            case 11:nomeMes = "Novembro";
            break;
            case 12:nomeMes = "Dezembro";
            break;
            default:System.out.println(nomeMes+"Invalido");
            break;
        }



    }

}