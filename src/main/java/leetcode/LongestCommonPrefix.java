package leetcode;

/**
 * No.14
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    /**
     * 思路：每个字符串从前到后匹配
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length < 1) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(true) {
            boolean match = true;
            for(int i=0; i<strs.length; i++) {
                if(index > strs[i].length() || strs[i].charAt(index) != strs[0].charAt(index)) {
                    match = false;
                    break;
                }
            }
            if(!match) {
                break;
            }
            sb.append(strs[0].charAt(index));
            index ++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }
}
