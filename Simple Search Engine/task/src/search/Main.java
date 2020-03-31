package search;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); ++i) {
            for (String item : list.get(i).split(" ")) {
                if (map.containsKey(item)) {
                    map.get(item).add(i);
                } else {
                    ArrayList<Integer> integerList = new ArrayList<>();
                    integerList.add(i);
                    map.put(item, integerList);
                }
            }
        }
//        for (String item : map.keySet()) {
//            System.out.println(item + map.get(item).toString());
//        }

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
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    List<String> result = new ArrayList<>();
                    String find = "";
                    switch (scanner.nextLine()) {
                        case "ALL":
                            System.out.println("\nEnter a name or email to search all suitable people.");
                            find = scanner.nextLine();
                            for (String item : list) {
                                if (containsAllString(item, find)) {
                                    result.add(item);
                                }
                            }
                        break;
                        case "ANY":
                            System.out.println("\nEnter a name or email to search all suitable people.");
                            find = scanner.nextLine();
                            for (String item : list) {
                                if (containsString(item, find)) {
                                    result.add(item);
                                }
                            }
                        break;
                            case "NONE":
                                System.out.println("\nEnter a name or email to search all suitable people.");
                                find = scanner.nextLine();
                                for (String item : list) {
                                    if (!containsString(item, find)) {
                                        result.add(item);
                                    }
                                }
                        break;
                    }
                    if (result.size() > 0) {
                        System.out.println(result.size() + " persons found: ");
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

    static boolean containsAllString(String string, String find) {
        for (String itemListSplit : string.split("\\s+")) {
            for (String itemFindSplit : find.split("\\s+")) {
                if (itemListSplit.compareToIgnoreCase(itemFindSplit) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean containsString(String string, String find) {
        for (String itemListSplit : string.split("\\s+")) {
            for (String itemFindSplit : find.split("\\s+")) {
                if (itemListSplit.compareToIgnoreCase(itemFindSplit) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}