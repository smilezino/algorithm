package leetcode;

/**
 * No.7
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseInteger {

    /**
     * 思路：对 x 取余取整
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int y = 0;
        while(x/10 != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        y = y * 10 + x % 10;
        return y;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}
