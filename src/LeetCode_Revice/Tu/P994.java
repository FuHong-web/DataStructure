package LeetCode_Revice.Tu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/11 23:08
 * @desc:腐烂的橘子
 */
public class P994 {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        // 初始化：把所有烂橘子入队，统计新鲜橘子
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // 没有新鲜橘子
        if (fresh == 0) return 0;

        // 四个方向
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int time = 0;

        // BFS 层序遍历（按分钟扩散）
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // 感染
                        queue.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;
        }

        // 全部感染成功返回时间，否则 -1
        return fresh == 0 ? time : -1;
    }
}
