/*
Author(s): Laith Oudah & Klas Nordquist
Assignment: Lab 2
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

    /*
     * Expected output:
     * 1 words occurred 10 times.
     * 2 words occurred 8 times.
     * 1 words occurred 4 times.
     */

    public void countOccurrences() {
        removeDuplicates();
        sortDictionaryByCounts();
        for (Word e : theDictionary)
            System.out.println(e.getWord() + ":" + e.getCounts() + " ");
    }

    public String toString() {
        StringBuilder text = new StringBuilder(" ");
        for (Word i : theDictionary) {
            text.append(i.getWord()).append(" ");
        }
        return text.toString();
    }
}
