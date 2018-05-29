package leetcode;

/**
 * No.11
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 注意：你不能倾斜容器，n 至少是2。
 *
 */
public class ContainerWithMostWater {
    /**
     * 思路1：双循环遍历
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = area > maxArea ? area : maxArea;
            }
        }
        return maxArea;
    }

    /**
     * 思路2：从两边向中间计算
     * @param height
     * @return
     */
    public static int maxArea0(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = area > maxArea ? area : maxArea;
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,3,3,1}));
        System.out.println(maxArea0(new int[]{1,3,3,1}));

        System.out.println(maxArea(new int[]{1,3,3,1,1}));
        System.out.println(maxArea0(new int[]{1,3,3,1,1}));
    }
}
