package com.itpu.warehouse;

import java.io.Serializable;

import com.itpu.warehouse.utils.UIUtils;

public class Main implements Serializable {

    public static void main(String[] args) {
        UIUtils.showBrand();
        UIUtils.showCommands();
        System.out.println(UIUtils.waitForCommand());

    }
}
