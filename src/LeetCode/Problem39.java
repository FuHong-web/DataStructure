package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/17 9:09
 * @desc:力扣第39题：组合总数
 */
public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        help(candidates,target,0,res,temp);
        return res;
    }
    private void help(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> temp) {
        if(target==0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            temp.add(candidates[i]);
            help(candidates,target-candidates[i],i,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
