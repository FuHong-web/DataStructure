package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/11 19:45
 * @desc:力扣第26题：删除数组重复的元素
 */
public class Problem26 {
    public int removeDuplicates(int[] nums) {
                int n = nums.length;
                int j = 0;
                for (int i = 0; i < n; i++) {
                    if (nums[i] != nums[j]) {
                        j++;
                        nums[j] = nums[i];
                    }
                }
                return j + 1;
            }
        }


