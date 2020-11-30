package ds_facebook;

import java.util.Scanner;

public class CountValleys {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSteps = Integer.parseInt(scanner.nextLine());
        String[] steps = scanner.nextLine().split("");

        int level = 0;
        int numberOfValleyTraversed = 0;
        boolean valleyStart = false, valleyEnds = false;
        for (String direction : steps) {
            switch (direction) {
                case "D":
                    level -= 1;
                    break;
                case "U":
                    level += 1;
                    break;
            }

            if (level < 0 && !valleyStart) {
                valleyStart = true;
            } else if (valleyStart && level >= 0) {
                valleyStart = false;
                numberOfValleyTraversed += 1;
            }
        }

        System.out.println(numberOfValleyTraversed);
        scanner.close();
    }
}
