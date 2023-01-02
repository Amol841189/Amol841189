package com.banking;
import java.util.Scanner;
import java.sql.*;
import com.banking.Connector;

public class Withdraw {
    Scanner sc = new Scanner(System.in);
    Connector c2 = new Connector();

    
    public void WithDraw_Cash(){
        System.out.print("Enter CIF ID :\t");
        int cif = sc.nextInt();
        int Balance=0;
        try{
            String query1 = "SELECT balance FROM Acc_Info WHERE CIF= "+ cif +" ";
            ResultSet rs = c2.s.executeQuery(query1);

            System.out.print("Enter Amount to WithDraw : Rs ");
            int Amt = sc.nextInt();

            while(rs.next()){
             Balance = rs.getInt("balance");
             System.out.print("Amount: Rs " + Balance + "\n");
            }

            Balance = Balance - Amt;
            System.out.print("Remaining Balance : Rs " + Balance + "\n");
            String query2 = "UPDATE Acc_Info SET balance = "+ Balance +" WHERE CIF="+ cif +" ";
            c2.s.executeUpdate(query2);

        }catch(Exception e){
            System.out.print(e);
            System.out.print("Eroorrrrrr --------------\n");
        }

    }
}