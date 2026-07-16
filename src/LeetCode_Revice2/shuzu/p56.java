package LeetCode_Revice2.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/25 21:23
 * @desc:合并区间
 */
public class p56 {
    public int[][] merge (int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1;i < intervals.length;i++) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            int[] lastInterval = res.get(res.size() -1 );
            int lastRight = lastInterval[1];
            if (curLeft <= lastRight) {
                lastInterval[1] = Math.max(lastRight,curRight);
            }else {
                res.add(new int[]{curLeft,curRight});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
