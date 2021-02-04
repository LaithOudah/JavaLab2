/*
Author(s): Laith Oudah & Klas Nordquist
Assignment: Lab 2
*/

package lab2;

import java.io.*;
import java.sql.SQLOutput;


public class Main {
    private static BufferedReader consoleReader;
    private static BufferedReader fileReader;
    private static BufferedWriter fileWriter;

    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();

        while() {
            String input = consoleInput("");
            try {
                switch (input) {
                    case "end":
                        System.out.println("Bye.");
                        break;
                    case "1":
                        System.out.println("File name: ");
                        String choice = consoleReader.readLine();
                        if (!choice.equals("Sourcetext.txt")) {
                            System.out.println("File does not exist!");
                        } else {
                            FileReader fr = new FileReader("src/Lab2/Sourcetext.txt");
                            BufferedReader br = new BufferedReader(fr);
                            String result;
                            while ((result = br.readLine()) != null) {
                                System.out.println(result);
                                dictionary.addWords(result);
                            }
                        }
                    case "2":
                        System.out.println("List content");
                        System.out.println("Output format (0 or 1): ");
                        int formatChoice = consoleReader.read();
                        Word.changeOutputFormat(formatChoice);
                        dictionary.toString();
                    case "3":
                        System.out.println("Remove duplicates and sort by number of occurrences");
                        dictionary.removeDuplicates();
                        dictionary.sortDictionaryByCounts();
                    case "4":
                        System.out.println("Count occurrences");
                        dictionary.countOccurrences();
                    case "5":
                        System.out.println("Save to file");

                    default:
                        System.out.println("Try again");

                }

            } catch (IOException e) {
                System.out.println("IO error");
            }
        }

    }




    public static String consoleInput(String arg) throws IOException{
        try{
            System.out.println("Select option: ");
            System.out.println("1: Load from file");
            System.out.println("2: List content");
            System.out.println("3: Remove duplicates and sort by number of occurrences");
            System.out.println("4: Count occurrences");
            System.out.println("5: Save to file");
            System.out.println("\"end\": End");
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            arg = consoleReader.readLine();
            return arg;
        }
        catch (IOException e){
            return "";
        }

    }

}
