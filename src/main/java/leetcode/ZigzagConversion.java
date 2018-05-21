package leetcode;

/**
 * No.6
 * https://leetcode-cn.com/problems/zigzag-conversion/description/
 *
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 * 示例 2:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigzagConversion {
    /**
     * 思路：每行看成一个数组，共numRows个数组，字符依次放入数组则下标为0,1,2...numRows-1,numRows-2...0
     * 下标可以看成步长 step 为 1 序列，step 遇 0 变正，遇 numRows-1 变负，
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(s == null || s.length() <= 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int index = 0, step = 1;
        for(int i=0; i<s.length(); i++) {
            if(index == 0) step = 1;
            if(index == numRows -1 ) step = -1;
            stringBuilders[index].append(s.charAt(i));
            index += step;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder buffer : stringBuilders) {
            result.append(buffer);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
