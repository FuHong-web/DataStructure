package Revice2.hash;

import java.util.*;

/**
 * @author: Yan Tong xue
 * @Created:2026/7/3 21:41
 * @desc:异位字母分组
 */
public class p49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] sc = str.toCharArray();
            Arrays.sort(sc);
            String key = new String(sc);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
