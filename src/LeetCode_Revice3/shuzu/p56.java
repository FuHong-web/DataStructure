package LeetCode_Revice3.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*合并区间*/
public class p56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals);
        List<int[]> res= new ArrayList<>();
        res.add(intervals[0]);
        for(int i =1;i<intervals.length;i++){
            int[] last = res.get(res.size()-1);
            int[] cur = intervals[i];
            if(cur[0] <= last[1]){
                last[1] = Math.max(last[1],cur[1]);
            }else {
                res.add(cur);
            }
        }
        return res.toArray(new int[0][]);
    }
}
