package Revice2.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/30 22:45
 * @desc:组合总和
 */
public class p39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(res,temp,0,target,candidates);
        return res;
    }
    private void help(List<List<Integer>> res,List<Integer> temp ,int start,int target,int[] candidates) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start;i<candidates.length;i++){
            temp.add(candidates[i]);
            help(res,temp,i,target-candidates[i],candidates);
            temp.remove(temp.size()-1);
        }
    }
}
