package LeetCode_Revice5.dongtaiguihua;

import java.time.temporal.JulianFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*杨辉三角*/
public class p118 {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    temp.add(1);
                }else {
                    temp.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }
}
