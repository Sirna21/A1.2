import java.util.Scanner;
import java.text.DecimalFormat;
import javax.swing.*;
import java.io.*;
import java.text.NumberFormat;

/** ***************************************************
 *  Name:           Sirna
 *  Class:          CS30S
 * 
 *  Assignment:     A1.2
 * 
 *  Description:    This program will get data from a text file and will calculate the final grade of each student.
 * 
 *************************************************************/

public class A1_2 {

    public static void main(String[] args) throws IOException{
        // ***** constants *******
        final DecimalFormat df = new DecimalFormat("0.00");      //The decimal formator I will use to only print out 2 decimal places 
        final int max= 30;                          //The max amount of data that can be read
        final double D = 3;                         // used to divide for overall grade

        // ***** variables *****
        int n = 0;                                  //used to keep count and track of input
        double overallgrade = 0;                    // the overall grade for each student 

        //arrays for each peice of data
        int [] ID = new int [max];
        int [] A1 = new int [max];
        int [] A2 = new int [max];
        int [] A3 = new int [max];
        String [] names = new String [max];
        double [] OverallGrade = new double [max];

        
        //int[] name = new int[Joe Karen Macironi];

        String banner = "";             // output banner
        String prompt = "";             // prompt for user input

        String strin = "";              // string fro keyboard input
        String strout = "";             // string for formatted output

        String delim = "[ ]+";          // delimiter for splitting input records
        String[] tokens = null;         // used to split input records

        // a new line character that works on every computer system
        String nl = System.lineSeparator();

        // ***** objects *****

        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        // file io buffers for reading and writing to text files

        BufferedReader fin = new BufferedReader(new FileReader("studentData.txt"));
        //PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("ClassRecordOut.txt")));

        // ***** print banners *****

        banner = "*****************************" + nl;
        banner += "Name:        Sirna Tafese" + nl;
        banner += "Class:       CS30S" + nl;
        banner += "Assignment:  A1.2" + nl;
        banner += "*****************************" + nl + nl;

        System.out.println(banner);
        //fout.print(banner);

        // ***** Get Input *****

        // prompt for input
        // read input from keyboard
        // echo input back to console window

        // ***** Main Processing *****

        //prime control variable
        strin = fin.readLine();

        //System.out.println(strin);

        while(strin != null){
            //System.out.println(strin);

            //parse text file
            tokens = strin.split(delim);

            names [n] = tokens[0];
            ID [n] = Integer.parseInt(tokens [1]);
            A1 [n] = Integer.parseInt(tokens [2]);
            A2 [n] = Integer.parseInt(tokens [3]);  
            A3 [n] = Integer.parseInt(tokens [4]);

            //System.out.println(A1[n]);

            //Calculating the overall grade for each student
            overallgrade = (A1[n] + A2[n] + A3[n]) / D;
            OverallGrade[n] = overallgrade;

            //System.out.println(OverallGrade[n]);

            //incrementing n
            n++;

            //update control variable
            strin = fin.readLine();
        } //end of eof  loop

        // ***** Print Formatted Output *****
        //Formating output
        for(int i = 0; i < n; i++){
            if(i == 0){
                strout += String.format("%s %7s %7s %7s %7s %7s %s", "Name", "ID", "A1", "A2", "A3", "Grade", nl);

            }//end of if statement

            //formating output neatly
            strout  += String.format("%-10s", names[i]);
            strout  += String.format("%-8s", ID[i]);
            strout  += String.format("%-8s", A1[i]);
            strout  += String.format("%-8s", A2[i]);
            strout  += String.format("%-5s", A3[i]);
            strout  += String.format("%-7s %s", df.format(OverallGrade[i]), nl);
            //System.out.format(" %s %7s %7s %7s %7s %7s %s", (names[i]), ID[i], A1[i], A2[i], A3[i], df.format(OverallGrade[i]), nl);

        }// end of for loop
        //printing nicely formated output
        System.out.println(strout);

        // ***** Closing Message *****

        System.out.println();
        System.out.println("end of processing");
        //fout.println("End of Processing");

        // **** close io buffers *****

        //fin.close();
        //fout.close();
    } // end main 

} // end FormatTemplate
