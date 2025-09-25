package com.africanbigcats;

import java.util.*;

public class Menu {

    private Scanner input;

    public Menu() {
        this.input = new Scanner(System.in);
    }

    public void print() {
        printLine();
        System.out.println("African Big Cats App");
        printLine();
        printCommand('c', "[C]reates a big cat");
        printCommand('d', "[D]eletes a big cat");
        printCommand('f', "[F]inds a big cat");
        printCommand('l', "[L]ists all big cats");
        printCommand('q', "[Q]uits");
        printLine();
    }

    private static void printLine() {
        System.out.println("----------------------------------------------------------");
    }

    private static void printCommand(Character command, String desc) {
        System.out.printf("%s\t%s\n", command, desc);
    }

    public Character getCommand() {
        Character command = '_';
        String rawInput = input.nextLine().toLowerCase();
        if (rawInput.length() > 0) command = rawInput.charAt(0);
        return command;
    }

    public boolean executeCommand(Character command, LinkedList<Panthera> catList) {
        boolean success = true;
        switch (command) {
            case 'c': executeCreate(catList); break;
            case 'd': executeDelete(catList); break;
            case 'f': executeFind(catList); break;
            case 'l': executeList(catList); break;
            case 'q': executeQuit(); break;
            default:
                System.out.println("ERROR: Unknown command");
                success = false;
        }
        return success;
    }

    public void update(LinkedList<Panthera> catList) {
        for (Panthera cat : catList) {
            cat.move();
        }
    }

    public void executeQuit() {
        input.close();
        printLine();
        System.out.println("Thank you for using the African Big Cats App!");
        printLine();
    }

    private Panthera getNewCat(String name) {
        System.out.println("Select species (1-Tiger, 2-Lion, 3-Jaguar): ");
        String choice = input.nextLine();
        switch (choice) {
            case "1": return new Tiger(name);
            case "2": return new Lion(name);
            case "3": return new Jaguar(name);
            default:
                System.out.println("Invalid choice. Defaulting to Tiger.");
                return new Tiger(name);
        }
    }

    private void executeCreate(LinkedList<Panthera> catList) {
        System.out.print("Enter name for the big cat: ");
        String name = input.nextLine();

        for (Panthera cat : catList) {
            if (cat.name().equalsIgnoreCase(name)) {
                System.out.println("ERROR: Cat with this name already exists!");
                return;
            }
        }

        Panthera cat = getNewCat(name);
        catList.add(cat);
        System.out.println("Created: " + cat);
    }

    private void executeList(LinkedList<Panthera> catList) {
        printLine();
        System.out.println("African Big Cat List");
        printLine();
        if (catList.size() > 0) {
            for (Panthera cat : catList) {
                System.out.println(cat);
            }
        } else {
            System.out.println("There are no African Big Cats. :(");
        }
    }

    private void executeDelete(LinkedList<Panthera> catList) {
        System.out.print("Enter name of cat to delete: ");
        String name = input.nextLine();
        Panthera toRemove = null;
        for (Panthera cat : catList) {
            if (cat.name().equalsIgnoreCase(name)) {
                toRemove = cat;
                break;
            }
        }
        if (toRemove != null) {
            catList.remove(toRemove);
            System.out.println("Deleted " + name);
        } else {
            System.out.println("Cat not found!");
        }
    }

    private void executeFind(LinkedList<Panthera> catList) {
        System.out.print("Enter name or part of name to find: ");
        String search = input.nextLine().toLowerCase();
        boolean found = false;
        for (Panthera cat : catList) {
            if (cat.name().toLowerCase().contains(search)) {
                System.out.println(cat);
                found = true;
            }
        }
        if (!found) System.out.println("No cats found matching: " + search);
    }
}
