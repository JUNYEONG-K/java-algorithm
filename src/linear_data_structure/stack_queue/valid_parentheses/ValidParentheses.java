package linear_data_structure.stack_queue.valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    static boolean isValid(String s) {
        Map<Character, Character> table = new HashMap<>(){{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (!table.containsKey(s.charAt(i))) stack.push(s.charAt(i));
            else if (stack.isEmpty() || table.get(s.charAt(i)) != stack.pop()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "[]{}()";
        boolean valid = isValid(s);
        System.out.println("valid = " + valid);
    }
}
