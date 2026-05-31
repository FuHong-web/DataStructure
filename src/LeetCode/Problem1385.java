package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/20 17:36
 * @desc:力扣第1385题
 */
public class Problem1385 {
    public static void main(String[] args) {

    }
    //方法一：直接遍历
    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        int count=0;
        for (int i = 0; i < arr1.length; i++) {
            boolean isValid = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i]-arr2[j])>=d){
                    isValid=false;
                    break;
                }
            }
            if (isValid){
                count++;
            }
        }
        return count;
    }
    //方法二：双指针+二分查找
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count=0;
        for (int num1 : arr1) {
            int lower=num1-d;
            int high=num1+d;
            int left=0;
            int right=arr2.length-1;
            boolean isValid=true;
            while (left<right){
                int mid=left+(right-left)/2;
                if (arr2[mid]>=lower&&arr2[mid]<=high){
                   isValid=false;
                   break;
                } else if (arr2[mid]<lower) {
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
            if (!isValid){
               count++;
            }
        }
        return count;
    }
}
