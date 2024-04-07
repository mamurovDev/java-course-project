package com.itpu.warehouse.utils;
import java.util.Scanner;

/**
 * InnerUIUtils
 */

public class UIUtils {

    final static private String[] commands = {
            "list: Show all products",
            "help: Show all available commands",
            "clear: Clear all history in console",
            "exit: exit the software"
    };
    static boolean isExited = false;
    final static private String line = "------------------------------------------------------------------------";
    final static private String name = "Nurmuahmmad";
    final static private String email = "nurmuhammad_mamurjonov@student.itpu.uz";

    public static void showBrand() {
        System.out.println(Colors.applyStyle(ColorsEnum.green, "\n Toys Warehouse", true));
        System.out.println(Colors.applyStyle(ColorsEnum.white, line, false));
        System.out
                .println(Colors.applyStyle(ColorsEnum.green,
                        "By: " + name + " | " + email, false));
        System.out.println(Colors.applyStyle(ColorsEnum.purple, "version: 1.0 | create date: 29.03.2024", false));
        System.out.println(Colors.applyStyle(ColorsEnum.white, line + "\n", false));

    }

    public static void showCommands() {
        System.out.println(Colors.applyStyle(ColorsEnum.white, "Available commands: ", true));
        for (String command : commands) {
            System.out.println("   * " + command);
        }
        System.out.println(Colors.applyStyle(ColorsEnum.white, line + "\n", false));
    }

    public static String waitForCommand() {
        Scanner scanner = new Scanner(System.in);

        while (!isExited) {
            System.out.println("Waiting for a command...");
            String currentCommand = scanner.nextLine().trim();
            switch (currentCommand) {
                case "exit":
                    isExited = true;
                    break;
                case "clear":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println(Colors.applyStyle(ColorsEnum.white, "Console has been cleaned.\n", false));
                    break;
                case "help":
                    UIUtils.showCommands();
                    break;
                default:
                    return currentCommand;
            }
        }

        scanner.close();
        return null;
    }

}
