package algorithms.sort.valid_anagram;

import java.util.Arrays;

public class ValidAnagram {
    public static String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
    public static boolean isAnagram(String s, String t) {
        return sort(s).equals(sort(t));
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagarma";
        System.out.println("isAnagram(s, t) = " + isAnagram(s, t));
    }
}
