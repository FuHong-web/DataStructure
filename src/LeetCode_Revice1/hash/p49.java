package LeetCode_Revice1.hash;

import java.util.*;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/2 22:45
 * @desc:字母异位词分组
 * 把单词排序，相同字母的单词排序后一定一模一样！
 * eat → 排序 → aet
 * tea → 排序 → aet
 * 所以它们是一组！
 * 用 Map 存：
 * key = 排序后的字符串
 * value = 这一组所有单词
 */
public class p49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
