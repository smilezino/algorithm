package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.17
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * 思路：建立对应关系表，排列组合
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        if(digits == null || digits.length() < 1) {
            return null;
        }

        Map<Character, String> tables = new HashMap<Character, String>() {{
           put('2', "abc");
           put('3', "def");
           put('4', "ghi");
           put('5', "jkl");
           put('6', "mno");
           put('7', "pqrs");
           put('8', "tuv");
           put('9', "wxyz");
        }};

        List<String> result = new ArrayList<>();
        result.add("");
        for (int i=0; i<digits.length(); i++) {
            if(tables.containsKey(digits.charAt(i))) {
                String str = tables.get(digits.charAt(i));
                List<String> list = new ArrayList<>();
                for(int j=0; j<str.length(); j++) {
                    for (String s : result) {
                        s = s + str.charAt(j);
                        list.add(s);
                    }
                }
                result = list;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (String s : letterCombinations("234")) {
            System.out.println(s);
        }
    }
}
