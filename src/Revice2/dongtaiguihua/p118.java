package Revice2.dongtaiguihua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/20 17:57
 * @desc:杨辉三角
 */
public class p118 {
    public List<List<Integer>> generate (int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows >= 1) {
            res.add(Arrays.asList(1));
        }
        if (numRows >= 2) {
            res.add(Arrays.asList(1,1));
        }
        for (int i = 2;i < numRows;i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0;j <= i;j++) {
                temp.add(1);
            }
            for (int k =1;k<i;k++) {
                temp.set(k,res.get(i-1).get(k-1)+res.get(i-1).get(k));
            }
            res.add(temp);
        }
        return res;
    }
}
