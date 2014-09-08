/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptoalg;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author jd
 */
public class CryptoAlg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String file_name;
        Scanner user_input = new Scanner(System.in);
        System.out.println("Please enter the text file to encrypt: ");
        file_name = "/Users/jd/sandbox/CryptoAlg/src/cryptoalg/";
        file_name += user_input.nextLine();
        //file_name = "/Users/jd/sandbox/CryptoAlg/src/cryptoalg/book.txt";
        
        try{
            //Create an object of FileReader
            FileReader input_file = new FileReader(file_name);
            
            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(input_file);
            
            //variable to hold 128 bits of data
            String data_tobe_converted;
            
            while ((data_tobe_converted = bufferReader.readLine()) !=null) {
                System.out.println(data_tobe_converted);
                System.out.println(data_tobe_converted.length());
                
                int line_length       = (data_tobe_converted.length());
                int half_line_length  = line_length/2;
                
                if (line_length > 4){
                String first_half_of_line = data_tobe_converted.substring(half_line_length );
                String second_half_of_line = data_tobe_converted.substring(0, half_line_length);
                System.out.println(first_half_of_line + second_half_of_line);
                }
                
            }
            
            bufferReader.close();
            
        }catch(Exception e) {
            System.out.println("Error in file read: " + e.getMessage());
        }
        
    }
    
}

