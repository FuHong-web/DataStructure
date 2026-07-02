package Revice2.tu;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/2 23:24
 * @desc:岛屿数量
 */
public class p200 {
    public int numIsIands(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int row,int col) {
        if (row <0||row>grid.length||col<0||col>grid[0].length||grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }
}
