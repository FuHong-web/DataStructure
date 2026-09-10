package LeetCode_Revice4.dongtaiguihua;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*杨辉三角*/
public class p118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows >= 1) {
            res.add(Arrays.asList(1));
        }
        if(numRows >= 2){
            res.add(Arrays.asList(1,1));
        }
        // i 行下标，从2开始，小于numRows，不要 <=
        for(int i = 2; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            // 第i行一共 i+1 个元素，j <= i
            for (int j = 0; j <= i; j++) {
                temp.add(1);
            }
            // k只遍历中间，首尾保持1不变
            for (int k = 1; k < i; k++){
                temp.set(k, res.get(i-1).get(k) + res.get(i-1).get(k-1));
            }
            res.add(temp);
        }
        return res;
    }
}

