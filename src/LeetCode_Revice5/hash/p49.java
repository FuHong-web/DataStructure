package LeetCode_Revice5.hash;

import java.util.*;

/*字母异位词分组*/
public class p49 {
    public List<List<String>> fenzu(List<String> strs){
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = new String(s);
            List<String> strings = map.getOrDefault(key,new ArrayList<>());
            strings.add(str);
            map.put(key,strings);
        }
        return new ArrayList<>(map.values());
    }
}
