/*
Author(s): Laith Oudah & Klas Nordquist
Assignment - Lab 2
*/

package lab2;

public class Word {
    private String theWord;
    private int counts;
    private static int outputFormat;

    //constructor
    public Word(String theWord) {
        this.theWord = theWord;
        counts = 1;
    }

    public String getWord() {
        return theWord;
    }

    public int getCounts() {
        return counts;
    }

    public void increaseCounts() {
        counts++;
    }

    public static void changeOutputFormat(int arg) {
        if (arg == 0) {
            outputFormat = 0;
        } else {
            outputFormat = 1;
        }
    }

    public String toString() {
        if (outputFormat == 0) {
            return "The word " + getWord() + " has occurred " + getCounts() + " times.";
        } else {
            return "The word is: " + getWord();
        }
    }
}