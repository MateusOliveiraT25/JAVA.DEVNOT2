package VetoresArray;

import java.util.Scanner;

public class Vetores {
    Scanner sc = new Scanner(System.in);
    public void exemplo1() {
        //criando um vetor
        double[] valores = new double[] {10.5,20.7,30.6,40.4};
        System.out.println("1º Posição- Indice[0]:" + valores[0]);
        System.out.println("2º Posição- Indice[1]:" + valores[1]);
        System.out.println("3º Posição- Indice[2]:" + valores[2]);
        System.out.println("4º Posição- Indice[3]:" + valores[3]);
        valores[0] = 15.6;
        System.out.println("1º Posição- Indice[0]:" + valores[0]);
    }
    public void exemplo2() {
        int valoresInt[] =new int[6];
        System.out.println("Digite 6 Nº inteiros");
        valoresInt[0]=sc.nextInt();
        valoresInt[1]=sc.nextInt();
        valoresInt[2]=sc.nextInt();
        valoresInt[3]=sc.nextInt();
        valoresInt[4]=sc.nextInt();
        valoresInt[5]=sc.nextInt();
        System.out.println("1º Posição- Indice[0]:" + valoresInt[0]);
        System.out.println("2º Posição- Indice[1]:" + valoresInt[1]);
        System.out.println("3º Posição- Indice[2]:" + valoresInt[2]);
        System.out.println("4º Posição- Indice[3]:" + valoresInt[3]);
        System.out.println("5º Posição- Indice[4]:" + valoresInt[4]);
        System.out.println("6º Posição- Indice[5]:" + valoresInt[5]);}
        public void exemplo3() {
            double valoresDouble[] =new double[10];
            System.out.println("Digite 10 Nº Reais");
            valoresDouble[0]=sc.nextDouble();
            valoresDouble[1]=sc.nextDouble();
            valoresDouble[2]=sc.nextDouble();
            valoresDouble[3]=sc.nextDouble();
            valoresDouble[4]=sc.nextDouble();
            valoresDouble[5]=sc.nextDouble();
            valoresDouble[6]=sc.nextDouble();
            valoresDouble[7]=sc.nextDouble();
            valoresDouble[8]=sc.nextDouble();
            valoresDouble[9]=sc.nextDouble();

            System.out.println("10º Posição- Indice[9]:" + valoresDouble[9]);
            System.out.println("09º Posição- Indice[8]:" + valoresDouble[8]);
            System.out.println("08º Posição- Indice[7]:" + valoresDouble[7]);
            System.out.println("07º Posição- Indice[6]:" + valoresDouble[6]);
            System.out.println("06º Posição- Indice[5]:" + valoresDouble[5]);
            System.out.println("05º Posição- Indice[4]:" + valoresDouble[4]);
            System.out.println("04º Posição- Indice[3]:" + valoresDouble[3]);
            System.out.println("03º Posição- Indice[2]:" + valoresDouble[2]);
            System.out.println("02º Posição- Indice[1]:" + valoresDouble[1]);
            System.out.println("01º Posição- Indice[0]:" + valoresDouble[0]);}
            public void exemplo4() {
                double notas[] =new double[4];
                System.out.println("Digite 4 Notas do aluno");
                notas[0]=sc.nextDouble();
                notas[1]=sc.nextDouble();
                notas[2]=sc.nextDouble();
                notas[3]=sc.nextDouble();

                System.out.println("1º Posição- Indice[0]:" + notas[0]);
                System.out.println("2º Posição- Indice[1]:" + notas[1]);
                System.out.println("3º Posição- Indice[2]:" +notas[2]);
                System.out.println("4º Posição- Indice[3]:" +notas[3]);
               double media = (notas[0] + notas[1]+notas[2] + notas[3])/4;
               System.out.println("A media é " +media);}
               public void exemplo5() {
                double vetoresA[] =new double[5];
                double vetoresB[] =new double[5];
            System.out.println("Digite nº5");
            vetoresA[0]=sc.nextDouble();
            vetoresA[1]=sc.nextDouble();
            vetoresA[2]=sc.nextDouble();
            vetoresA[3]=sc.nextDouble();
            vetoresA[4]=sc.nextDouble();
            vetoresB[0]=vetoresA[0];
            vetoresB[1]=vetoresA[1];
            vetoresB[2]=vetoresA[2];
            vetoresB[3]=vetoresA[3];
            vetoresB[4]=vetoresA[4];
            System.out.println("1º Posição- Indice[0]:" + vetoresB[0]);
            System.out.println("2º Posição- Indice[1]:" + vetoresB[1]);
            System.out.println("3º Posição- Indice[2]:" +vetoresB[2]);
            System.out.println("4º Posição- Indice[3]:" +vetoresB[3]);
            System.out.println("5º Posição- Indice[4]:" +vetoresB[4]);}
            public void exemplo6() {
                double vetoresA[] =new double[8];
                double vetoresB[] =new double[8];
            System.out.println("Digite nº8 ");
            vetoresA[0]=sc.nextDouble();
            vetoresA[1]=sc.nextDouble();
            vetoresA[2]=sc.nextDouble();
            vetoresA[3]=sc.nextDouble();
            vetoresA[4]=sc.nextDouble();
            vetoresA[5]=sc.nextDouble();
            vetoresA[6]=sc.nextDouble();
            vetoresA[7]=sc.nextDouble();
            vetoresB[0]=vetoresA[0]*2;
            vetoresB[1]=vetoresA[1]*2;
            vetoresB[2]=vetoresA[2]*2;
            vetoresB[3]=vetoresA[3]*2;
            vetoresB[4]=vetoresA[4]*2;
            vetoresB[5]=vetoresA[5]*2;
            vetoresB[6]=vetoresA[6]*2;
            vetoresB[7]=vetoresA[7]*2;


            System.out.println("1º Posição- Indice[0]:" + vetoresB[0]);
            System.out.println("2º Posição- Indice[1]:" + vetoresB[1]);
            System.out.println("3º Posição- Indice[2]:" +vetoresB[2]);
            System.out.println("4º Posição- Indice[3]:" +vetoresB[3]);
            System.out.println("5º Posição- Indice[4]:" +vetoresB[4]);
            System.out.println("6º Posição- Indice[5]:" +vetoresB[5]);
            System.out.println("7º Posição- Indice[6]:" +vetoresB[6]);
            System.out.println("8º Posição- Indice[7]:" +vetoresB[7]);}

            public void exemplo7() {
                double vetoresA[] =new double[15];
                double vetoresB[] =new double[15];
            System.out.println("Digite nº15");
            vetoresA[0]=sc.nextDouble();
            vetoresA[1]=sc.nextDouble();
            vetoresA[2]=sc.nextDouble();
            vetoresA[3]=sc.nextDouble();
            vetoresA[4]=sc.nextDouble();
            vetoresA[5]=sc.nextDouble();
            vetoresA[6]=sc.nextDouble();
            vetoresA[7]=sc.nextDouble();
            vetoresA[8]=sc.nextDouble();
            vetoresA[9]=sc.nextDouble();
            vetoresA[10]=sc.nextDouble();
            vetoresA[11]=sc.nextDouble();
            vetoresA[12]=sc.nextDouble();
            vetoresA[13]=sc.nextDouble();
            vetoresA[14]=sc.nextDouble();


            vetoresB[0]=vetoresA[0]*vetoresA[0];
            vetoresB[1]=vetoresA[1]*vetoresA[1];
            vetoresB[2]=vetoresA[2]*vetoresA[2];
            vetoresB[3]=vetoresA[3]*vetoresA[3];
            vetoresB[4]=vetoresA[4]*vetoresA[4];
            vetoresB[5]=vetoresA[5]*vetoresA[5];
            vetoresB[6]=vetoresA[6]*vetoresA[6];
            vetoresB[7]=vetoresA[7]*vetoresA[7];
            vetoresB[8]=vetoresA[8]*vetoresA[8];
            vetoresB[9]=vetoresA[9]*vetoresA[9];
            vetoresB[10]=vetoresA[10]*vetoresA[10];
            vetoresB[11]=vetoresA[11]*vetoresA[12];
            vetoresB[12]=vetoresA[12]*vetoresA[13];
            vetoresB[13]=vetoresA[13]*vetoresA[13];
            vetoresB[14]=vetoresA[14]*vetoresA[14];


            System.out.println("1º Posição- Indice[0]:" + vetoresB[0]);
            System.out.println("2º Posição- Indice[1]:" + vetoresB[1]);
            System.out.println("3º Posição- Indice[2]:" +vetoresB[2]);
            System.out.println("4º Posição- Indice[3]:" +vetoresB[3]);
            System.out.println("5º Posição- Indice[4]:" +vetoresB[4]);
            System.out.println("6º Posição- Indice[5]:" +vetoresB[5]);
            System.out.println("7º Posição- Indice[6]:" +vetoresB[6]);
            System.out.println("8º Posição- Indice[7]:" +vetoresB[7]);
            System.out.println("9º Posição- Indice[0]:" + vetoresB[8]);
            System.out.println("10º Posição- Indice[1]:" + vetoresB[9]);
            System.out.println("11º Posição- Indice[2]:" +vetoresB[10]);
            System.out.println("12º Posição- Indice[3]:" +vetoresB[11]);
            System.out.println("13º Posição- Indice[4]:" +vetoresB[12]);
            System.out.println("14º Posição- Indice[5]:" +vetoresB[13]);
            System.out.println("15º Posição- Indice[6]:" +vetoresB[14]);}
            public void exemplo8() {
                double vetoresA[] =new double[15];
                double vetoresB[] =new double[15];
            System.out.println("Digite nº15 para ter raiz");
            vetoresA[0]=sc.nextDouble();
            vetoresA[1]=sc.nextDouble();
            vetoresA[2]=sc.nextDouble();
            vetoresA[3]=sc.nextDouble();
            vetoresA[4]=sc.nextDouble();
            vetoresA[5]=sc.nextDouble();
            vetoresA[6]=sc.nextDouble();
            vetoresA[7]=sc.nextDouble();
            vetoresA[8]=sc.nextDouble();
            vetoresA[9]=sc.nextDouble();
            vetoresA[10]=sc.nextDouble();
            vetoresA[11]=sc.nextDouble();
            vetoresA[12]=sc.nextDouble();
            vetoresA[13]=sc.nextDouble();
            vetoresA[14]=sc.nextDouble();


            vetoresB[0]=Math.sqrt( vetoresA[0]);
            vetoresB[1]=Math.sqrt( vetoresA[1]);
            vetoresB[2]=Math.sqrt( vetoresA[2]);
            vetoresB[3]=Math.sqrt( vetoresA[3]);
            vetoresB[4]=Math.sqrt( vetoresA[4]);
            vetoresB[5]=Math.sqrt( vetoresA[5]);
            vetoresB[6]=Math.sqrt( vetoresA[6]);
            vetoresB[7]=Math.sqrt( vetoresA[7]);
            vetoresB[8]=Math.sqrt( vetoresA[8]);
            vetoresB[9]=Math.sqrt( vetoresA[9]);
            vetoresB[10]=Math.sqrt( vetoresA[10]);
            vetoresB[11]=Math.sqrt( vetoresA[11]);
            vetoresB[12]=Math.sqrt( vetoresA[12]);
            vetoresB[13]=Math.sqrt( vetoresA[13]);
            vetoresB[14]=Math.sqrt( vetoresA[14]);


            System.out.println("1º Posição- Indice[0]:" + vetoresB[0]);
            System.out.println("2º Posição- Indice[1]:" + vetoresB[1]);
            System.out.println("3º Posição- Indice[2]:" +vetoresB[2]);
            System.out.println("4º Posição- Indice[3]:" +vetoresB[3]);
            System.out.println("5º Posição- Indice[4]:" +vetoresB[4]);
            System.out.println("6º Posição- Indice[5]:" +vetoresB[5]);
            System.out.println("7º Posição- Indice[6]:" +vetoresB[6]);
            System.out.println("8º Posição- Indice[7]:" +vetoresB[7]);
            System.out.println("9º Posição- Indice[0]:" + vetoresB[8]);
            System.out.println("10º Posição- Indice[1]:" + vetoresB[9]);
            System.out.println("11º Posição- Indice[2]:" +vetoresB[10]);
            System.out.println("12º Posição- Indice[3]:" +vetoresB[11]);
            System.out.println("13º Posição- Indice[4]:" +vetoresB[12]);
            System.out.println("14º Posição- Indice[5]:" +vetoresB[13]);
            System.out.println("15º Posição- Indice[6]:" +vetoresB[14]);}

            public void exemplo9() {
                double vetoresA[] =new double[10];
                double vetoresB[] =new double[10];
            System.out.println("Digite nº10");
            vetoresA[0]=sc.nextDouble();
            vetoresA[1]=sc.nextDouble();
            vetoresA[2]=sc.nextDouble();
            vetoresA[3]=sc.nextDouble();
            vetoresA[4]=sc.nextDouble();
            vetoresA[5]=sc.nextDouble();
            vetoresA[6]=sc.nextDouble();
            vetoresA[7]=sc.nextDouble();
            vetoresA[8]=sc.nextDouble();
            vetoresA[9]=sc.nextDouble();


            vetoresB[0]=vetoresA[0]*0;
            vetoresB[1]=vetoresA[1]*1;
            vetoresB[2]=vetoresA[2]*2;
            vetoresB[3]=vetoresA[3]*3;
            vetoresB[4]=vetoresA[4]*4;
            vetoresB[5]=vetoresA[5]*5;
            vetoresB[6]=vetoresA[6]*6;
            vetoresB[7]=vetoresA[7]*7;
            vetoresB[8]=vetoresA[8]*8;
            vetoresB[9]=vetoresA[9]*9;

            System.out.println("1º Posição- Indice[0]:" + vetoresB[0]);
            System.out.println("2º Posição- Indice[1]:" + vetoresB[1]);
            System.out.println("3º Posição- Indice[2]:" +vetoresB[2]);
            System.out.println("4º Posição- Indice[3]:" +vetoresB[3]);
            System.out.println("5º Posição- Indice[4]:" +vetoresB[4]);
            System.out.println("6º Posição- Indice[5]:" +vetoresB[5]);
            System.out.println("7º Posição- Indice[6]:" +vetoresB[6]);
            System.out.println("8º Posição- Indice[7]:" +vetoresB[7]);
            System.out.println("9º Posição- Indice[0]:" + vetoresB[8]);
            System.out.println("10º Posição- Indice[1]:" + vetoresB[9]);}


            public void exemplo10() {
                double vetoresA[] =new double[10];
                double vetoresB[] =new double[10];
                double vetoresC[] =new double[10];
                

            System.out.println("Digite nº10 para Vetores A");
            vetoresA[0]=sc.nextDouble();
            vetoresA[1]=sc.nextDouble();
            vetoresA[2]=sc.nextDouble();
            vetoresA[3]=sc.nextDouble();
            vetoresA[4]=sc.nextDouble();
            vetoresA[5]=sc.nextDouble();
            vetoresA[6]=sc.nextDouble();
            vetoresA[7]=sc.nextDouble();
            vetoresA[8]=sc.nextDouble();
            vetoresA[9]=sc.nextDouble();

            System.out.println("Digite nº10 para Vetores B");
            vetoresB[0]=sc.nextDouble();
            vetoresB[1]=sc.nextDouble();
            vetoresB[2]=sc.nextDouble();
            vetoresB[3]=sc.nextDouble();
            vetoresB[4]=sc.nextDouble();
            vetoresB[5]=sc.nextDouble();
            vetoresB[6]=sc.nextDouble();
            vetoresB[7]=sc.nextDouble();
            vetoresB[8]=sc.nextDouble();
            vetoresB[9]=sc.nextDouble();

            vetoresC[0]=vetoresA[0]+vetoresB[0];
            vetoresC[1]=vetoresA[1]+vetoresB[1];
            vetoresC[2]=vetoresA[2]+vetoresB[2];
            vetoresC[3]=vetoresA[3]+vetoresB[3];
            vetoresC[4]=vetoresA[4]+vetoresB[4];
            vetoresC[5]=vetoresA[5]+vetoresB[5];
            vetoresC[6]=vetoresA[6]+vetoresB[6];
            vetoresC[7]=vetoresA[7]+vetoresB[7];
            vetoresC[8]=vetoresA[8]+vetoresB[8];
            vetoresC[9]=vetoresA[9]+vetoresB[9];
         
            System.out.println("1º Posição- Indice[0]:" + vetoresC[0]);
            System.out.println("2º Posição- Indice[1]:" + vetoresC[1]);
            System.out.println("3º Posição- Indice[2]:" +vetoresC[2]);
            System.out.println("4º Posição- Indice[3]:" +vetoresC[3]);
            System.out.println("5º Posição- Indice[4]:" +vetoresC[4]);
            System.out.println("6º Posição- Indice[5]:" +vetoresC[5]);
            System.out.println("7º Posição- Indice[6]:" +vetoresC[6]);
            System.out.println("8º Posição- Indice[7]:" +vetoresC[7]);
            System.out.println("9º Posição- Indice[0]:" + vetoresC[8]);
            System.out.println("10º Posição- Indice[1]:" + vetoresC[9]);}


        






    


               }
