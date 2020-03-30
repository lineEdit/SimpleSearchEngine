package search;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String findStr = scanner.next();
        int index = 1;
        for (String item : inputStr.split(" ")) {
            if (item.compareTo(findStr) == 0) {
                System.out.println(index);
                return;
            }
            ++index;
        }
        System.out.println("Not found");
    }
}
