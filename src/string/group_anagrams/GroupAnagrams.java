package string.group_anagrams;

import java.util.*;

public class GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> results = new HashMap<>();

        for (String string : strings) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);

            String key = String.valueOf(charArray);

            if (!results.containsKey(key)) results.put(key, new ArrayList<>());
            results.get(key).add(string);
        }

        return new ArrayList<>(results.values());
    }

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "ant", "cat"};
        List<List<String>> groupedAnagrams = groupAnagrams(strings);
        System.out.println("groupedAnagrams = " + groupedAnagrams);
    }
}
