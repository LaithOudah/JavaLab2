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


    //trash main
    public static void main(String[] args) throws Exception{

        //consoleInput(arg[0]);
        FileReader fr = new FileReader("src/lab2/Sourcetext.txt");
        BufferedReader br = new BufferedReader(fr);
        String result;
        while((result = br.readLine()) != null){








            Dictionary dictionary = new Dictionary();
            dictionary.addWords(result);
            dictionary.countOccurrences();
            System.out.println(result);
        }
    }



    public static String consoleInput(String arg) throws IOException{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Select option: ");
            String line = consoleReader.readLine();
            switch (line){
                case "end":
                    System.out.println("Bye.");
                    break;
                case "1":
                    System.out.println("Load from file");
                    System.out.println("File name: ");
                    String choice = consoleReader.readLine();
                    if(!choice.equals("Sourcetext.txt")){
                        System.out.println("File does not exist!");
                    }
                    else{
                        FileReader fr = new FileReader("src/lab2/Sourcetext.txt");
                        BufferedReader br = new BufferedReader(fr);
                        String result;
                        while((result = br.readLine()) != null){
                            System.out.println(result);
                        }
                    }
                case "2":
                    System.out.println("List content");
                    System.out.println("Output format (0 or 1): ");
                    int choice2 = consoleReader.read();
                    Word.changeOutputFormat(choice2);

            }

        } catch (IOException e) {
            return "";
        }

        return null;
    }
}