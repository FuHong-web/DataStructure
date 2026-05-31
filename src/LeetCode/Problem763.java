package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Yan Tong xue
 * @Created:2026/4/20 23:06
 * @desc:763. 划分字母区间(贪心)
 */
public class Problem763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character,Integer> uRight = new HashMap<>();  // 修改变名拼写

        // 记录每个字符最后出现的位置
        for (int i = 0;i< s.length();i++) {
            uRight.put(s.charAt(i),i);
        }

        int segLen = 0;
        int maxRight = 0;

        for (int i = 0;i<s.length();i++){
            segLen++;
            maxRight = Math.max(maxRight, uRight.get(s.charAt(i)));
            // 到达边界，添加 片段长度，不是下标！
            if (i == maxRight) {
                res.add(segLen);  // 核心修复
                segLen = 0;
            }
        }
        return res;
    }
}
