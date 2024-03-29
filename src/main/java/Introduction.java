
public class Introduction {

    final private String[] commands = { "Exit", "Clear" };
    final private String line = "------------------------------------------------------------------------";
    final private String name = "Nurmuahmmad";
    final private String email = "nurmuhammad_mamurjonov@student.itpu.uz";

    public void showBrand() {
        System.out.println(Colors.applyStyle(ColorsEnum.green, "\n Toys Warehouse", true));
        System.out.println(Colors.applyStyle(ColorsEnum.white, line, false));
        System.out
                .println(Colors.applyStyle(ColorsEnum.green,
                        "By: " + name + " | " + email, false));
        System.out.println(Colors.applyStyle(ColorsEnum.purple, "version: 1.0", false));
        System.out.println(Colors.applyStyle(ColorsEnum.white, line + "\n", false));

    }

    public void showCommands() {
        System.out.println(Colors.applyStyle(ColorsEnum.white, "Available commands: ", true));
        for (String command : commands) {
            System.out.println("   * " + command);
        }
    }

}
