package com.lpc.leetcode;

import java.util.Random;

/**
 * Generate Random Point in a Circle
 *
 * @author byu_rself
 * @date 2022/6/5 21:34
 */
public class P478 {
    Random random;
    double xc, yc, r;

    public P478(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        double u = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double r = Math.sqrt(u);
        return new double[]{xc + r * Math.cos(theta) * this.r, yc + r * Math.sin(theta) * this.r};
    }
}
