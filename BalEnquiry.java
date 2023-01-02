package com.banking;
import java.util.Scanner;
import java.sql.*;
import com.banking.Connector;

public class BalEnquiry {
    Scanner sc = new Scanner(System.in);
    Connector c2 = new Connector();

    
    public void Bal_Enquiry(){
        System.out.print("Enter CIF ID :\t");
        int cif = sc.nextInt();
        
        int Balance=0;
        try{
            String query1 = "SELECT balance FROM Acc_Info WHERE CIF= "+ cif +" ";
            ResultSet rs = c2.s.executeQuery(query1);

            while(rs.next()){
             Balance = rs.getInt("balance");
             System.out.print("\t\tBalance : Rs " + Balance + "\n");
            }

        }catch(Exception e){
            System.out.print(e);
            System.out.print("Eroorrrrrr --------------\n");
        }

    }
}