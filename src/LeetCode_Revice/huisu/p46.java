package LeetCode_Revice.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/12 22:45
 * @desc:全排列
 */
public class p46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        back(res,nums,temp);
        return res;
    }

    private void back(List<List<Integer>> res,int[] nums,List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean isExists = false;
            for (int j = 0;j <temp.size();j++) {
                if (nums[i] == temp.get(j)) {
                    isExists = true;
                    break;
                }
            }
            if (!isExists) {
                temp.add(nums[i]);
                back(res,nums,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
