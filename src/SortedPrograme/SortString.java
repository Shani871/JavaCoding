package SortedPrograme;

import java.util.*;

public class SortString {
    public static void main(String[] args) {
        int X = 79;
        String str = "Even 78 Bob 99 Suzy 88 Alice 86";

        // Split the string into individual words
        String[] words = str.split("\\s+");

        List<String> filteredWords = new ArrayList<>();

        // Iterate through each word
        for (int i = 0; i < words.length; i++) {
            // Extract numeric value from the word
            if (words[i].matches("\\d+")) {
                int value = Integer.parseInt(words[i]);
                // Remove words where numeric value is smaller than X
                if (value >= X) {
                    filteredWords.add(words[i-1]); // Add the associated word
                    filteredWords.add(words[i]);   // Add the numeric value
                }
            }
        }

        // Sort the remaining words in decreasing order of their numeric values
        Collections.sort(filteredWords, Collections.reverseOrder());

        // Join the sorted words back into a single string
        String sortedStr = String.join(" ", filteredWords);

        System.out.println("Sorted String: " + sortedStr);
    }
}
