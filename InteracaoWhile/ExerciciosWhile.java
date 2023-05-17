<<<<<<< HEAD
package InteracaoWhile;
import java.util.Scanner;


public class ExerciciosWhile {
    Scanner sc = new Scanner(System.in);
    public void exercicio1() {
        int vetorA[]=new int[]{3,4,7,11,13};
        int vetorB[]=new int[5];
        int i=0;
        while(i<vetorA.length){
            vetorB[i]=vetorA[i];
            System.out.println("VetorB["+i+"]="+vetorB[i]);
            i++;
        }}

        public void exercicio2() {
            int vetorA[]=new int[]{3,4,7,11,13,17,19,21};
            int vetorB[]=new int[vetorA.length ];
            int i=0;
            while(i<vetorA.length){
                vetorB[i]=vetorA[i];
                System.out.println("VetorB["+i+"]="+vetorB[i]);
                i++;}

            } public void exercicio3() {
            double vetorA[]=new double[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            double vetorB[]=new double[15];
           int i=0;
            while(i<vetorA.length){
                vetorB[i]=vetorA[i]*vetorA[i];
                System.out.println("VetorB["+i+"]="+vetorB[i]);
                i++;}}

            public void exercicio4() {
                double vetorA[]=new double[]{2,3,4,5,6,7,8,9,11,13,16,17,22,23,39};
                double vetorB[]=new double[15];
               int i=0;
                while(i<vetorA.length){
                    vetorB[i]=Math.sqrt( vetorA[i]);
                    System.out.println("VetorB["+i+"]="+vetorB[i]);
                    i++;}
                }
                public void exercicio5() {
                    double vetorA[]=new double[]{2,3,4,5,6,7,8,9,11,13};
                    double vetorB[]=new double[vetorA.length];
                    
                   int i=0;
                    while(i<vetorA.length){
                        vetorB[i]=vetorA[i]*i;
                        System.out.println("VetorB["+i+"]="+vetorB[i]);
                        i++;}
                    }public void exercicio6() {
                        double vetorA[]=new double[]{2,3,4,5,6,7,8,9,11,13};
                        double vetorB[]=new double[]{5,10,11,23,45,21,8,66,76,87};
                        double vetorC[]=new double[10];
                    
                       int i=0;
                        while(i<vetorA.length){
                            vetorC[i]=vetorA[i]+vetorB[i];
                            System.out.println("VetorC["+i+"]="+vetorC[i]);
                            i++;}

                            
            }

                
=======
package InteracaoWhile;
import java.util.Scanner;


public class ExerciciosWhile {
    Scanner sc = new Scanner(System.in);
    public void exercicio1() {
        int vetorA[]=new int[]{3,4,7,11,13};
        int vetorB[]=new int[5];
        int i=0;
        while(i<vetorA.length){
            vetorB[i]=vetorA[i];
            System.out.println("VetorB["+i+"]="+vetorB[i]);
            i++;
        }}

        public void exercicio2() {
            int vetorA[]=new int[]{3,4,7,11,13,17,19,21};
            int vetorB[]=new int[vetorA.length ];
            int i=0;
            while(i<vetorA.length){
                vetorB[i]=vetorA[i];
                System.out.println("VetorB["+i+"]="+vetorB[i]);
                i++;}

            } public void exercicio3() {
            double vetorA[]=new double[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            double vetorB[]=new double[15];
           int i=0;
            while(i<vetorA.length){
                vetorB[i]=vetorA[i]*vetorA[i];
                System.out.println("VetorB["+i+"]="+vetorB[i]);
                i++;}}

            public void exercicio4() {
                double vetorA[]=new double[]{2,3,4,5,6,7,8,9,11,13,16,17,22,23,39};
                double vetorB[]=new double[15];
               int i=0;
                while(i<vetorA.length){
                    vetorB[i]=Math.sqrt( vetorA[i]);
                    System.out.println("VetorB["+i+"]="+vetorB[i]);
                    i++;}
                }
                public void exercicio5() {
                    double vetorA[]=new double[]{2,3,4,5,6,7,8,9,11,13};
                    double vetorB[]=new double[vetorA.length];
                    
                   int i=0;
                    while(i<vetorA.length){
                        vetorB[i]=vetorA[i]*i;
                        System.out.println("VetorB["+i+"]="+vetorB[i]);
                        i++;}
                    }public void exercicio6() {
                        double vetorA[]=new double[]{2,3,4,5,6,7,8,9,11,13};
                        double vetorB[]=new double[]{5,10,11,23,45,21,8,66,76,87};
                        double vetorC[]=new double[10];
                    
                       int i=0;
                        while(i<vetorA.length){
                            vetorC[i]=vetorA[i]+vetorB[i];
                            System.out.println("VetorC["+i+"]="+vetorC[i]);
                            i++;}

                            
            }

                
>>>>>>> 8d0eb1b165c4cbc3820676c872ed9ede24288f60
        }