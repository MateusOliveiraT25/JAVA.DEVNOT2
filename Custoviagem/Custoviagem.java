
/**
 * CustoViagem
 */
public class CustoViagem {

    public static void main(String[] args) {
        int distanciaPercorrida = 148;// em km
        double consumoTransporte = 10; // em km/l
        double precoCombustivel = 4.99; // em R$
        double quatidadeLitrosCombustivel = distanciaPercorrida/consumoTransporte;
        double custoTotal = quatidadeLitrosCombustivel*precoCombustivel;
        System.out.println("o Custo total da Viagem foi de:");
        System.out.println("R$"+custoTotal);


    }
}