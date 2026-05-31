package LeetCode;

import java.util.Arrays;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/10 15:08
 * @desc:力扣第349题：两个数组的交集
 */
public class Problem349 {
    public static void main(String[] args) {
        int[] nums1={1,2,3,4,5};
        int[] nums2={2,6};
        Problem349 p349 = new Problem349();
        int[] result = p349.intersection(nums1, nums2);
        for (int num : result) {
            System.out.println(num);
        }
    }
    //方法一：双指针
    public int[] intersection(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m=nums1.length;
        int n=nums2.length;
        int[] intersection=new int[m+n];
        int index1=0;
        int index2=0;
        int index=0;
        while (index1<m&&index2<n){
            int num1=nums1[index1];
            int num2=nums2[index2];
            if (num1==num2){
                if (index==0||num1!=intersection[index-1]){
                    intersection[index++]=num1;
                }
                index1++;
                index2++;
                }else if(num1<num2){
                    index1++;
                }else if (num1>num2){
                    index2++;
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }
}
