package cryptoalg;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Jason Dorn & Jordan Guinn
 */
public class CryptoAlg {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        String file_name, file_name2, choice;
        Scanner user_input = new Scanner(System.in);
        Scanner user_input2 = new Scanner(System.in);
        do {
            System.out.println("To encrypt a file, please enter 'e'.");
            System.out.println("To decrypt a file, please enter 'd'.");
            System.out.println("To exit, please enter 'x'.");
            choice = user_input.nextLine();
            if (choice.equals("e")) {
                System.out.println("Please enter the text file to encrypt: ");
                file_name = "/Users/mrbiggs783/Education/San Francisco State University/2014 - Fall/Computer Science 650/Homework/CryptoAlg/";
                file_name += user_input.nextLine();

                try {
                    FileReader input_file = new FileReader(file_name + ".txt");
                    encryptFile(input_file, file_name);
                } catch (Exception e) {
                    System.out.println("Error in file read: " + e.getMessage());
                }
                System.out.println("Encryption complete.");
                System.out.println();
            } else if (choice.equals("d")) {

                System.out.println(
                        "Please enter the text file to decrypt: ");
                file_name2 = "/Users/mrbiggs783/Education/San Francisco State University/2014 - Fall/Computer Science 650/Homework/CryptoAlg/";
                file_name2 += user_input2.nextLine();
                try {
                    FileReader input_file2 = new FileReader(file_name2 + ".txt");
                    decryptFile(input_file2, file_name2);
                } catch (Exception e) {
                    System.out.println("Error in file read: " + e.getMessage());

                }
                System.out.println("Decryption complete.");
                System.out.println();
            } else if (!choice.equals("x")) {
                System.out.println("Please enter a valid character.");
            }
        } while (!choice.equals("x"));
    }

    public static void encryptFile(FileReader inputFile, String file_name) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        BufferedReader bufferReader = new BufferedReader(inputFile);
        PrintWriter writer = new PrintWriter(file_name + "_encrypted.txt", "UTF-8");

        // variable to hold 128 bits of data
        String data_tobe_converted;

        while ((data_tobe_converted = bufferReader.readLine()) != null) {
            int line_length = (data_tobe_converted.length());
            int half_line_length = line_length / 2;

            if (line_length > 1) {
                String first_half_of_line = data_tobe_converted.substring(half_line_length);
                String second_half_of_line = data_tobe_converted.substring(0, half_line_length);
                String temporary_shift = first_half_of_line + second_half_of_line;

                char[] charArray = temporary_shift.toCharArray();
                int array_length = charArray.length;

                for (int i = 0; i < array_length; i++) {
                    if (i % 2 == 0) {
                        charArray[i] = ++charArray[i];
                    } else {
                        charArray[i] = --charArray[i];
                    }
                }

                writer.println(charArray);

            } else {
                writer.println();
            }

        }
        writer.close();
        bufferReader.close();

    }

    public static void decryptFile(FileReader inputFile2, String file_name2) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        BufferedReader bufferReader2 = new BufferedReader(inputFile2);
        PrintWriter writer2 = new PrintWriter(file_name2 + "_decrypted.txt", "UTF-8");

        String data_tobe_converted;

        while ((data_tobe_converted = bufferReader2.readLine()) != null) {
            int line_length = (data_tobe_converted.length());
            int half_line_length = line_length / 2;

            if (line_length > 1) {
                char[] charArray2 = data_tobe_converted.toCharArray();
                int array_length = charArray2.length;
                for (int i = 0; i < array_length; i++) {
                    if (i % 2 == 0) {
                        charArray2[i] = --charArray2[i];
                    } else {
                        charArray2[i] = ++charArray2[i];
                    }
                }
                data_tobe_converted = new String(charArray2);
                String first_half_of_line, second_half_of_line;
                if (data_tobe_converted.length() % 2 == 0) {
                    first_half_of_line = data_tobe_converted.substring(half_line_length);
                } else {
                    first_half_of_line = data_tobe_converted.substring(half_line_length + 1);
                }
                if (data_tobe_converted.length() % 2 == 0) {
                    second_half_of_line = data_tobe_converted.substring(0, half_line_length);
                } else {
                    second_half_of_line = data_tobe_converted.substring(0, half_line_length + 1);
                }
                data_tobe_converted = first_half_of_line + second_half_of_line;

                writer2.println(data_tobe_converted);

            }

        }
        writer2.close();
        bufferReader2.close();

    }

}
