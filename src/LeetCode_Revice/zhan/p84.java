package LeetCode_Revice.zhan;

import java.util.Stack;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/31 12:33
 * @desc:柱状图的最大矩阵（栈）
 * 核心一句话
 * 用单调栈找每个柱子：左边第一个比它矮的，右边第一个比它矮的。
 * 中间这一段，就是这个柱子能撑起的最大宽度！
 * 面积 = 高度 × 宽度
 * 宽度 = 右边界 - 左边界 - 1
 *
 * 遇到比栈顶高的 → 直接入栈（保持递增）
 * 遇到比栈顶矮的 →
 * 弹出栈顶
 * 用它高度
 * 用当前 i 当右边界
 * 用新栈顶当左边界
 * 算面积！
 * 最后一个 0 会把所有剩余柱子全部算完
 */
public class p84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        /*
        * 把 heights 数组，从第 0 位开始，
        复制到 h 数组的 第 1 位开始，
        复制长度 = 原数组长度*/
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
