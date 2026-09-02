package LeetCode_Revice3.huisu;

import java.util.ArrayList;
import java.util.List;

/*子集*/
public class p78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(res,temp,nums,0);
        return res;
    }
    private void help(List<List<Integer>> res,List<Integer> temp,int[] nums,int index){
     if(index == nums.length){
         res.add(new ArrayList<>(temp));
         return;
     }

     help(res,temp,nums,index+1);

     temp.add(nums[index]);
     help(res,temp,nums,index+1);
     temp.remove(temp.size()-1);
    }
}
