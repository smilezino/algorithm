package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * No.3
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Map<Character, Integer> 存储字符对应下标，map 中存在 Character 则可以计算出子字串长度
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int length = i - map.get(c);
                maxLength = length > maxLength ? length : maxLength;
            }
            map.put(c, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
