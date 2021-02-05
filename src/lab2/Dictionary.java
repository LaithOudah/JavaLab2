/*
Author(s): Laith Oudah & Klas Nordquist
Assignment - Lab 2
*/

package lab2;

import java.util.*;

public class Dictionary {

    private ArrayList<Word> theDictionary;

    public Dictionary() {
        this.theDictionary = new ArrayList<>();
    }

    public void addWords(String arg) {
        String[] words = arg.split(" ");
        for (String s : words) {
            s = s.replace(" ", "");
            Word word = new Word(s);
            theDictionary.add(word);
        }
    }

    public int numberOfWords() {
        return theDictionary.size();
    }

    // Flyttar allt till vänster så man måste backa loppen.
    public void removeDuplicates() {
        for (int i = 0; i < theDictionary.size(); i++) {
            ArrayList<Word> foundWords = new ArrayList<>();
            Word compare = theDictionary.get(i);
            for (int j = i + 1; j < theDictionary.size(); j++) {
                Word temp = theDictionary.get(j);
                if (temp.getWord().equals(compare.getWord()))
                    foundWords.add(temp);
            }
            for (Word word : foundWords) {
                compare.increaseCounts();
                theDictionary.remove(word);
            }
        }
    }

    // Använda SET funktion för att inte flytta allt till vänster, så vi inte byter plats. då de är en dynamisk array.
    public void sortDictionaryByCounts() {
        ArrayList<Word> newDictionary = new ArrayList<>();
        for (int i = 0; i < theDictionary.size(); ) {
            Word highest = theDictionary.get(i);
            for (int j = i + 1; j < theDictionary.size(); j++) {
                Word newWord = theDictionary.get(j);
                if (newWord.getCounts() > highest.getCounts())
                    highest = newWord;
            }
            newDictionary.add(highest);
            theDictionary.remove(highest);
        }
        theDictionary = newDictionary;
    }

    public void countOccurrences() {
        removeDuplicates();
        sortDictionaryByCounts();
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < theDictionary.size(); i++) {
            int countWords = 1;
            for (int j = i + 1; j < theDictionary.size(); j++) {
                if (theDictionary.get(i).getCounts() == theDictionary.get(j).getCounts())
                    countWords++;
            }
            if (i == 0)
                temp.append(String.format("%d" + " words occured " + "%d times\n", countWords, theDictionary.get(i).getCounts()));
            else if (theDictionary.get(i).getCounts() != theDictionary.get(i - 1).getCounts()) {
                temp.append(String.format("%d" + " words occured " + "%d times\n", countWords, theDictionary.get(i).getCounts()));
            }
        }
        System.out.println(temp);
    }

    /*
        public void countOccurrences() {
            removeDuplicates();
            sortDictionaryByCounts();
            for (Word e : theDictionary)
                System.out.println(e.getWord() + ":" + e.getCounts() + " ");

            //System.out.println(theDictionary);
        }
    */
    //though is good, probably wont work.
    public String toString() {
        StringBuilder myString = new StringBuilder();
        for (int i = 0; i < numberOfWords(); i++) {
            myString.append("\n").append(theDictionary.get(i).toString());
        }
        String done = myString.toString();
        return done;
    }
}
