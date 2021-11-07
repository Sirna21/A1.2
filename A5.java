
/* *************************************
 * Programmer:  Sirna Tafese
 * Class:       CS20S 01
 * 
 * Assignment:  A5Q1
 * 
 * Description: This program will calulate the cost per day for the given car type, any packages, airconditioning, and radio.
 ***************************************** */
 // **** import Java class Libraries ****
 import java.util.Scanner;
 import javax.swing.*;
 import java.text.NumberFormat;
 
 public class A5{
     public static void main(String[] args){
         // ******* declare constants *******
         
         //car type cost
         final int TYPECOSTDAYp = 70;
         final int TYPECOSTDAYd = 50;
         final int TYPECOSTDAYs = 35;
         
         // cartype options
         final char P = 'P';
         final char D = 'D';
         final char S = 'S';
         
         //premuim package cost
         final int PACKAGECOSTDAYs = 75;
         final int PACKAGECOSTDAYl = 90;
         
         //airconditioning cost
         final int AIRCOSTDAYa = 35;
         
         //radio cost
         final int RADIOCOSTDAy = 30;
         
         //no cost x for all
         final int NOCOST = 0;
         
         // ******* declare variables *******
         
         String banner = "";
         String strin = "";         // general input string
         String strout = "";        // general output string
         String prompt = "";        // prompt for user input
         
         String delim = "[ ]+";     // Delimiter for user input strings
         String[] tokens = null;    // an array to hold input tokens
         String nl = System.lineSeparator();    // universal newline character
         
         int numberdays = 0;             //number of days rented
         int rentalnumber = 0;           // the rental number of the user
         
         //chars for all packages
         char cartype = 'a';             
         char specialpackage = 'a';
         char AirConditioning = 'a';
         char radio = 'a';
         
         //number holders for packages
         int costperday = 0;
         int aircost = 0;
         int radiocost = 0;
         int ctcost = 0;
         int spcost = 0;
        
         // ******* create objects *******
        //Scanner scanner = new Scanner(System.in);      // connect to the keyboard
        NumberFormat cf = NumberFormat.getCurrencyInstance();  // use for formatting currency
         
         // ******* output banner *******
         
         banner = "************************\n";
         banner = banner + "Name: Sirna Tafese\n";
         banner += "Class: CS20S-01\n";
         banner += "Assignment: A5Q1\n";
         banner += "************************\n\n";
         
         System.out.println(banner);
         
         // ******* get input *******
         
         //getting input from JOptionPane
         prompt = "Please enter your rental number, Number of days, CarType, What Special package, Air conditioning, and Satellite radio";
         prompt += nl;
         
         //echo back
         strin = JOptionPane.showInputDialog(banner + prompt);
         JOptionPane.showMessageDialog(null, banner + "You entered: " + strin);

         // split and parse input string
         tokens = strin.split(delim); 
         
         // using a try catch block to catch runtime exceptions
        try {  
            rentalnumber = Integer.parseInt(tokens[0]);
            numberdays = Integer.parseInt(tokens[1]);
            cartype = tokens[2].charAt(0);
            specialpackage = tokens[3].charAt(0);
            AirConditioning = tokens[4].charAt(0);
            radio = tokens[5].charAt(0);
        }//end try
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Input Error\tTry Again:\nPlease enter the correct numbers and letters.");
        }
        catch(ArrayIndexOutOfBoundsException e){
             JOptionPane.showMessageDialog(null, "Invalid Input-: \nNot enough input, Please make sure you input what you chose in order");
        }// end catch ArrayIndexOutOfBoundsException 
   
         // ******* processing *******
         
         //nested if else structure for prossesing
      if(cartype == 'P'){
             //System.out.println("premium");
             ctcost = numberdays * TYPECOSTDAYp; 
             if(specialpackage == 'X') {
             //System.out.println("no sp package");
             spcost = NOCOST;
             }
          else{
                if(specialpackage == S){
             //System.out.println("sportpackage");
             spcost = numberdays * PACKAGECOSTDAYs;
                }
            else{
             //System.out.println("luxury package");
             spcost = numberdays * PACKAGECOSTDAYl;
            }
            costperday = ctcost + spcost;
            //System.out.println(costperday);
          }  
           costperday = ctcost + spcost;
        System.out.println(costperday);
      }//end premium package
         else{  
             //System.out.println("not premium");
             costperday = NOCOST;
           if(cartype == 'D'){ 
              //System.out.println("delux");
              ctcost = TYPECOSTDAYd * numberdays;
              
            if(AirConditioning == 'A'){
             //System.out.println("you get air");
             aircost = AIRCOSTDAYa;
            }
            else{
             //System.out.println("you dont get air");
             aircost = NOCOST;
            }
           
            if(radio == 'R'){
            //System.out.println("you get radio");
            radiocost = RADIOCOSTDAy;    
            }
            else{
            //System.out.println("you dont get radio");
            radiocost = NOCOST;
            } 
            costperday = ctcost + aircost + radiocost;
        } //end deluxe package
              
        else{
         //System.out.println("standered");
         ctcost =  TYPECOSTDAYs * numberdays;
         
         }
         
        if(AirConditioning == 'A'){
          //System.out.println("you get air");
          aircost = AIRCOSTDAYa;
         }
        else{
         //System.out.println("you dont get air");
         aircost = NOCOST;
        }
         
        if(radio == 'R'){
        //System.out.println("you get radio");     
        radiocost = RADIOCOSTDAy;  
         }
        else{
        //System.out.println("you dont get radio"); 
        radiocost = NOCOST;
        }
        costperday = ctcost + aircost + radiocost;
    }//end of standered package  
        
         // ******* output *******
         //headings
         
         System.out.format("%1s %s", "Cost per day", nl);
        
         System.out.format(" %5s %s", (cf.format(costperday)), nl);
        
         //Output results
       

         // ******* closing message *******
         
         System.out.println("end of processing");

         
  } // end main
}// end public class




