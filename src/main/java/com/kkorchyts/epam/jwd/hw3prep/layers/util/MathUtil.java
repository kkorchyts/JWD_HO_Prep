package com.kkorchyts.epam.jwd.hw3prep.layers.util;

public final class MathUtil {
    private MathUtil() {
    }

    public static int nod(int _x, int _y) {
        int x = _x;
        int y = _y;
        while (x != 0 && y != 0) {
            if (x > y){
                x = x % y;
            } else {
                y = y % x;
            }
        }
        return x;
    }
}
