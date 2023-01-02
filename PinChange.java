    
package com.banking;
import java.util.Scanner;
import java.sql.*;
import com.banking.Connector;

public class PinChange {
    Scanner Sc = new Scanner(System.in);
    Connector c2 = new Connector();
        private int Old_PIN;
        private int New_PIN;
        private int Fetch_PIN;
        private int Fetch_cif;
        private int cif;

    public void ChangePin(){
        try{
            System.out.print("\t\tEnter CIF ID : ");
            cif = Sc.nextInt();
            String query5 = "SELECT CIF FROM customer2";
            ResultSet rs1 = c2.s.executeQuery(query5);
            while(rs1.next()){
                
                 Fetch_cif = rs1.getInt("CIF"); 

                 if(Fetch_cif == cif){

                    System.out.print("\n\nChange Pin For Account  :------------------->\n");
                    System.out.print("( Pin should be only Four digits in number )\n\n");

                    // Fetch old pin from database and compare
                    String query1 = "SELECT pin FROM customer2 WHERE CIF= "+ cif +" ";
                    ResultSet rs = c2.s.executeQuery(query1);
                    while(rs.next()){
                          Fetch_PIN = rs.getInt("pin");  
                    }

                    System.out.print("\t\tEnter Old Pin : ");
                    Old_PIN = Sc.nextInt();

                    if(Fetch_PIN == Old_PIN){
                        System.out.print("\t\tEnter New Pin : ");
                        New_PIN = Sc.nextInt();
                        System.out.print("\t\tRe-Enter New Pin : ");
                        New_PIN= Sc.nextInt();
                    }
                    else{
                        System.out.print("\t\tPin Does not match\n\n");
                        ChangePin();
                    }



                    String query2 = "UPDATE customer2 SET pin = "+ New_PIN +" WHERE CIF="+ cif +" ";
                    c2.s.executeUpdate(query2);
                   
                 }
                
               
            }
            System.out.print("Invalid CIF ID,Enter Valid ID.\n\n");
            

        }catch(Exception e){
            System.out.print(e);
        }

    }

}