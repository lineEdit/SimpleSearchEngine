package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 2 && args[0].compareTo("--data") == 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[1]))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            int menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 0:
                    System.out.println("\nBye!");
                    return;
                case 1:
                    System.out.println("\nEnter a name or email to search all suitable people.");
                    String find = scanner.nextLine();
                    List<String> result = new ArrayList<>();
                    for (String item : list) {
                        if (item.toLowerCase().replaceAll(" ", "").contains(find.toLowerCase())) {
                            result.add(item);
                        }
                    }
                    if (result.size() > 0) {
                        for (String item : result) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("\nNo matching people found.");
                    }
                    break;
                case 2:
                    System.out.println("\n=== List of people ===");
                    for (String item : list) {
                        System.out.println(item);
                    }
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.");
            }
        }
    }
}