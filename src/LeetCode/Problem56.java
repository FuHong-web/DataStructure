package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/21 23:23
 * @desc:力扣第56题：合并区间
 */
public class Problem56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return null;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merged=new ArrayList<int[]>();
        for (int i=1;i<intervals.length;i++){
            int l=intervals[i][0];
            int r=intervals[i][1];
            if (merged.size()==0||merged.get(merged.size()-1)[1]<l){
                merged.add(new int[]{l,r});
            }else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],r);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }
}
