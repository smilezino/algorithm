package leetcode;

/**
 * No.5
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    /**
     * 思路：从第某个位置向两边查找相同的字符
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String str1 = findLongestPalindrome(s, i, i);
            if (str1.length() > longest.length()) {
                longest = str1;
            }
            String str2 = findLongestPalindrome(s, i, i + 1);
            if (str2.length() > longest.length()) {
                longest = str2;
            }
        }
        return longest;
    }

    public static String findLongestPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("asfafsa"));
    }
}
