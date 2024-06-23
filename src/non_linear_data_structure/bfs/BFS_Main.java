package non_linear_data_structure.bfs;

import java.util.List;

public class BFS_Main {
    public static void main(String[] args) {
        BFS graph = new BFS();
        graph.init();

        List<Integer> bfs = graph.iterativeBFS(1);
        System.out.println("bfs = " + bfs);
    }
}
