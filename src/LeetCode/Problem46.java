package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/3/7 14:51
 * @desc:力扣第46题：全排列
 */
public class Problem46 {
        // 主方法：接收一个整数数组，返回其所有全排列的列表
        public List<List<Integer>> permute(int[] nums) {
            // 1. 定义最终结果集合：存储所有的全排列结果
            List<List<Integer>> res=new ArrayList<>();
            // 2. 定义临时集合：存储当前正在构建的单个排列
            List<Integer> temp=new ArrayList<>();
            // 3. 调用回溯函数，开始构建全排列
            def(res,nums,temp);
            // 4. 返回最终结果
            return res;
        }

        // 回溯函数：递归构建全排列
        // 参数说明：
        // res - 最终结果集合
        // nums - 原始输入数组
        // temp - 当前正在构建的临时排列
        public void def(List<List<Integer>> res,int[] nums,List<Integer> temp){
            // 5. 递归终止条件：临时集合的长度等于原始数组长度（说明一个完整排列已构建完成）
            if(temp.size()==nums.length){
                // 6. 将当前临时集合的副本加入结果集（必须new ArrayList，否则后续修改会影响已存入的元素）
                res.add(new ArrayList<>(temp));
                // 7. 终止当前递归分支，返回上一层
                return;
            }

            // 8. 遍历原始数组中的每个元素，尝试加入临时集合
            for(int i=0;i<nums.length;i++){
                // 9. 标记当前元素是否已存在于临时集合中（避免重复使用）
                boolean isExist=false;
                // 10. 遍历临时集合，检查nums[i]是否已存在
                for(int j=0;j<temp.size();j++){
                    // 11. 如果找到相同元素，标记为已存在并终止检查
                    if(nums[i]==temp.get(j)){
                        isExist=true;
                        break;
                    }
                }
                // 12. 如果当前元素未在临时集合中，才可以选择
                if(!isExist){
                    // 13. 选择当前元素：加入临时集合
                    temp.add(nums[i]);
                    // 14. 递归调用：继续构建剩余位置的排列
                    def(res,nums,temp);
                    // 15. 回溯：撤销选择（移除最后加入的元素），尝试下一个元素
                    temp.remove(temp.size()-1);
                }
            }
        }
    }

