package LeetCode_Revice1.tanxin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/5/16 23:19
 * @desc:划分字母区间
 *
 * maxRight    = 当前片段**最远要覆盖到哪个下标（贪心边界）
 * segLen      = 当前片段**已经走了多少个字符（长度）
 */
public class p763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }
        int maxPianDuan = 0;
        int maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            maxPianDuan++;
            maxRight = Math.max(maxRight,map.get(s.charAt(i)));
            if (maxRight == i) {
                res.add(maxPianDuan);
                maxPianDuan = 0;
            }
        }
        return res;
    }
}
