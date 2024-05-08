package com.itpu.warehouse;

import java.io.Serializable;

import com.itpu.warehouse.controller.ConstructiveController;
import com.itpu.warehouse.controller.DollController;
import com.itpu.warehouse.controller.PuzzleController;
import com.itpu.warehouse.controller.SoftController;
import com.itpu.warehouse.controller.VehicleController;
import com.itpu.warehouse.service.impl.*;
import com.itpu.warehouse.utils.UIUtils;
import com.itpu.warehouse.dao.impl.*;

public class Main implements Serializable {
    public static void main(String[] args) {

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

    public static void listAllToys() {
        ConstructiveController constructiveController = new ConstructiveController(
                new ConstructiveToyServiceImpl(new ConstructiveToyDAOImpl()));
        DollController dollController = new DollController(new DollToyServiceImpl(new DollToyDAOImpl()));
        PuzzleController puzzleController = new PuzzleController(new PuzzleToyServiceImpl(new PuzzleToyDAOImpl()));
        SoftController softController = new SoftController(new SoftToyServiceImpl(new SoftToyDAOImpl()));
        VehicleController vehicleController = new VehicleController(new VehicleToyServiceImpl(new VehicleToyDAOImpl()));

        // Fetch and display all soft toys
        System.out.println("---- Soft Toys ----");
        softController.getAllToys();

        // Fetch and display all vehicle toys
        System.out.println("\n---- Vehicle Toys ----");
        vehicleController.getAllToys();

        // Fetch and display all puzzle toys
        System.out.println("\n---- Puzzle Toys ----");
        puzzleController.getAllToys();

        // Fetch and display all doll toys
        System.out.println("\n---- Doll Toys ----");
        dollController.getAllToys();

        // Fetch and display all constructive toys
        System.out.println("\n---- Constructive Toys ----\n");
        constructiveController.getAllToys();
    }
}
