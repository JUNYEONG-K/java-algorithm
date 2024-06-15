package linear_data_structure.hash_table.completion_player;

import java.util.HashMap;
import java.util.Map;

public class CompletionPlayer {
    String solution(String[] participant, String[] completion) {
        Map<String, Integer> partitionMap = new HashMap<>();
        for (String player : participant)
            partitionMap.put(player, partitionMap.getOrDefault(player, 0) + 1);

        for (String complete : completion) {
            int left = partitionMap.get(complete);
            if (left == 1) partitionMap.remove(complete);
            else partitionMap.put(complete, left - 1);
        }

        return partitionMap.entrySet().iterator().next().getKey();
    }
}
