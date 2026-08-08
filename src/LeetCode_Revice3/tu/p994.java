package LeetCode_Revice3.tu;

import java.util.LinkedList;
import java.util.Queue;

/*腐烂的橘子*/
public class p994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int time= 0;
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        if(fresh == 0) return 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for(int k = 0;k<size;k++){
                int[] cur = queue.poll();
                int x = cur[0],y = cur[1];
                for(int[] d : dirs){
                    int nx = x + d[0], ny = y+ d[1];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        fresh--;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
            time++;
        }
        return fresh > 0 ? -1:time;
    }
}
