package com.banking;
import java.util.Scanner;
import java.sql.*;
import com.banking.Connector;

public class DeleteAc {
    Scanner sc = new Scanner(System.in);
    Connector c2 = new Connector();

    
    public void Close_Ac(){
        System.out.print("Enter CIF ID :\t");
        int cif = sc.nextInt();
      
        
        try{
            String query1 = "DELETE FROM customer2 WHERE CIF="+ cif + " ";
            c2.s.executeUpdate(query1);
            String query2 = "DELETE FROM acc_info WHERE CIF="+ cif + " ";
            c2.s.executeUpdate(query2);

            System.out.print("\n\t\tAccount With CIF Id " + cif + " was DELETED.\n\n ");
                  
            //String query2 = "UPDATE Acc_Info SET balance = "+ Balance +" WHERE CIF="+ cif + " ";
            //c2.s.executeUpdate(query2);

        }catch(Exception e){
            System.out.print(e);
            System.out.print("Eroorrrrrr --------------\n");

        }

    }
}