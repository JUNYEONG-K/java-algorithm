package non_linear_data_structure.bfs;

import java.util.*;
import java.util.function.BiConsumer;

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
                    System.out.println("w = " + w);
                    queue.add(w);
                }
            }
        }

        return discovered;
    }

    List<Integer> iterativeBFSUsingHelper(int start_v) {
        List<Integer> discovered = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 노드를 발견하고 큐에 추가하는 헬퍼 메서드
        BiConsumer<Integer, Queue<Integer>> addNode = (w, q) -> {
            discovered.add(w);
            System.out.println("w = " + w);
            q.add(w);
        };

        addNode.accept(start_v, queue);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.get(v)) {
                if (!discovered.contains(w)) {
                    addNode.accept(w, queue);
                }
            }
        }

        return discovered;
    }

}
