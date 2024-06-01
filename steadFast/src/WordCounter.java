import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {
    public static void main(String[] args) {

        String filePath = "E:\\Java\\steadFast\\src";

        try {
            Map<String, Integer> wordCountMap = countWords(filePath);
            displayWordCount(wordCountMap);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countWords(String filePath) throws IOException {
        Map<String, Integer> wordCountMap = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line.split("[\\s\\p{Punct}]+");
                for (String word : words) {

                    word = word.toLowerCase();

                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordCountMap;
    }

    public static void displayWordCount(Map<String, Integer> wordCountMap) {
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

