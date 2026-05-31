package LeetCode_Revice.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/14 23:13
 * @desc:组合总和
 */
public class p39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(candidates,0,target,res,temp);
        return res;
    }
    private void help(int[] can, int start, int target, List<List<Integer>> res,List<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < can.length; i++) {
            temp.add(can[i]);
            help(can,i,target-can[i],res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
