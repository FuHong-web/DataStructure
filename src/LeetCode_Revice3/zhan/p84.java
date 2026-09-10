package LeetCode_Revice3.zhan;
/*柱状图的最大矩阵*/
import java.util.Stack;

public class p84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            right[i] = n;
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int index = stack.pop();
                right[index] = i;
            }
            stack.push(i);
        }
        stack.clear();

        for (int i = n-1;i >= 0;i--){
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                left[index] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] -2;
            maxArea = Math.max(maxArea,len * heights[i]);
        }
        return maxArea;
    }
}
