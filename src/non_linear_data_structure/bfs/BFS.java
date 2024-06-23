package non_linear_data_structure.bfs;

import java.util.*;

public class BFS {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    void init() {
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, List.of(5));
        graph.put(3, List.of(5));
        graph.put(4, List.of());
        graph.put(5, Arrays.asList(6, 7));
        graph.put(6, List.of());
        graph.put(7, List.of(3));
    }

    List<Integer> iterativeBFS(int start_v) {
        List<Integer> discovered = new ArrayList<>();
        discovered.add(start_v);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start_v);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.get(v)) {
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }

        return discovered;
    }
}
