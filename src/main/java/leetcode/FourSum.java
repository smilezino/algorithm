package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.18
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    /**
     * 思路：同 ThreeSum
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for(int m=0; m<nums.length - 3; m++) {
            if(m > 0 && nums[m] == nums[m - 1]) {
                continue;
            }
            for(int i=m+1; i<nums.length - 2; i++) {
                if(i > m + 1 && nums[i] == nums[i - 1]) continue;
                int j = i + 1, k = nums.length - 1;
                while(j < k) {
                    if(j != i + 1 && nums[j] == nums[j - 1]) {
                        j ++;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if(sum == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[m], nums[i], nums[j], nums[k])));
                        j++;
                        k--;
                    } else if(sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum.print(fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
    }
}
