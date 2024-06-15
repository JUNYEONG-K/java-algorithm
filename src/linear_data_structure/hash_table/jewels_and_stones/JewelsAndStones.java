package linear_data_structure.hash_table.jewels_and_stones;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {
    static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : S.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int result = 0;
        for (char c : J.toCharArray()) {
            if (map.containsKey(c)) result += map.get(c);
        }

        return result;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAABBCcd";
        int result = numJewelsInStones(J, S);
        System.out.println("result = " + result);
    }
}
