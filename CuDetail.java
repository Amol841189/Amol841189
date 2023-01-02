package com.banking;
import java.util.*;
import java.sql.*;
import com.banking.Connector;

public class CuDetail {
    Connector c6 = new Connector();
    Scanner Sc = new Scanner(System.in);
    public String FirstName,MidName,LastName;
    public int Mobile;
    public String email;
    public int CIF1;
    private int PIN= 0;
    public int Acc_Num;
 
    

    public void Customer(){    
        try{

        System.out.print("Enter Customer Details :\n");

      

        System.out.print("\n\tFirst Name :\t");
        FirstName = Sc.next();

        System.out.print("\n\tMiddle Name :\t");
        MidName = Sc.next();

        System.out.print("\n\tLast Name :\t");
        LastName = Sc.next();

        System.out.print("\n\tEnter Mobile Number :\t");
        Mobile = Sc.nextInt();    
        Acc_Num=Mobile;

        System.out.print("\n\tEnter Email :\t");
        email = Sc.next();
        
        // Inert New Data Into DataBase
        String query1 = "insert into customer2(First_Name , Mid_Name , Last_Name , Mobile_Num , Email , pin , acc_num) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = c6.c.prepareStatement(query1);
        pstmt.setString(1, FirstName);
        pstmt.setString(2, MidName);
        pstmt.setString(3, LastName);
        pstmt.setInt(4, Mobile);
        pstmt.setString(5, email);
        pstmt.setInt(6, PIN);
        pstmt.setInt(7, Acc_Num);
        pstmt.execute();
        System.out.print("\n\t********************Details are saved Successfully.......**************************\n");
        String query6 = "select CIF from customer2 where acc_num="+ Acc_Num +" ";
        ResultSet rs4 = c6.s.executeQuery(query6);

        while(rs4.next()){
            //System.out.print("CIF Id : " + rs4.getInt("CIF") );
            CIF1 = rs4.getInt("CIF");
        }
        System.out.print("\n\n\t---------------- Congratulations , You have alloted Customer Id : " + CIF1 + " ---------------------\n");

        }catch(Exception e){
        System.out.print(e);
        }
    }

    public void SetUpPin(){
        try{
            System.out.print("\n\nSetUp New Pin For New Account Only :------------------->\n");
            System.out.print("( Pin should be only Four digits in number )\n\n");
            System.out.print("\t\tEnter New Pin : ");
            PIN = Sc.nextInt();
            System.out.print("\t\tRe-Enter New Pin : ");
            PIN= Sc.nextInt();


            if(PIN<=9999 && PIN>=1000){
                 System.out.print("\t\tPin set Successfullty\n ");                   
            }
            else{
                 System.out.print("\t\tPlease , Enter Valid Pin Only Numbers\n ");   
                 SetUpPin();                
            }

            String query2 = "UPDATE customer2 SET pin = "+ PIN +" WHERE acc_num="+ Acc_Num +" ";
            c6.s.executeUpdate(query2);

            String query3 = "insert into acc_info VALUES( "+CIF1+" , 0 ) ";
            c6.s.executeUpdate(query3);
        }catch(InputMismatchException e){
            System.out.print("\n\tPlease , Enter Only Numbers Contains [0-9]\n\n");
        }catch(SQLException e){
            System.out.print(e);
        }



        }
    

    
    
}
