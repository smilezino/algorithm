package leetcode;

/**
 * No.8
 * https://leetcode-cn.com/problems/string-to-integer-atoi/description/
 *
 * 实现 atoi，将字符串转为整数。
 *
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 *
 * 若函数不能执行有效的转换，返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 */
public class StringToIntegerAtoi {
    /**
     * 思路：字符串从到右依次计算
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();

        int i = 0;
        boolean positive = true;
        char c = str.charAt(0);
        if(c == '-' || c == '+') {
            i += 1;
            positive = c == '+';
        }
        int result = 0;
        for (; i<str.length(); i++) {
            c = str.charAt(i);
            if(c >= '0' && c<= '9') {
                int digit = c - '0';
                if(result * 10 + digit < 0) {
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
            } else {
                // 非数字字符
                return result;
            }
        }
        return positive ? result : - result;
    }

    public static void main(String[] args) {
        System.out.printf("%s=%d\n", "123", myAtoi("123"));
        System.out.printf("%s=%d\n", "123", myAtoi("   123"));
        System.out.printf("%s=%d\n", "+123", myAtoi("+123"));
        System.out.printf("%s=%d\n", "-123", myAtoi("-123"));
        System.out.printf("%s=%d\n", " abc123ABC", myAtoi(" abc123ABC"));
        System.out.printf("%s=%d\n", "2147483647", myAtoi("2147483647"));
        System.out.printf("%s=%d\n", "-2147483648", myAtoi("-2147483648"));
        System.out.printf("%s=%d\n", "2147483648", myAtoi("2147483648"));
        System.out.printf("%s=%d\n", "-2147483649", myAtoi("-2147483649"));
    }
}
