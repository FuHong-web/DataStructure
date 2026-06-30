package Revice2.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/30 21:51
 * @desc:全排列
 */
public class p46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(res,temp,nums);
        return res;
    }
    private void help(List<List<Integer>> res,List<Integer> temp,int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean isAdd = false;
            for (int num : temp) {
                if (nums[i] == num) {
                    isAdd = true;
                    break;
                }
            }
            if (!isAdd) {
                temp.add(nums[i]);
                help(res,temp,nums);
                temp.remove(temp.size()-1);
            }
        }
    }
}
