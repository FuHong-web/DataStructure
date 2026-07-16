package LeetCode_Revice2.tu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/2 23:39
 * @desc:腐烂的橘子
 */
public class p994 {
    public int orangeRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }else if (grid[i][j] == 1){
                    freCount++;
                }
            }
        }
        if (freCount == 0) return 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minute = 0;
        while (!queue.isEmpty()) {
            int curLayerSize = queue.size();
            boolean spred = false;
            for (int k = 0; k < curLayerSize; k++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc] ==1) {
                        grid[nr][nc] = 2;
                        queue.add(new int[]{nr,nc});
                        freCount--;
                        spred=true;
                    }
                }
            }
            if (spred) minute++;
        }
        return freCount == 0 ? minute:-1;
    }
}
