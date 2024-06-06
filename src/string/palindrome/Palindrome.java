package string.palindrome;

public class Palindrome {
    static boolean isPalindromeByCompareChars(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) start++;
            if (!Character.isLetterOrDigit(s.charAt(end))) end--;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start++; end--;
        }

        return true;
    }

    static boolean isPalindromeByCompareString(String s) {
        String origin = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println("origin = " + origin);
        String reversed = new StringBuilder(origin).reverse().toString();
        return origin.equals(reversed);
    }

    public static void main(String[] args) {
        String s = "Hello World dlroW olleH";
//        boolean palindrome = isPalindromeByCompareChars(s);
        boolean palindrome = isPalindromeByCompareString(s);
        System.out.println("palindrome = " + palindrome);
    }
}
