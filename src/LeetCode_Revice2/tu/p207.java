package LeetCode_Revice2.tu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/2 23:56
 * @desc:课程数量
 */
public class p207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            adj.get(pre).add(course);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath  = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj,i,visited,onPath)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj,int cur,boolean[] visited,boolean[] onPath){
        if (onPath[cur]) return false;
        if (visited[cur]) return true;
        visited[cur] = true;
        onPath[cur] = true;
        for (Integer next : adj.get(cur)) {
            if (!dfs(adj,next,visited,onPath)){
                return false;
            }
        }
        onPath[cur] = false;
        return true;
    }


}
