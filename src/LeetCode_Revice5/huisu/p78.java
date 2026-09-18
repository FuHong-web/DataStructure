package LeetCode_Revice5.huisu;

import java.util.ArrayList;
import java.util.List;

/*全排列*/
public class p78 {
    private List<List<Integer>> quanPaiLie(int[] nums){
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        help(nums,res,temp,0);
        return res;
    }
    private void help(int[] nums,List<List<Integer>> res,List<Integer> temp ,int index){
        if(nums.length == temp.size()){
            res.add(new ArrayList<>(temp));
        }
         help(nums,res,temp,index+1);

        temp.add(nums[index]);
        help(nums,res,temp,index+1);
        temp.remove(temp.size()-1);
    }

}
