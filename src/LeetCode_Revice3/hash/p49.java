package LeetCode_Revice3.hash;

import LeetCode.ListNode;

import java.util.*;

/*字母异位词的分组*/
public class p49 {
   public List<List<String>> yiweicifenZu(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
           char[] strss = str.toCharArray();
           Arrays.sort(strss);
           String key = new String(strss);
           List<String> list = map.getOrDefault(key,new ArrayList<String>());
           list.add(str);
           map.put(key,list);
        }
        return new ArrayList<>(map.values());
   }
}
