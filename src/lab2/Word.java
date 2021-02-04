/*
Author(s): Laith Oudah & Klas Nordquist
Assignment: Lab 2
*/

package lab2;

class Word implements Comparable<Word> {
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
        String arg1 = theWord;
        int arg2 = counts;
        if (outputFormat == 0) {
            return "The word " + arg1 + " has occurred " + arg2 + " times.";
        } else {
            return "The word is: " + arg1; //test
        }
    }

    @Override
    public int compareTo(Word o) {
        return this.counts - o.getCounts();
    }
}