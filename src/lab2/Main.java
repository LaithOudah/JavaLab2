/*
Author(s): Laith Oudah & Klas Nordquist
Assignment: Lab 2
*/

package lab2;

import java.io.*;

public class Main {
    private static BufferedReader consoleReader;
    private static BufferedReader fileReader;
    private static FileWriter fileWriter;

    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();

        InputStreamReader myReader = new InputStreamReader(System.in);
        consoleReader = new BufferedReader(myReader);

        String input = "";
        String fileName = "";
        boolean run = true;

        while (run) {
            System.out.println("""
                    
                    
                    Select option:
                    1. Load from file
                    2. List content
                    3. Remove doubles and sort by number of occurences
                    4. Count occurences
                    5. Save to file
                    end Quit program
                                        
                                        
                    """);
            input = consoleInput(input);

            switch (input) {
                case "1" -> {
                    System.out.print("Load from file\nFilename?: ");
                    fileName = consoleInput(fileName);
                    FileReader newFileReader;

                    try {
                        newFileReader = new FileReader(fileName);
                        fileReader = new BufferedReader(newFileReader);
                        fileName = fileReader.readLine();
                        fileReader.close();
                        newFileReader.close();
                        dictionary.addWords(fileName);

                    } catch (FileNotFoundException e) {
                        System.out.println("File does not exist!\n\n");
                    } catch (IOException e) {
                        System.out.println("IO error");
                    }
                }
                case "2" -> {
                    System.out.println("List content\nOutputformat (0 or 1):");
                    input = consoleInput(input);
                    try {
                        int number = Integer.parseInt(input);
                        Word.changeOutputFormat(number);
                        System.out.println(dictionary.toString());
                    } catch (NumberFormatException ex) {
                        System.out.println("Not a number");
                    }
                }
                case "3" -> {
                    System.out.println("Remove doubles and sort by number of occurences\n");
                    dictionary.removeDuplicates();
                    dictionary.sortDictionaryByCounts();
                    System.out.println(dictionary.toString());
                }
                case "4" -> {
                    System.out.println("Count occurences\n");
                    dictionary.countOccurrences();
                }
                case "5" -> {
                    System.out.println("Save to file\nEnter fileName.txt");
                    input = consoleInput(input);
                    File myFile = new File(input);

                    try {
                        myFile.createNewFile();
                        fileWriter = new FileWriter(myFile, false);
                        fileWriter.write(dictionary.toString());
                        fileWriter.close();
                    } catch (IOException e) {
                        System.out.println("IOException");
                    }
                }
                case "end" -> {
                    System.out.println("Bye.");
                    run = false;
                }
                default -> System.out.println("Try again");
            }
        }
    }

    public static String consoleInput(String arg) {
        String dummy;

        try {
            dummy = consoleReader.readLine();
        } catch (IOException e) {
            return "";
        }
        return dummy;
    }
}