package LojaCarroList;

import java.util.*;

import javax.swing.JOptionPane;

public class App {
   
    public static void main(String[] args) {
      HashMap<String, Carros> ListaCarro= new HashMap<>();
        List<Carros> ListaCarros = new ArrayList<>();
        
      boolean aberto = true;
      while(aberto){
        int acao = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n2-Lista\n3-Consutar\n4-Remover\n5-Apagar")); //
           
        if (acao==1){//cadastrar carros na lista
          //criar objeto
            String marcaCar = JOptionPane.showInputDialog("Marca do Carro");
             String modeloCar = JOptionPane.showInputDialog("Modelo do Carro");
              String anoCar = JOptionPane.showInputDialog("Ano do Carro");
               String corCar = JOptionPane.showInputDialog("Cor do Carro");
               String placaCar= JOptionPane.showInputDialog("Placa do Carro");
               Carros car = new Carros(marcaCar, modeloCar,anoCar,corCar,placaCar);
               ListaCarros.add(car);
        }else if(acao==2){//listar carros cadastrado
            String Listar=" ";
            for (Carros carros : ListaCarros) {
                Listar+=carros.getMarca()+" "+carros.getModelo()+"\n";
            }JOptionPane.showMessageDialog(null, Listar);

               }else if(acao==3){
               String Listar=" ";
               int i =0;
               for (Carros carros : ListaCarros) {
                    Listar+=i+carros.imprimirLN();
                    i++;
                } int acao2=Integer.parseInt(
                    JOptionPane.showInputDialog(
                        "Escolha o Carro:\n"+Listar));
                        ListaCarros.get(acao2).imprimir();
   }else if(acao==4){
               String Listar=" ";
               int i =0;
               for (Carros carros : ListaCarros) {
                    Listar+=i+carros.imprimirLN();
                    i++;
                } int acao2=Integer.parseInt(
                    JOptionPane.showInputDialog(
                        "Escolha o Carro para excluir:\n"+Listar));
                        ListaCarros.get(acao2).imprimir();
                        ListaCarros.remove(acao2);
               }else if(acao==5){
               ListaCarros.clear();
             System.out.println(ListaCarros);
            
            }

               }
        }
      }

