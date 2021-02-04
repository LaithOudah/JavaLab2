/*
Author(s): Laith Oudah & Klas Nordquist
Assignment: Lab 2
*/

package lab2;

import java.io.*;



public class Main {
    private static BufferedReader consoleReader;
    private static BufferedReader fileReader;
    private static BufferedWriter fileWriter;

    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        String input = consoleInput("");
        boolean running = true;
        while(running) {

            try {
                switch (input) {
                    case "end":
                        System.out.println("Bye.");
                        running = false;
                        break;

                    case "1":
                        System.out.println("File name: ");
                        String fileName = consoleInput("");
                        if (!fileName.equals("Sourcetext.txt")) {
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
                        System.out.println("Output format (0 or 1): ");
                        String formatChoice = consoleInput("");
                        int formatChoiceAsInt = Integer.parseInt(formatChoice);
                        Word.changeOutputFormat(formatChoiceAsInt);
                        System.out.println(dictionary.toString());

                    case "3":
                        dictionary.removeDuplicates();
                        dictionary.sortDictionaryByCounts();

                    case "4":
                        dictionary.countOccurrences();

                    case "5":
                        System.out.println("Filename: ");
                        String filename2 = consoleInput("");
                        if (!filename2.equals("Sourcetext.txt")) {
                            System.out.println("File does not exist!");
                        }else{
                            FileWriter fwr = new FileWriter("src/Lab2/Sourcetext.txt");
                            BufferedWriter bw = new BufferedWriter(fwr);

                            //probably wrong
                            String toBeWritten = dictionary.toString();

                        }

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
