package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/20 16:32
 * @desc:力扣第1346题
 */
public class Problem1346 {
    public static void main(String[] args) {
        int[] nums={1,7,9,6,3};
        Problem1346 p1346 = new Problem1346();
        System.out.println(p1346.checkIfExist1(nums));
    }
    //方法一：双重遍历
    public boolean checkIfExist1(int[] arr) {
        Arrays.sort(arr);
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]==2*arr[i]){
                    return true;
                }
            }
        }
        return false;
    }
    //方法二：双指针
    public boolean checkIfExist2(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        // 处理负数和零的情况：从左到右遍历
        int left = 0;
        while (left < n) {
            int right = left + 1;
            // 只在负数和零的范围内查找
            while (right < n && arr[right] <= 0) {
                if (arr[right] * 2 == arr[left]) {
                    return true;
                }
                // 负数区域右移数值变大，无法满足条件时跳出
                if (arr[right] > arr[left]) {
                    break;
                }
                right++;
            }
            left++;
        }
        // 处理正数的情况：从右到左遍历
        int right = n - 1;
        while (right >= 0) {
            int leftPtr = right - 1;
            // 只在正数范围内查找
            while (leftPtr >= 0 && arr[leftPtr] > 0) {
                if (arr[leftPtr] * 2 == arr[right]) {
                    return true;
                }
                // 正数区域左移数值变小，无法满足条件时跳出
                if (arr[leftPtr] < arr[right]) {
                    break;
                }
                leftPtr--;
            }
            right--;
        }

        // 未找到符合条件的两个数
        return false;
    }
}
