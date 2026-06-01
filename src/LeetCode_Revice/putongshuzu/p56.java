package LeetCode_Revice.putongshuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/1 22:54
 * @desc:合并数组
 * 先排序 → 先放第一个区间 → 后面每个区间和最后一个比：不重叠就加，重叠就合并！
 */
public class p56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0]; // 这里也规范一点，不要返回null
        }

        // 1. 按左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];


            int[] last = merged.get(merged.size() - 1);

            // 如果 最后区间的右端点 < 当前左端点 → 不重叠，直接加
            if (last[1] < l) {
                merged.add(new int[]{l, r});
            }
            // 重叠 → 合并，更新右端点
            else {
                last[1] = Math.max(last[1], r);
            }
        }

        // 转数组返回
        return merged.toArray(new int[merged.size()][]);
    }
}
