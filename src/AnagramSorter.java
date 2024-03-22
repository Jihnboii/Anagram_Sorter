/**************************************************************/
/* Jonathan Rodriguez                                         */
/* CS 3310, Spring 2024                                       */
/* Programming Assignment 2                                   */
/* AnagramSorter class: for a list of words, inputted in as   */
/*                      a .txt file, it will group the words  */
/*                      as anagrams and output it as a new    */
/*                      .txt file                             */
/**************************************************************/
import java.io.*;
import java.util.*;

public class AnagramSorter {
    /**************************************************************/
    /* Method: sortAnagrams                                       */
    /* Purpose: Group words into anagram groups using sorting     */
    /*          and hashmaps                                      */
    /* Parameters:                                                */
    /*   - String[] words: An array of words to be sorted into    */
    /*                     anagram groups                         */
    /* Returns: List<List<String>>: Anagram groups represented    */
    /*                              as a 2D ArrayList             */
    /**************************************************************/
    public static List<List<String>> sortAnagrams(String[] words) {
        // Hashmap stores String keys associated with String ArrayList values
        Map<String, List<String>> map = new HashMap<>();

        // Step 1: Group words by their sorted letters
        for (String word : words) {
            String sortedWord = sortWord(word.toLowerCase()); //Ignore case
            // If key exists, return the ArrayList associated, else, create one
            List<String> anagramGroup = map.getOrDefault(sortedWord, new ArrayList<>());
            //Add the word to the ArrayList associated with 'sortedWord'
            anagramGroup.add(word);
            //Add to the hashmap the sortedWord as a key and the ArrayList as a value
            map.put(sortedWord, anagramGroup);
        }

        // Step 2: Collect grouped anagrams into a result list
        List<List<String>> result = new ArrayList<>(); //Holds anagram groups
        // Add every anagramGroup in the hashmap to the result
        result.addAll(map.values());

        return result;
    }

    /**************************************************************/
    /* Method: sortWord                                           */
    /* Purpose: Sort a word alphabetically                        */
    /* Parameters:                                                */
    /*   - String word: The word to be sorted alphabetically      */
    /* Returns: String: The word sorted alphabetically            */
    /**************************************************************/
    public static String sortWord(String word) {
        char[] charArray = word.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) throws IOException {

        String filename;

        // If user provides no .txt, a default file is used
        if (args.length == 0) {
            // Explains how it is used
            System.out.println("Usage: java AnagramSorter <input_file>");

            System.out.println("Using Default File: 'SampleWords.txt'");
            filename = "SampleWords.txt";
        } else {
            // Get File from command line
            filename = args[0];
        }

        // Putting each word into an ArrayList
        List<String> words = new ArrayList<>();

        // Read from the file, line by line
        try (Scanner scnr = new Scanner(new FileReader(filename))) {
            while (scnr.hasNextLine()) {
                words.add(scnr.nextLine());
            }
        } catch (FileNotFoundException e) { //Error Message
            System.out.println("File '" + filename + "' not found");
            System.out.println("Refer to Usage section on README.txt");
            return;
        }

        // Use sortAnagrams to get the list sorted into groups
        List<List<String>> anagramGroups = sortAnagrams(words.toArray(new String[0]));

        // Writing anagrams to a .txt file
        try (PrintWriter writer = new PrintWriter(new FileWriter("AnagramGroups.txt"))) {
            // For each anagram group
            for (List<String> group : anagramGroups) {
               writer.println(group); // Print out the sets
            }
        }

        // Confirm to user that .txt has been created
        System.out.println("Anagrams have been written to AnagramGroups.txt");
    }
}
