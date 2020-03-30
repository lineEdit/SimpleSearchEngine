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
        List<People> list = new ArrayList<>();
        while (num >= 0) {
            list.add(new People(scanner.nextLine().split(" ")));
            num--;
        }
        System.out.println("Enter the number of search queries: ");
        num = scanner.nextInt();
        while (num >= 0) {
            System.out.println("Enter data to search people: ");
            String find = scanner.next();
            List<People> result = new ArrayList<>();
            for (People item : list) {
                if (item.contains(find)) {
                    result.add(item);
                }
            }
            if (result.size() > 0) {
                System.out.println("Found people: ");
                for (People item : result) {
                    System.out.println(item.toString());
                }
            } else {
                System.out.println("No matching people found.");
            }
            num--;
        }
    }
}