package LeetCode_Revice3.huisu;

import java.util.ArrayList;
import java.util.List;
/*全排列*/
public class p46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(res, temp, nums);
        return res;
    }

    private void help(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (!temp.contains(num)) {
                temp.add(num);
                help(res, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
