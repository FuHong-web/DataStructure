package LeetCode_Revice3.zhan;
/*柱状图的最大矩阵*/
import java.util.Stack;

public class p84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0;i<n;i++){
            left[i] = -1;
            right[i] = n;
        }
        for (int i = 0; i < n; i++) {
            //右边界
            while (!st.isEmpty() && heights[i] < heights[st.peek()]){
                int index =st.pop();
                right[index] = i;
            }
            //左边界
            if(!st.isEmpty()) {
                left[i] = i;
            }
            st.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] -1;
            int area = width * heights[i];
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}
