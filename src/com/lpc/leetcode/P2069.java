package com.lpc.leetcode;

/**
 * 模拟行走机器人II
 *
 * @author byu_rself
 * @date 2023/7/18 10:18
 */
public class P2069 {

    int width, height;
    int loc; // 有效的移动步数
    boolean moved;
    String[] dir = new String[]{"East", "North", "West", "South"};

    public P2069(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void step(int num) {
        moved = true;
        loc += num;
        loc %= 2 * (width - 1) + 2 * (height - 1);
    }

    public int[] getPos() {
        int[] pos = move();
        int x = pos[0], y = pos[1];
        return new int[]{pos[0], pos[1]};
    }

    public String getDir() {
        int[] pos = move();
        int x = pos[0], y = pos[1], d = pos[2];
        // 特殊处理在(0,0)时，未移动过方向为East，移动过方向为South
        if (x == 0 && y == 0) return moved ? dir[3] : dir[0];
        return dir[d];
    }

    private int[] move() {
        if (loc <= width - 1) {
            // 移动步数范围在[0, width - 1]，所在位置在外圈下方，方向为East
            return new int[]{loc, 0, 0};
        } else if (loc <= (width - 1) + (height - 1)) {
            // 移动步数范围在[width, (width - 1) + (height - 1)]，所在位置在外圈右方，方向为North
            return new int[]{width - 1, loc - (width - 1), 1};
        } else if (loc <= 2 * (width - 1) + (height - 1)) {
            // 移动步数范围在[(width - 1) + (height - 1) + 1, 2 * (width - 1) + (height - 1)]，所在位置在外圈上方，方向为West
            return new int[]{(width - 1) - (loc - ((width - 1) + (height - 1))), height - 1, 2};
        } else {
            // 移动步数范围在[2 * (width - 1) + (height - 1) + 1, 2 * (width - 1) + 2 * (height - 1)]，所在位置在外圈左方，方向为South
            return new int[]{0, (height - 1) - (loc - (2 * (width - 1) + height - 1)), 3};
        }
    }
}
