package LeetCode;

/**
 * @author: Yan Tong xue
 * @Created:2025/9/11 19:45
 * @desc:力扣第26题：删除数组重复的元素
 */
public class Problem26 {
    public static void main(String[] args) {
        int[] nums={1,2,2,2,3,4,5,5,6};
        Problem26 p26 = new Problem26();
        System.out.println(p26.removeDuplicates(nums));

    }
    public int removeDuplicates(int[] nums) {
                int n = nums.length;
                int j = 0;
                for (int i = 0; i < n; i++) {
                    if (nums[i] != nums[j]) {
                        nums[++j] = nums[i];
                    }
                }
                return j + 1;
            }
        }


