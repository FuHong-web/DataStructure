package LeetCode_Revice5.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*合并区间*/
public class p56 {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals,(a,b) ->a[0]-b[0]);
        List<int[]>  res = new ArrayList<>();
        res.add(intervals[0]);
        for (int[] interval : intervals) {
            int[] cur = interval;
            int[] last = res.get(res.size()-1);
            if(cur[0] <= last[1]){
                last[1] = Math.max(last[1],cur[1]);
            }else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][]);
    }
}
