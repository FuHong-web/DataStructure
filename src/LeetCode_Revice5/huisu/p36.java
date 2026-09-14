package LeetCode_Revice5.huisu;

import java.util.ArrayList;
import java.util.List;

/*全排列*/
public class p36 {
    private List<List<Integer>> quanPaiLie(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp =new ArrayList<>();
        help(res,temp,0,nums);
        return res;

    }
    private void help(List<List<Integer>> res,List<Integer> temp,int index,int[] nums){
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        help(res,temp,index+1,nums);

        temp.add(nums[index]);
        help(res,temp,index+1,nums);
        temp.remove(temp.size()-1);
    }

}
