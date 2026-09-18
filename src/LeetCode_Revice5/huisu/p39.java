package LeetCode_Revice5.huisu;

import javax.xml.transform.stax.StAXResult;
import java.util.ArrayList;
import java.util.List;

/*组合总和*/
public class p39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        help(candidates,res,temp,target,0);
        return res;
    }
    private void help(int[] candidates,List<List<Integer>> res,List<Integer> temp,int taget,int start){
        if(taget == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(taget < 0){
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            help(candidates,res,temp,taget-candidates[i],i);
            temp.remove(temp.size()-1);
        }
        
    }
}
