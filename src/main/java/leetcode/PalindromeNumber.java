package leetcode;

/**
 * No.9
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {

    /**
     * 思路：反转数字后判断是否相等
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int origin = x, y = 0;
        while(x/10 != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        y = y * 10 + x % 10;
        return y == origin;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(101));
    }
}
