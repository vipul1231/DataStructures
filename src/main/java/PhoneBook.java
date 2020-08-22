import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputs = Integer.parseInt(scanner.nextLine());

        Map<String, String> inputMaps = new HashMap<>();

        for(int i=0;i<inputs;i++) {
            String[] values = scanner.nextLine().split(" ");

            switch (values[0]) {
                case "add" : inputMaps.put(values[1], values[2]);
                break;
                case "find" :
                    System.out.println(inputMaps.get(values[1]) == null ? "not found" : inputMaps.get(values[1]));
                break;
                case "del" : inputMaps.remove(values[1]);
                break;
            }
        }
        scanner.close();
    }
}
