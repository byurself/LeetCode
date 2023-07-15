package com.lpc.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author byu_rself
 * @date 2022/5/20 15:44
 */
public class P18 {

    @Test
    public void solution() {
        int[] nums = new int[]{0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000};
        int target = -1000000000;
        List<List<Integer>> list = fourSum(nums, target);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println("\n");
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return ans;
        Arrays.sort(nums);
        for (int a = 0; a < n - 3; ++a) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;

            long sum = (long) nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3];
            if (sum > target) break;

            sum = (long) nums[a] + nums[n - 3] + nums[n - 2] + nums[n - 1];
            if (sum < target) continue;

            for (int b = a + 1; b < n - 2; ++b) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue;

                sum = (long) nums[a] + nums[b] + nums[b + 1] + nums[b + 2];
                if (sum > target) break;

                sum = (long) nums[a] + nums[b] + nums[n - 2] + nums[n - 1];
                if (sum < target) continue;

                int c = b + 1, d = n - 1;
                while (c < d) {
                    sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        ans.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        while (c < d && nums[c] == nums[c + 1]) ++c;
                        while (c < d && nums[d] == nums[d - 1]) --d;
                        ++c;
                        --d;
                    } else if (sum < target) ++c;
                    else --d;
                }
            }
        }
        return ans;
    }









    /*public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return list;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }*/
}
