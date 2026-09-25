package LeetCode_Revice5.tanxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*划分字母区间*/
public class p763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i),i);
        }
        int segLen = 0;
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            segLen++;
            maxRight = Math.max(maxRight,map.get(s.charAt(i)));
            if(i == maxRight) {
                res.add(segLen);
                segLen = 0;
            }
        }
        return res;
    }
}
