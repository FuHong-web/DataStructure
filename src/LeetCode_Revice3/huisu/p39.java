package LeetCode_Revice3.huisu;

import java.util.ArrayList;
import java.util.List;

/*组合总和*/
public class p39 {

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            help(res, temp, candidates, target, 0);
            return res;
        }

        private void help(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start){
            if(target == 0){
                res.add(new ArrayList<>(temp));
                return;
            }
            if(target < 0){
                return;
            }
            // i从start开始，不回头，避免重复组合
            for(int i = start; i < candidates.length; i++){
                temp.add(candidates[i]);
                // 下一层依旧从i开始，允许重复选取当前元素
                help(res, temp, candidates, target - candidates[i], i);
                temp.remove(temp.size()-1);
            }
        }
    }

