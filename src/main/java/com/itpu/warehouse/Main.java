package com.itpu.warehouse;

import com.itpu.warehouse.controller.*;
import com.itpu.warehouse.dao.impl.*;
import com.itpu.warehouse.dao.impl.VehicleToyDAOImpl;
import com.itpu.warehouse.entity.*;
import com.itpu.warehouse.enums.ColorsEnum;
import com.itpu.warehouse.service.impl.*;
import com.itpu.warehouse.utils.Colors;
import com.itpu.warehouse.utils.UIUtils;
import java.io.Serializable;
import java.util.*;

public class Main implements Serializable {

  private final ConstructiveController constructiveController;
  private final DollController dollController;
  private final PuzzleController puzzleController;
  private final SoftController softController;
  private final VehicleController vehicleController;

  // Constructor for dependency injection
  public Main(
    ConstructiveController constructiveController,
    DollController dollController,
    PuzzleController puzzleController,
    SoftController softController,
    VehicleController vehicleController
  ) {
    this.constructiveController = constructiveController;
    this.dollController = dollController;
    this.puzzleController = puzzleController;
    this.softController = softController;
    this.vehicleController = vehicleController;
  }

  

  public static void main(String[] args) {
    // Static initialization with real implementations
    Main main = new Main(
      new ConstructiveController(
        new ConstructiveToyServiceImpl(new ConstructiveToyDAOImpl())
      ),
      new DollController(new DollToyServiceImpl(new DollToyDAOImpl())),
      new PuzzleController(new PuzzleToyServiceImpl(new PuzzleToyDAOImpl())),
      new SoftController(new SoftToyServiceImpl(new SoftToyDAOImpl())),
      new VehicleController(new VehicleToyServiceImpl(new VehicleToyDAOImpl()))
    );

    // Show the application brand information
    UIUtils.showBrand();

    // Show available commands
    UIUtils.showCommands();

    // Start the command loop
    while (!UIUtils.isExited) {
      // Wait for user input
      String command = UIUtils.waitForCommand();

      // Process the user command
      if (command != null) {
        main.processCommand(command);
      }
    }

    // Exit the application
    System.out.println("Exiting the application.");
  }

  private void processCommand(String command) {
    switch (command) {
      case "list":
        // Show all products
        listAllToys();
        break;
      case "help":
        // Show available commands
        UIUtils.showCommands();
        break;
      case "search":
        getParams();
        break;
      default:
        // Handle invalid command
        System.out.println(
          "Invalid command. Type 'help' to see available commands."
        );
        break;
    }
  }

  public void listAllToys() {
    printToyTable(dollController.getAllToys(), "Doll");
    printToyTable(constructiveController.getAllToys(), "Constructive");
    printToyTable(puzzleController.getAllToys(), "Puzzle");
    printToyTable(softController.getAllToys(), "Soft");
    printToyTable(vehicleController.getAllToys(), "Vehicle");
  }

  private void printToyTable(List<? extends Toy> toys, String title) {
    if (toys.isEmpty()) {
      return;
    }

    // Print table header
    System.out.println("\n" + title);
    System.out.println(
      Colors.applyStyle(
        ColorsEnum.white,
        "ID\tName\t\t\t\tCategory\t\tPrice\tRecommended Age",
        true
      )
    );

    // Iterate over each toy and print its details
    for (Toy toy : toys) {
      System.out.printf(
        "%-3s\t%-30s\t%-20s\t$%.2f\t%d\n",
        toy.getId(),
        toy.getName(),
        toy.getCategory(),
        toy.getPrice(),
        toy.getRecommendedAge()
      );
    }
  }

  private void getParams() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(
        "\nEnter parameters, separate all parameters with ';'"
      );
      System.out.println("For example:");
      System.out.println(
        "type=vehicle;category=Vehicle;recommendedAge=3;minPrice=10;maxPrice=20;name=RC Boat\n"
      );
      String searchingCommand = scanner.nextLine();

      // Check if the user wants to exit
      if (searchingCommand.equalsIgnoreCase("main")) {
        System.out.println("You returned to main menu.");
        UIUtils.waitForCommand();
        break;
      }

      // Process the collected parameters
      Map<String, String> paramMap = parseParams(searchingCommand);
      processParams(paramMap);
    }
    scanner.close();
  }

  private Map<String, String> parseParams(String searchingCommand) {
    Map<String, String> map = new HashMap<>();
    String[] params = searchingCommand.split(";");
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
    return map;
  }

  private void processParams(Map<String, String> paramMap) {
    List<List<? extends Toy>> lists = new ArrayList<>();

    if (!paramMap.containsKey("type")) {
      lists.addAll(getAllToys());
    } else {
      lists.add(getToysByType(paramMap.get("type")));
    }

    filterToysByCategory(lists, paramMap.get("category"));
    filterToysByRecommendedAge(lists, paramMap.get("recommendedAge"));
    filterToysByPriceRange(
      lists,
      paramMap.get("minPrice"),
      paramMap.get("maxPrice")
    );
    filterToysByName(lists, paramMap.get("name"));

    for (List<? extends Toy> toys : lists) {
      printToyTable(toys, "Search result");
    }
  }

  private List<List<? extends Toy>> getAllToys() {
    List<List<? extends Toy>> allToys = new ArrayList<>();
    allToys.add(constructiveController.getAllToys());
    allToys.add(dollController.getAllToys());
    allToys.add(puzzleController.getAllToys());
    allToys.add(softController.getAllToys());
    allToys.add(vehicleController.getAllToys());
    return allToys;
  }

  private List<? extends Toy> getToysByType(String type) {
    switch (type.toLowerCase()) {
      case "constructive":
        return constructiveController.getAllToys();
      case "doll":
        return dollController.getAllToys();
      case "puzzle":
        return puzzleController.getAllToys();
      case "soft":
        return softController.getAllToys();
      case "vehicle":
        return vehicleController.getAllToys();
      default:
        System.out.println("Invalid type: " + type);
        return new ArrayList<>();
    }
  }

  private void filterToysByCategory(
    List<List<? extends Toy>> lists,
    String category
  ) {
    if (category == null) return;
    filterToys(lists, toy -> toy.getCategory().equalsIgnoreCase(category));
  }

  private void filterToysByRecommendedAge(
    List<List<? extends Toy>> lists,
    String recommendedAge
  ) {
    if (recommendedAge == null) return;
    int age = Integer.parseInt(recommendedAge);
    filterToys(lists, toy -> toy.getRecommendedAge() == age);
  }

  private void filterToysByPriceRange(
    List<List<? extends Toy>> lists,
    String minPrice,
    String maxPrice
  ) {
    if (minPrice == null || maxPrice == null) return;
    double min = Double.parseDouble(minPrice);
    double max = Double.parseDouble(maxPrice);
    filterToys(lists, toy -> toy.getPrice() >= min && toy.getPrice() <= max);
  }

  private void filterToysByName(List<List<? extends Toy>> lists, String name) {
    if (name == null) return;
    filterToys(lists, toy -> toy.getName().equalsIgnoreCase(name));
  }

  private void filterToys(List<List<? extends Toy>> lists, ToyFilter filter) {
    for (List<? extends Toy> toys : lists) {
      toys.removeIf(toy -> !filter.apply(toy));
    }
  }

  @FunctionalInterface
  interface ToyFilter {
    boolean apply(Toy toy);
  }
}
