package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * 思路：难点不能重复，需对 nums 排序，遍历时过滤相同的数字
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while(j < k) {
                if(j != i + 1 && nums[j] == nums[j - 1]) {
                    j ++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if(sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void print(List<List<Integer>> result) {
        if(result == null || result.isEmpty()) {
            return;
        }
        for (List<Integer> list : result) {
            System.out.print("[ ");
            for (Integer i : list) {
                System.out.printf("%d ", i);
            }
            System.out.print("]\n");
        }
    }

    public static void main(String[] args) {
        print(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println("---");
        print(threeSum(new int[] {-1, 1, 1, 1, -1, -1, 0, 0, 0}));
    }
}
