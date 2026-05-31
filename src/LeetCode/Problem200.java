package LeetCode;

import javax.swing.plaf.PanelUI;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/7 23:20
 * @desc:岛屿数量
 */
public class Problem200 {
    public int numIslands(char[][] grid) {
        int nums = 0;
        int rows = grid.length;
        if (rows == 0) return nums;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    bfs(grid, row, col);
                    nums++;
                }
            }
        }
        return nums;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        grid[row][col] = '0'; // 标记已访问

        // 上下左右四个方向
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int r = tmp[0];
            int c = tmp[1];

            for (int[] dir : dirs) {
                int tmpRow = r + dir[0];
                int tmpCol = c + dir[1];
                // 合法范围 + 是陆地
                if (tmpRow >= 0 && tmpRow < grid.length &&
                        tmpCol >= 0 && tmpCol < grid[0].length &&
                        grid[tmpRow][tmpCol] == '1') {

                    queue.offer(new int[]{tmpRow, tmpCol});
                    grid[tmpRow][tmpCol] = '0';
                }
            }
        }
    }
}
