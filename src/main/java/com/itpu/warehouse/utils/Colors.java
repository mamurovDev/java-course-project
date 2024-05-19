package com.itpu.warehouse.utils;

import com.itpu.warehouse.enums.ColorsEnum;

/**
 * InnerColors
 * Class for applying colors to the console output.
 */

public class Colors {
    public static String applyStyle(ColorsEnum color, String str, boolean isBold) {
        String temp = "";
        switch (color) {
            case green:
                temp = "\u001B[32m " + str + "\u001B[0m";
                break;
            case white:
                temp = "\u001B[37m " + str + "\u001B[0m";
                break;
            case purple:
                temp = "\u001B[35m " + str + "\u001B[0m";
                break;
            default:
                temp = str;
                break;
        }

        if (isBold) {
            temp = "\u001B[1m " + temp;
        }

        return temp;
    }
}
