package LeetCode;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/20 17:50
 * @desc:力扣第78题：子集（回溯）
 */
public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, 0, tmp, res);
        return res;
    }

    private void dfs(int[] nums, int pathLen, List<Integer> tmp, List<List<Integer>> res) {
        if (pathLen == nums.length) {
            res.add(new ArrayList<>(tmp)); // 注意：Java中需要拷贝一份新列表
            return;
        }

        // 选择当前元素：加入临时列表 → 递归 → 回溯
        tmp.add(nums[pathLen]);
        dfs(nums, pathLen + 1, tmp, res);
        tmp.remove(tmp.size() - 1);

        // 不选择当前元素：直接递归
        dfs(nums, pathLen + 1, tmp, res);
    }
}
