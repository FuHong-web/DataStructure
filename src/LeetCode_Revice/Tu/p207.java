package LeetCode_Revice.Tu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/11 23:10
 * @desc:课程表
 */
public class p207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. 建图：邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 2. 入度数组
        int[] inDegree = new int[numCourses];

        // 3. 初始化邻接表和入度
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);
            inDegree[course]++;
        }

        // 4. 队列：入度为0的节点入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            // 遍历当前节点的所有后继节点
            for (int next : adj.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // 能完成所有课程（无环）
        return count == numCourses;
    }
}
