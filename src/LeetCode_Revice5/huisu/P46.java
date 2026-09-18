package LeetCode_Revice5.huisu;

import java.util.ArrayList;
import java.util.List;

/*全排列*/
public class P46 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(nums,res,temp,0);
        return res;
    }
    private void help(int[] nums,List<List<Integer>> res,List<Integer> temp,int index){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if(!temp.contains(num)){
            temp.add(num);
            help(nums,res,temp,index+1);
            temp.remove(temp.size()-1);
        }
    }}
}
