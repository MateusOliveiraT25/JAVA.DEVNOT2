<<<<<<< HEAD
package ExemploHashMap;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ExemploHashMap {
    // atributos
    HashMap<String, String> capitalEstados = new HashMap<>();

    // metodos]
    public void teste() {
        capitalEstados.put("SP", "São Paulo");
        capitalEstados.put("MG", "Minas Gerais");
        capitalEstados.put("RJ", "Rio de Janeiro");
        capitalEstados.put("ES", "Vitória");
        boolean jogo = true;
        while(jogo){
            String Estado = JOptionPane.showInputDialog("Digite a sigla dos estados");
            JOptionPane.showMessageDialog(null, capitalEstados.get(Estado) );
          }
}
=======
package ExemploHashMap;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class ExemploHashMap {
    // atributos
    HashMap<String, String> capitalEstados = new HashMap<>();

    // metodos]
    public void teste() {
        capitalEstados.put("SP", "São Paulo");
        capitalEstados.put("MG", "Minas Gerais");
        capitalEstados.put("RJ", "Rio de Janeiro");
        capitalEstados.put("ES", "Vitória");
        boolean jogo = true;
        while(jogo){
            String Estado = JOptionPane.showInputDialog("Digite a sigla dos estados");
            JOptionPane.showMessageDialog(null, capitalEstados.get(Estado) );
          }
}
>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348
}