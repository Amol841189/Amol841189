import com.banking.CuDetail;
import com.banking.Operations;
import com.banking.Connector;
import java.lang.System;
class Home {
   public static void main(String[] args){
      Connector c1 = new Connector();
      CuDetail client = new CuDetail();
      Operations o1 = new Operations();

      while(true){
      
      o1.ShowMenu();
      o1.Choose();

      
   

      // try{
         
      //    String query1 = "insert into customer values('" + client.CIF + "' ,'" + client.FirstName + "')";
      //     c1.s.executeUpdate(query1);
         
      // }catch(Exception e){
      //    System.out.print(e);
      //    System.out.print("Error Occured...\n");
      // }
      // System.exit(0);

      

      }
   }
}