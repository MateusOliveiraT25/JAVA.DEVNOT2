import java.sql.*;

public class ConnectionFactory {
    private static final String url = "jdbc:postgres://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static void getConnection() {

        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection con){
    try{
        if (con !=null){
            con.close();
    }
  }catch (SQLException ex){
      ex.printStackTrace();
  }

}
}