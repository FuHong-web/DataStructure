package LeetCode_Revice3.hash;

import java.util.*;

/*字母异位词的分组*/
public class p49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
