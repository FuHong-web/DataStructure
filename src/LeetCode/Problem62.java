package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/12 10:21
 * @desc:力扣第62题：不同路径（动态规划）
 * 核心思想：每个位置的路径数 = 上方位置路径数 + 左方位置路径数（因为只能从这两个方向来）。
 * 初始化：第一行 / 第一列只有 1 种走法（只能沿一个方向走）。
 * 计算顺序：从左到右、从上到下，先算简单的格子，再算复杂的格子。
 */
public class Problem62 {
    public int uniquePaths(int m, int n){
        int[][] result = new int[m][n];
        //第一列只有一种走法：一直往下走
        for (int i=0;i<m;i++){
            result[i][0]=1;
        }
        //第一行只有一种走法：一直往右走
        for (int j=0;j<n;j++){
            result[0][j]=1;
        }
        for (int i = 1; i <m; i++) {
            for (int j = 1; j <n; j++) {
                result[i][j]=result[i-1][j]+result[i][j-1];//每个位置的路径数等于上方路径数+左方路径数（因为只能从这两个方向来）
            }
        }
        return result[m-1][n-1];//返回右下角位置的路径数即可
    }

}
