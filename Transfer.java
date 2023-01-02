package com.banking;
import java.util.Scanner;
import java.sql.*;
import com.banking.Connector;

public class Transfer {
    Scanner sc = new Scanner(System.in);
    Connector c2 = new Connector();

    
    public void Transfer_Cash(){
        
        int cif=0;
        int Balance=0;
        int Benefi_Bal=0;
    
        try{

            // Part I : Customer
            System.out.print("Enter CIF ID :\t");
            cif = sc.nextInt();
            String query1 = "SELECT balance FROM Acc_Info WHERE CIF= "+ cif +" ";
            ResultSet rs1 = c2.s.executeQuery(query1);

            while(rs1.next()){
             Balance = rs1.getInt("balance");
             System.out.print("Amount: Rs " + Balance + "\n");
            }

            // Part II : Beneficiary

            System.out.print("Enter Beneficiary A/c Number : ");
            int Benefi = sc.nextInt();
            String query2 = "SELECT ACCOUNT_BAL FROM bank WHERE ACCOUNT_NUM = "+ Benefi +" ";
            ResultSet rs2 = c2.s.executeQuery(query2);

            while(rs2.next()){
             Benefi_Bal = rs2.getInt("ACCOUNT_BAL");
             System.out.print("Amount: Rs " + Benefi_Bal + "\n");
            }

            System.out.print("Enter Amount to Transfer : Rs ");
            int Amt = sc.nextInt();


            Balance = Balance - Amt;
            Benefi_Bal = Benefi_Bal + Amt;
            System.out.print("Remaining Balance : Rs " + Balance + "\n");
            String query3 = "UPDATE Acc_Info SET balance = "+ Balance +" WHERE CIF="+ cif +" ";
            c2.s.executeUpdate(query3);
            String query4 = "UPDATE bank SET ACCOUNT_BAL = "+ Benefi_Bal +" WHERE ACCOUNT_NUM="+ Benefi +" ";
            c2.s.executeUpdate(query4);

        }catch(Exception e){
            System.out.print(e);
            System.out.print("Eroorrrrrr --------------\n");
        }

    }
}