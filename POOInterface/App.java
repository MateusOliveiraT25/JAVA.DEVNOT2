package POOInterface;

public class App {
    public static void main(String[] args) throws Exception{
        Quadrado figura1 = new Quadrado(6);
        Retangulo figura2 = new Retangulo(4, 6);
        Trapezio figura3 = new Trapezio(4, 6, 5, 4, 4);
    System.out.println("nome:" +figura1.getNomeFigura()
                            +"\nArea: "+figura1.getArea()
                            +"\nPerimetro "+figura1.getPerimetro());
    System.out.println("nome:" +figura2.getNomeFigura()
                            +"\nArea: "+figura2.getArea()
                            +"\nPerimetro "+figura2.getPerimetro());
    System.out.println("nome:" +figura3.getNomeFigura()
                            +"\nArea: "+figura3.getArea()
                            +"\nPerimetro "+figura3.getPerimetro());
    }
}
