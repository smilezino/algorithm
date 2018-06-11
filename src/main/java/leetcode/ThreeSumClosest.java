package leetcode;

import java.util.Arrays;

/**
 * No.16
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class ThreeSumClosest {
    /**
     * 思路：同 3sum，不能重复
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0, min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length - 2; i++) {
            if(i!=0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                if(j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    return sum;
                }
                int diff = Math.abs(sum - target);
                result = diff < min ? sum : result;
                min = diff < min ? diff : min;
                if(sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}
