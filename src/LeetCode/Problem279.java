package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/25 23:57
 * @desc:力扣第279：完全平方数（动态规划）
 */
public class Problem279 {
    public int numSquares(int n) {
        // 生成所有小于 n 的完全平方数
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        // BFS 队列，存储当前值和步数
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{n, 0});

        // 访问记录，避免重复计算
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cur = current[0];
            int level = current[1];

            for (int square : squares) {
                int nextVal = cur - square;

                if (nextVal == 0) {
                    return level + 1;
                }

                if (nextVal > 0 && !visited[nextVal]) {
                    visited[nextVal] = true;
                    queue.offer(new int[]{nextVal, level + 1});
                }
            }
        }

        return n;
    }
}
