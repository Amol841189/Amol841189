import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
public class simple {
   public static void main(String args[]) throws SQLException {
      
      DriverManager.registerDriver(new com.mysql.jdbc.Driver());
      
      String mysqlUrl = "jdbc:mysql://localhost/amol";
      Connection con = DriverManager.getConnection(mysqlUrl, "root", "Amol@2003");
      System.out.println("Connection established......");
      
      String insertQuery = "INSERT INTO customer1 (name , age) VALUES (?, ?)";
      //Creating a PreparedStatement object
      PreparedStatement pstmt = con.prepareStatement(insertQuery);
      pstmt.setString(1, "amol");
      pstmt.setString(2, "10");
      pstmt.setString(1, "amol");
      pstmt.setString(2, "10");
      pstmt.setString(1, "amol");
      pstmt.setString(2, "10");
      pstmt.execute();
   }
}
      