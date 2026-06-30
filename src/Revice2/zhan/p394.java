package Revice2.zhan;

/**
 * @author: Yan Tong xue
 * @Created:2026/6/26 23:10
 * @desc:字符串解码
 */
public class p394 {
    private  int index = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                num = num * 10 + (c-'0');
                index++;
            }else if (c == '[') {
                index++;
                String sub = decodeString(s);
                for (int i = 0; i < num; i++) {
                    res.append(sub);
                }
                num = 0;
            }else if (c == ']') {
                index++;
                return res.toString();
            }else {
                res.append(c);
                index++;
            }
        }
        return res.toString();
    }
}
