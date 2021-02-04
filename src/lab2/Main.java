/*
Author(s): Laith Oudah & Klas Nordquist
Assignment: Lab 2
*/

package lab2;
//This is a comment
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class Main {
    private static BufferedReader consoleReader;
    private static BufferedReader fileReader;
    private static BufferedWriter fileWriter;

    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("src/Lab2/Sourcetext.txt");
        BufferedReader br = new BufferedReader(fr);

        String result;

        while ((result = br.readLine()) != null) {
            Dictionary dictionary = new Dictionary();
            dictionary.addWords(result);
            dictionary.countOccurrences();
            System.out.println(result);
        }
    }

    public static String consoleInput(String arg) {

        return null; //fix later//stuff //test push
    }

}
