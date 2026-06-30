package Revice2.zhan;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/26 23:23
 * @desc:柱状图最大面积
 */
public class p84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int maxArea = 0;

        // 遍历每一根柱子，把它当作矩形的高度
        for (int i = 0; i < len; i++) {
            int currHeight = heights[i];
            int left = i;
            // 向左找：只要左边柱子 >= 当前高度，就继续往左扩
            while (left > 0 && heights[left - 1] >= currHeight) {
                left--;
            }

            int right = i;
            // 向右找：只要右边柱子 >= 当前高度，就继续往右扩
            while (right < len - 1 && heights[right + 1] >= currHeight) {
                right++;
            }

            // 左右边界之间的宽度
            int width = right - left + 1;
            int area = width * currHeight;
            // 更新最大面积
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
