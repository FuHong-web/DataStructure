package LeetCode_Revice3.tu;

import com.sun.jdi.InvalidTypeException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*=课程表*/
/*
*
*
* 邻接表 graph
记录谁上完之后，可以解锁哪些课。
graph.get(b).add(a)：上完 b 之后，就能解锁 a。
入度 inDegree [x]
代表课程 x 还有几门前置课没上完。
inDegree[a]++：a 多了一门前置课 b，前置数量 + 1。
* */
public class p207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph= new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for(int[] edge : prerequisites){
            int a = edge[0],b = edge[1];
            graph.get(b).add(a); //b->a
            inDegree[a]++;//a需要一个前置
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
           if(inDegree[i] == 0){
               queue.add(i);
           }
        }
        int count = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            for(int next :graph.get(cur)){
                inDegree[next]--;
                if(inDegree[next]==0){
                    queue.add(next);
                }
            }
        }
        return count==numCourses;

    }

}
