package linear_data_structure.hash_table.top_k_frequent_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums)
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

        // 빈도수 역순으로 pq 에 저장 (int[] {값, 빈도수}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int element : frequencyMap.keySet()) {
            pq.add(new int[]{element, frequencyMap.get(element)});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) result[i] = pq.poll()[0];

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4};
        int k = 2;
        int[] topKFrequent = topKFrequent(nums, k);
        System.out.println("topKFrequent = " + Arrays.toString(topKFrequent));
    }
}
