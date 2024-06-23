package non_linear_data_structure.dfs;

import java.util.*;

public class DFS {
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

    List<Integer> recursiveDFS(int v, List<Integer> discovered) {
        discovered.add(v);
        System.out.println("v = " + v);
        for (Integer w : graph.get(v)) {
            if (!discovered.contains(w)) {
                discovered = recursiveDFS(w, discovered);
            }
        }
        return discovered;
    }

    List<Integer> iterativeDFS(int v) {
        List<Integer> discovered = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(v);
        while (!stack.isEmpty()) {
            v = stack.pop();
            if (!discovered.contains(v)) {
                discovered.add(v);
                System.out.println("v = " + v);
                for (int w : graph.get(v)) stack.push(w);
            }
        }

        return discovered;
    }
}
