package linear_data_structure.priority_queue.scoville;

import java.util.PriorityQueue;

public class Scoville {
    static int solution(int[] scoville, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : scoville) pq.add(num);

        int count = 0;
        while (pq.size() >= 2) {
            pq.add(pq.poll() + pq.poll() * 2);
            if (pq.peek() >= k) return count;
            count++;
        }

        return -1;
    }
}
