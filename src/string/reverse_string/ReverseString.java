package string.reverse_string;

import java.util.Arrays;

public class ReverseString {
    static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++; end--;
        }
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        System.out.println("origin = " + Arrays.toString(arr));
        reverseString(arr);
        System.out.println("reversed = " + Arrays.toString(arr));
    }
}
