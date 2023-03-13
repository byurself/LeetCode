package com.lpc.leetcode;

import org.junit.Test;

/**
 * 赢得比赛需要的最少训练时长
 *
 * @author byu_rself
 * @date 2023/3/13 12:09
 */
public class P2383 {

    @Test
    public void solution() {
        int initialEnergy = 1, initialExperience = 1;
        int[] energy = new int[]{1, 1, 1, 1};
        int[] experience = new int[]{1, 1, 1, 50};
        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0, n = energy.length;
        for (int i = 0; i < n; ++i) {
            if (initialEnergy <= energy[i]) {
                ans += energy[i] - initialEnergy + 1;
                initialEnergy = 1;
            } else {
                initialEnergy -= energy[i];
            }

            if (initialExperience <= experience[i]) {
                int t = experience[i] - initialExperience + 1;
                ans += t;
                initialExperience += t;
            }
            initialExperience += experience[i];
        }
        return ans;
    }
}
