import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDao {
    public void cleanup(){
        Connection con = ConnectionFactory.getConnection();
        Statement stmt = null;
        
            try{
                stmt.executeUpdate("drop table tbl_basica");
                con.close();
            }catch (Exception ex){
                //ignorar erros
          }
    }
    
    public void doexample() throws SQLException{
             Connection con = ConnectionFactory.getConnection();
               Statement stmt = null;
               System.out.println("\nExecutando os testes:");
               // criar tablelas que armazena os dados
               stmt.executeUpdate("drop table tbl_basica(a int2, b int2)");
     
    }
}