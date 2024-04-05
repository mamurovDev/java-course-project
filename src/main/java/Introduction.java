
public class Introduction {

    final static private String[] commands = {
            "list: Show all products",
            "help: Show all available commands",
            "clear: Clear all history in console",
            "exit: exit the software"
    };
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

}
