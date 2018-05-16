package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1
 * https://leetcode-cn.com/problems/two-sum/
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    /**
     * 思路：遍历
     * @param array
     * @param target
     * @return
     */
    public static int[] twoSum(int[] array, int target) {
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                if(array[i] + array[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    /**
     * 思路：用 Map 保存 target - array[i] 差值对应下标，后续循环中发现 Map 中存在，则找到解
     * @param array
     * @param target
     * @return
     */
    public static int[] twoSum0(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++) {
            if(map.get(array[i]) != null) {
                return new int[] {map.get(array[i]), i};
            } else {
                map.put(target - array[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[] {2, 7, 11, 15};
        int[] indexes = twoSum(array, 9);
        if(indexes != null) {
            System.out.printf("%d, %d\n", indexes[0], indexes[1]);
        }
    }
}
