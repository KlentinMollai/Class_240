package lesson_2;

/* 
********************************************
# Array Q1

   **Please do not change any of the existing code**
   
   This program will download a `tmp.txt` file from a remote server
   and then load the data into an array named `numbers`.
   
   Please write java code process the array.
   
********************************************
*/
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;
import java.util.regex.*;

public class Array
{
   public static void main(String[] args)
   {
      double[] numbers = new double[99999];

      /* download and save tmp.txt from a remote server
         load the data into number array */
      try{
         URL website = new URL("https://www.cs.wcupa.edu/schen/csc142/tmp.txt");
         ReadableByteChannel rbc = Channels.newChannel(website.openStream());
         FileOutputStream fos = new FileOutputStream("tmp.txt");
         fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
         Scanner dataFile = new Scanner(new File("tmp.txt"));
         int count = -1;
         while(dataFile.hasNext()){
            numbers[++count] = Double.parseDouble(dataFile.nextLine());
            }
         }
      catch(Exception ex){
         System.out.println(ex);
         System.out.println("You got an error, Ask Dr. Chen for help");
      }
         int sum = 0;  
         double average = 0;
         double  min_index = 0;
         double max_index = 0;
         for(double element : numbers) {
        	 sum += element;         
     
         }
         
         System.out.println("Sum is:" + sum);
         average = sum / numbers.length;
         System.out.println(average);
         double min = numbers[0];
         double max = numbers[0];             	          
        
         for(int i = 0; i < numbers.length; i++) {
        	 if(numbers[i] < min) {
        		 min_index = i;
        		 min = numbers[i];
        	 }
        	 
        	 if(numbers[i] > max) {
        		 max_index = i;
        		 max = numbers[i];
         }
         }
         System.out.println(min);
         System.out.println(min_index);
    	 System.out.println(max);
    	 System.out.println(max_index);
        	
     
    
   
   }
}

