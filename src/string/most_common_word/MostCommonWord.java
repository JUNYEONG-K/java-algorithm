package string.most_common_word;

import java.util.*;

public class MostCommonWord {
    static String mostCommonWord(String p, String[] banned) {
        Set<String> bannedWordsSet = new HashSet<>(Arrays.asList(banned));
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (bannedWordsSet.contains(word)) continue;
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String p = "Ross hit a ball, the hit BALL flew far away after it was hit.";
        String[] banned = {"hit"};
        String mostCommonWord = mostCommonWord(p, banned);
        System.out.println("mostCommonWord = " + mostCommonWord);
    }
}
