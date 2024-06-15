package linear_data_structure.priority_queue.k_closest_points_to_origin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static class Point {
        double distance;
        int[] point;

        public Point(int[] point) {
            this.distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            this.point = point;
        }
    }

    static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o.distance));

        for (int[] point : points) pq.add(new Point(point));

        int[][] results = new int[k][];
        for (int i = 0; i < k; i++) results[i] = Objects.requireNonNull(pq.poll()).point;

        return results;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {6, -1}, {-2, 4}};
        int k = 2;

        int[][] results = kClosest(points, k);
        System.out.println("results = " + Arrays.deepToString(results));
    }
}
