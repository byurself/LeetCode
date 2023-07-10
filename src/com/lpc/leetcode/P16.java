package com.lpc.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author byu_rself
 * @date 2022/5/8 9:03
 */
public class P16 {

    @Test
    public void solution() {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int t = nums[i] + nums[i + 1] + nums[i + 2];
            if (t > target) {
                // 无论后面怎么选，选出的三个数的和不会比当前小
                if (t - target < Math.abs(ans - target)) {
                    ans = t;
                }
                break;
            }

            t = nums[i] + nums[n - 2] + nums[n - 1];
            if (t < target) {
                // 由于已经排序，当前和仍小于target，则无法找到比当前更优的答案，跳过后续步骤
                if (target - t < Math.abs(ans - target)) {
                    ans = t;
                }
                continue;
            }

            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target)) ans = sum;
                if (sum < target) ++j;
                else --k;
            }
        }
        return ans;
    }

    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}
