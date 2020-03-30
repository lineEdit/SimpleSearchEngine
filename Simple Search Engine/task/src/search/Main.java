package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        int num = scanner.nextInt();
        System.out.println("Enter all people: ");
        List<String> list = new ArrayList<>();
        while (num >= 0) {
            list.add(scanner.nextLine());
            num--;
        }
        System.out.println("\nEnter the number of search queries: ");
        num = scanner.nextInt();
        while (num >= 0) {
            System.out.println("\nEnter data to search people: ");
            String find = scanner.next();
            List<String> result = new ArrayList<>();
            for (String item : list) {
                if (item.toLowerCase().replaceAll(" ", "").contains(find.toLowerCase())) {
                    result.add(item);
                }
            }
            if (result.size() > 0) {
                System.out.println("\nFound people: ");
                for (String item : result) {
                    System.out.println(item);
                }
            } else {
                System.out.println("\nNo matching people found.");
            }
            num--;
        }
    }
}