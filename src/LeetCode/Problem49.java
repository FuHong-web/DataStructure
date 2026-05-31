package LeetCode;

import java.util.*;

/**
 * @author: Yan Tong xue
 * @Created:2026/1/9 21:29
 * @desc:力扣滴49题：字母异位词分组
 */
public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs){
    Map<String,List<String>> map=new HashMap<String,List<String>>();
    for (String str:strs){
        char[] arr=str.toCharArray();
        Arrays.sort(arr);
        String key=new String(arr);
        List<String> list=map.getOrDefault(key,new ArrayList<String>());
        list.add(str);
        map.put(key,list);
    }
    return new ArrayList<List<String>>(map.values());
}
}

