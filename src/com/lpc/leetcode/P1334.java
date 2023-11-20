package com.lpc.leetcode;

import java.util.Arrays;

/**
 * 阈值距离内邻居最少的城市
 *
 * @author byu_rself
 * @date 2023/11/14 9:19
 */
public class P1334 {

    private static final int INF = 0x3f3f3f3f;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (int[] e : g) Arrays.fill(e, INF);
        for (int[] e : edges) {
            int a = e[0], b = e[1], w = e[2];
            g[a][b] = w;
            g[b][a] = w;
        }
        for (int k = 0; k < n; ++k) {
            g[k][k] = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = n, cnt = INF;
        for (int i = n - 1; i >= 0; --i) {
            int t = 0;
            for (int d : g[i]) {
                if (d <= distanceThreshold) {
                    ++t;
                }
            }
            if (t < cnt) {
                cnt = t;
                ans = i;
            }
        }
        return ans;
    }

// Dijkstra
    /*int[][] g;
    int n;
    int[] dist;
    boolean[] visited;
    int distanceThreshold;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        g = new int[n][n];
        this.n = n;
        dist = new int[n];
        visited = new boolean[n];
        this.distanceThreshold = distanceThreshold;
        for (int[] e : g) Arrays.fill(e, INF);
        for (int[] e : edges) {
            int a = e[0], b = e[1], w = e[2];
            g[a][b] = w;
            g[b][a] = w;
        }
        int ans = n, cnt = INF;
        for (int i = n - 1; i >= 0; --i) {
            int t = dijkstra(i);
            if (t < cnt) {
                cnt = t;
                ans = i;
            }
        }
        return ans;
    }

    private int dijkstra(int u) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[u] = 0;
        for (int i = 0; i < n; ++i) {
            int k = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (k == -1 || dist[k] > dist[j])) {
                    k = j;
                }
            }
            visited[k] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[k] + g[k][j]);
            }
        }
        int cnt = 0;
        for (int d : dist) {
            if (d <= distanceThreshold) ++cnt;
        }
        return cnt;
    }*/

    /*public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (var e : g) {
            Arrays.fill(e, INF);
        }
        for (var e : edges) {
            int a = e[0], b = e[1], w = e[2];
            g[a][b] = w;
            g[b][a] = w;
        }
        for (int k = 0; k < n; ++k) {
            g[k][k] = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int ans = n, cnt = INF;
        for (int i = n - 1; i >= 0; --i) {
            int t = 0;
            for (int d : g[i]) {
                if (d <= distanceThreshold) {
                    ++t;
                }
            }
            if (t < cnt) {
                cnt = t;
                ans = i;
            }
        }
        return ans;
    }*/

// Dijkstra
    /*int n;
    int[][] g;
    int[] dist;
    boolean[] visited;
    int distanceThreshold;
    static final int INF = 1 << 30;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.n = n;
        this.distanceThreshold = distanceThreshold;
        g = new int[n][n];
        dist = new int[n];
        visited = new boolean[n];
        for (int[] e : g) {
            Arrays.fill(e, INF);
        }
        for (int[] e : edges) {
            int a = e[0], b = e[1], w = e[2];
            g[a][b] = w;
            g[b][a] = w;
        }
        int ans = n, cnt = INF;
        for (int i = n - 1; i >= 0; --i) {
            int t = dijkstra(i);
            if (t < cnt) {
                cnt = t;
                ans = i;
            }
        }
        return ans;
    }

    private int dijkstra(int u) {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[u] = 0;
        for (int i = 0; i < n; ++i) {
            int k = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (k == -1 || dist[k] > dist[j])) {
                    k = j;
                }
            }
            visited[k] = true;
            for (int j = 0; j < n; ++j) {
                dist[j] = Math.min(dist[j], dist[k] + g[k][j]);
            }
        }
        int cnt = 0;
        for (int d : dist) {
            if (d <= distanceThreshold) {
                ++cnt;
            }
        }
        return cnt;
    }*/
}
