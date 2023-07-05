import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        
        Queue q = new ArrayDeque<>();
       Object o =  q.poll();
        q.offer(111);
        q.offer("xxx");
        
       o =  q.poll();
       
       q.add("xxxx");
       Object oo = q.peek();
       
       System.out.println();
        

        int [] x = new int[10];

        Arrays.fill(x,1);
        Arrays.fill(x,0);
        Arrays.fill(x,2);

        int[][] grid = new int[][]{{0,0,1},{0,1,1},{1,0,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0, 0});
        dist[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int x = arr[0], y = arr[1];
            if (x == n - 1 && y == n - 1) {
                return dist[x][y];
            }
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (x + dx < 0 || x + dx >= n || y + dy < 0 || y + dy >= n) { // 越界
                        continue;
                    }
                    if (grid[x + dx][y + dy] == 1 || dist[x + dx][y + dy] <= dist[x][y] + 1) { // 单元格值不为 0 或已被访问
                        continue;
                    }
                    dist[x + dx][y + dy] = dist[x][y] + 1;
                    queue.offer(new int[]{x + dx, y + dy});
                }
            }
        }
        return -1;
    }
}