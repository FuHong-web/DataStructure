package LeetCode_Revice3.tanxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*划分字母区间*/
public class p763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> res= new ArrayList<>();
        for (int i= 0;i<s.length();i++) {
            map.put(s.charAt(i),i);
        }
        int segLen = 0;
        int maxRight =0;
        for (int i= 0;i<s.length();i++){
            segLen++;
            maxRight =Math.max(maxRight,map.get(s.charAt(i)));
            if (maxRight == i) {
                res.add(segLen);
                segLen=0;
            }
        }
        return res;

    }
}
