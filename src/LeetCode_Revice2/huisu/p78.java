package LeetCode_Revice2.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/30 22:18
 * @desc:子集
 */
public class p78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res,0,temp,nums);
        return res;

    }
    private void dfs(List<List<Integer>> res,int pathLen,List<Integer> temp,int[] nums) {
        if (pathLen == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[pathLen]);
        dfs(res,pathLen+1,temp,nums);
        temp.remove(temp.size()-1);

        dfs(res,pathLen+1,temp,nums);
    }
}
