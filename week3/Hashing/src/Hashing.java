import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.util.ArrayList;
import java.util.List;

public class Hashing {
    public static void main(String[] args) {
        // Record start time
        long startTime = System.currentTimeMillis();

        BinarySearchST<String, Integer> bookWords = new BinarySearchST<>();
        In file = new In("assets/tale2022v2.txt");

        while (!file.isEmpty()) {
            String word = file.readString();
            if (bookWords.contains(word)) {
                bookWords.put(word, bookWords.get(word) + 1);
            } else {
                bookWords.put(word, 1);
            }
        }

        // Print the frequency of each word
        for (String word : bookWords.keys()) {
            int frequency = bookWords.get(word);
            System.out.println(word + ": " + frequency);
        }

        // Find the most and least frequently used words
        List<String> mostFrequentWords = new ArrayList<>();
        List<String> leastFrequentWords = new ArrayList<>();
        int maxFrequency = 0;
        int minFrequency = Integer.MAX_VALUE;

        String longestWord = "";
        for (String word : bookWords.keys()) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }

            int frequency = bookWords.get(word);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentWords.clear();
                mostFrequentWords.add(word);
            } else if (frequency == maxFrequency) {
                mostFrequentWords.add(word);
            }

            if (frequency < minFrequency) {
                minFrequency = frequency;
                leastFrequentWords.clear();
                leastFrequentWords.add(word);
            } else if (frequency == minFrequency) {
                leastFrequentWords.add(word);
            }
        }

        // Record end time
        long endTime = System.currentTimeMillis();

        System.out.println("Longest word: " + longestWord);
        System.out.println("Most frequently used word(s): " + mostFrequentWords);
        System.out.println("Least frequently used word(s): " + leastFrequentWords);

        // Calculate and print the total runtime
        long totalTime = endTime - startTime;
        System.out.println("Total runtime: " + totalTime + " milliseconds");
    }
}
