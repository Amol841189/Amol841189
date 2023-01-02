package com.banking;
import java.sql.*;  

public class Connector{
    Connection c;
    Statement s;
    public Connector(){  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost/amol", "root", "Amol@2003");    
            s =c.createStatement();       
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  