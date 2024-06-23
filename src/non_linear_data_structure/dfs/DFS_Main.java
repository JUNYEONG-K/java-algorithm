package non_linear_data_structure.dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS_Main {
    public static void main(String[] args) {
        DFS graph = new DFS();
        graph.init();

        List<Integer> dfs = graph.recursiveDFS(1, new ArrayList<>());
        System.out.println("dfs = " + dfs);

        List<Integer> dfs1 = graph.iterativeDFS(1);
        System.out.println("dfs1 = " + dfs1);
    }
}
