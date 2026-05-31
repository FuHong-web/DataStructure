package LeetCode;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/28 23:41
 * @desc:柱状图的最大矩阵（栈）
 */
public class Problem84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] h = new int[heights.length + 2];
        System.arraycopy(heights,0,h,1,heights.length);
        int maxAear = 0;
        for (int i = 0;i < h.length;i++) {
            while (!st.isEmpty() && h[i] < h[st.peek()]) {
                int cur = st.pop();
                int heiht = h[cur];
                int width = i - st.peek() - 1;
                maxAear = Math.max(maxAear,heiht * width);
            }
            st.push(i);
        }
        return maxAear;
    }
}
