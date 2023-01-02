package com.banking;
import java.util.Scanner;
import com.banking.CuDetail;
import com.banking.Withdraw;
import com.banking.Deposite;
import com.banking.Transfer;
import com.banking.BalEnquiry;
import com.banking.PinChange;
import com.banking.DeleteAc;
public class Operations {
   final String [] operation = {"New Account","Deposite","WithDraw","Transfer","Balance Enquiry","PinChange","Delete Account","Exit"};
   CuDetail c1 = new CuDetail();
   Withdraw w1 = new Withdraw();
   Deposite d1 = new Deposite();
   Transfer t1 = new Transfer();
   PinChange p1 = new PinChange();
   BalEnquiry b1 = new BalEnquiry();                 
   DeleteAc da1 = new DeleteAc();                 
   Scanner Sc = new Scanner(System.in);

    public void ShowMenu(){
      int temp;
        System.out.print("\n\n********************************************Choose Any Option , Do you want.*************************************************\n");
        for(int i=0;i<operation.length;i++){
         temp = i+1;
         if(temp%2 == 0){
            System.out.print("\t\t" + temp + "." + operation[i] );

         }
         else{
            System.out.print("\n\n\t\t" + temp + "." + operation[i] );
         }
        }
    }

    public void Choose(){
        int choice;

        System.out.print("\nEnter Number Of Operation :\t");
        choice = Sc.nextInt();
        switch(choice){
         case 1:
            c1.Customer();
            c1.SetUpPin();
         break;

         case 2:
            d1.Deposite_Cash();
         break;

         case 3:
            w1.WithDraw_Cash();
         break;

         case 4:
            t1.Transfer_Cash();
         break;

         case 5:
            b1.Bal_Enquiry();
         break;

         case 6:
            p1.ChangePin();
         break;

         case 7:
            da1.Close_Ac();
         break;

         case 8:
         System.exit(0);
         break;

         default:

      }
    }
}