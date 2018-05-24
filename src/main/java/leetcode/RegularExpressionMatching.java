package leetcode;

/**
 * No.10
 * https://leetcode-cn.com/problems/regular-expression-matching
 *
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class RegularExpressionMatching {
    /**
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        return isMatch(s, 0, p, 0);
    }

    public static boolean isMatch(String s, int si, String p, int pi) {
        // p 截止，判断s是否截止
        if(pi >= p.length()) {
            return si >= s.length();
        }

        // p还剩最后一位，或者pi之后一位不是 '*' 情况
        if(pi == p.length() - 1 || p.charAt(pi + 1) != '*') {
            // s截止 或者 s[si] != p[pi] && p[pi] != '.'
            if(si >= s.length() || (p.charAt(pi) != '.' && s.charAt(si) != p.charAt(pi))) {
                return false;
            }
            // 从si+1, pi+1处开始匹配
            return isMatch(s, si + 1, p, pi + 1);
        }

        // p[pi+1]=='*' 情况
        int i = si;
        // si之后的字符一直 == p[pi] || '.'情况
        while(i<s.length() && (s.charAt(i) == p.charAt(pi) || p.charAt(pi) == '.')) {
            // 匹配s[i]之后与p[pi+2]
            if(isMatch(s, i, p, pi + 2)) {
                return true;
            }
            i++;
        }
        // si之后某个字符不匹配，判断从该i处与pi+2处是否匹配
        return isMatch(s, i, p, pi + 2);
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("a", "b"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aaadsdda", "a.*da"));
    }
}
