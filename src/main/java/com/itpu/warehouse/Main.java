package com.itpu.warehouse;

import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;
import com.itpu.warehouse.controller.ConstructiveController;
import com.itpu.warehouse.controller.DollController;
import com.itpu.warehouse.controller.PuzzleController;
import com.itpu.warehouse.controller.SoftController;
import com.itpu.warehouse.controller.VehicleController;
import com.itpu.warehouse.service.impl.*;
import com.itpu.warehouse.utils.Colors;
import com.itpu.warehouse.utils.UIUtils;
import com.itpu.warehouse.dao.impl.*;
import com.itpu.warehouse.entity.*;
import com.itpu.warehouse.enums.ColorsEnum;

public class Main implements Serializable {

    public static void main(String[] args) {
        // Show the application brand information
        // UIUtils.showBrand();

        // Show available commands
        UIUtils.showCommands();

        // Start the command loop
        while (!UIUtils.isExited) {
            // Wait for user input
            String command = UIUtils.waitForCommand();

            // Process the user command
            if (command != null) {
                switch (command) {
                    case "list":
                        // Show all products
                        Main.listAllToys();
                        break;
                    case "help":
                        // Show available commands
                        UIUtils.showCommands();
                        break;
                    // Add more cases for other commands if needed
                    case "search":
                        Main.getParams();
                        break;
                    default:
                        // Handle invalid command
                        System.out.println("Invalid command. Type 'help' to see available commands.");
                        break;
                }
            }
        }

        // Exit the application
        System.out.println("Exiting the application.");
    }

    static ConstructiveController constructiveController = new ConstructiveController(
            new ConstructiveToyServiceImpl(new ConstructiveToyDAOImpl()));
    static DollController dollController = new DollController(new DollToyServiceImpl(new DollToyDAOImpl()));
    static PuzzleController puzzleController = new PuzzleController(new PuzzleToyServiceImpl(new PuzzleToyDAOImpl()));
    static SoftController softController = new SoftController(new SoftToyServiceImpl(new SoftToyDAOImpl()));
    static VehicleController vehicleController = new VehicleController(
            new VehicleToyServiceImpl(new VehicleToyDAOImpl()));

    public static void listAllToys() {

        Main.printToyTable(dollController.getAllToys(), "Doll");
        Main.printToyTable(constructiveController.getAllToys(), "Constructive");
        Main.printToyTable(puzzleController.getAllToys(), "Puzzle");
        Main.printToyTable(softController.getAllToys(), "Soft");
        Main.printToyTable(vehicleController.getAllToys(), "Vehicle");

    }

    public static void printToyTable(List<? extends Toy> toys, String title) {
        // Print table header
        if (toys.size() > 0) {
            System.out.println("\n" + title);
            System.out.println(
                    Colors.applyStyle(ColorsEnum.white, "ID\tName\t\t\t\tCategory\t\tPrice\tRecommended Age", true));

            // Iterate over each toy and print its details
            for (Toy toy : toys) {
                System.out.printf("%-3s\t%-30s\t%-20s\t$%.2f\t%d\n",
                        toy.getId(), toy.getName(), toy.getCategory(), toy.getPrice(), toy.getRecommendedAge());
            }
        }
    }

    public static void getParams() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter parameters, separate all parameters with ';'");
            System.out.println("For example:");
            System.out.println("type=vehicle;category=Vehicle;recommendedAge=3;minPrice=10;maxPrice=20;name=RC Boat\n");
            String searchingCommand = scanner.nextLine();

            // Check if the user wants to exit
            if (searchingCommand.equalsIgnoreCase("main")) {
                System.out.println("You returned to main menu.");
                UIUtils.waitForCommand();
                break;
            }

            // Split the input into individual parameters
            String[] params = searchingCommand.split(";");

            // Map to store parameters
            Map<String, String> map = new HashMap<>();

            // Process each parameter
            for (String param : params) {
                String[] keyValue = param.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();
                    map.put(key, value);
                } else {
                    // Invalid parameter format
                    System.out.println("Invalid parameter: " + param);
                }
            }

            // Process the collected parameters
            Main.processParams(map);
        }
        scanner.close();

    }

    public static void processParams(Map<String, String> paramMap) {
        List<List<? extends Toy>> list = new ArrayList<>();
        if (!paramMap.containsKey("type")) {
            list.add(constructiveController.getAllToys());
            list.add(dollController.getAllToys());
            list.add(puzzleController.getAllToys());
            list.add(softController.getAllToys());
            list.add(vehicleController.getAllToys());
        } else {
            switch (paramMap.get("type").toLowerCase()) {
                case "constructive":
                    list.add(constructiveController.getAllToys());
                    break;
                case "doll":
                    list.add(dollController.getAllToys());
                    break;
                case "puzzle":
                    list.add(puzzleController.getAllToys());
                    break;
                case "soft":
                    list.add(softController.getAllToys());
                    break;
                case "vehicle":
                    list.add(vehicleController.getAllToys());
                    break;
                default:
                    // Handle invalid type
                    System.out.println("Invalid type: " + paramMap.get("type"));
                    return;
            }
        }
        if (paramMap.containsKey("category")) {
            Iterator<List<? extends Toy>> iterator = list.iterator();
            while (iterator.hasNext()) {
                List<? extends Toy> toys = iterator.next();
                Iterator<? extends Toy> toyIterator = toys.iterator();
                while (toyIterator.hasNext()) {
                    Toy toy = toyIterator.next();
                    if (!toy.getCategory().toLowerCase().equals(paramMap.get("category").toLowerCase())) {
                        toyIterator.remove();
                    }
                }
            }
        } else {
            list.add(constructiveController.getAllToys());
            list.add(dollController.getAllToys());
            list.add(puzzleController.getAllToys());
            list.add(softController.getAllToys());
            list.add(vehicleController.getAllToys());
        }
        if (paramMap.containsKey("recommendedAge")) {
            Iterator<List<? extends Toy>> iterator = list.iterator();
            while (iterator.hasNext()) {
                List<? extends Toy> toys = iterator.next();
                Iterator<? extends Toy> toyIterator = toys.iterator();
                while (toyIterator.hasNext()) {
                    Toy toy = toyIterator.next();
                    if (toy.getRecommendedAge() != Integer.parseInt(paramMap.get("recommendedAge"))) {
                        toyIterator.remove();
                    }
                }
            }
        }
        if (paramMap.containsKey("minPrice") && paramMap.containsKey("maxPrice")) {
            Iterator<List<? extends Toy>> iterator = list.iterator();
            while (iterator.hasNext()) {
                List<? extends Toy> toys = iterator.next();
                Iterator<? extends Toy> toyIterator = toys.iterator();
                while (toyIterator.hasNext()) {
                    Toy toy = toyIterator.next();
                    if (toy.getPrice() < Double.parseDouble(paramMap.get("minPrice"))
                            || toy.getPrice() > Double.parseDouble(paramMap.get("maxPrice"))) {
                        toyIterator.remove();
                    }
                }
            }
        }
        if (paramMap.containsKey("name")) {
            Iterator<List<? extends Toy>> iterator = list.iterator();
            while (iterator.hasNext()) {
                List<? extends Toy> toys = iterator.next();
                Iterator<? extends Toy> toyIterator = toys.iterator();
                while (toyIterator.hasNext()) {
                    Toy toy = toyIterator.next();
                    if (!toy.getName().toLowerCase().equals(paramMap.get("name").toLowerCase())) {
                        toyIterator.remove();
                    }
                }
            }
        }

        Main.printToyTable(list.get(0), "Search result");

    }

}
