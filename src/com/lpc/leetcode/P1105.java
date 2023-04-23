package com.lpc.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 填充书架
 *
 * @author byu_rself
 * @date 2023/4/23 16:39
 */
public class P1105 {

    @Test
    public void solution() {
        int[][] books = new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int w = 4;
        System.out.println(minHeightShelves(books, w));
    }

    public int minHeightShelves2(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            f[i + 1] = Integer.MAX_VALUE;
            int maxHeight = 0, width = 0;
            for (int j = i; j >= 0; --j) {
                width += books[j][0];
                if (width > shelfWidth) break;
                maxHeight = Math.max(maxHeight, books[j][1]);
                f[i + 1] = Math.min(f[i + 1], f[j] + maxHeight);
            }
        }
        return f[n];
    }

    int[][] books;
    int shelfWidth;
    int[] cache;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        this.shelfWidth = shelfWidth;
        int n = books.length;
        this.cache = new int[n];
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        if (cache[i] != 0) return cache[i];
        int ans = Integer.MAX_VALUE, maxHeight = 0, width = 0;
        for (int j = i; j >= 0; --j) {
            width += books[j][0];
            if (width > shelfWidth) break;
            maxHeight = Math.max(maxHeight, books[j][1]);
            ans = Math.min(ans, dfs(j - 1) + maxHeight);
        }
        return cache[i] = ans;
    }
}
