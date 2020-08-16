import java.util.*;
import java.util.function.IntBinaryOperator;

public class CustomStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = Integer.parseInt(scanner.nextLine());
        List<Integer> stack = new ArrayList<>();
        List<Integer> maxStackList = new ArrayList<>();

        for(int i=0;i<testcases;i++) {
            String command = scanner.nextLine();
            if(command.startsWith("push")) {
                int index  = command.indexOf("push")+5;
                int number = Integer.parseInt(command.substring(index));
                stack.add(number);
                if(maxStackList.size() == 0) {
                    maxStackList.add(number);
                }
                else if( number > maxStackList.get(maxStackList.size() - 1)){
                    maxStackList.add(number);
                }
                else  {
                    maxStackList.add(maxStackList.get(maxStackList.size()-1));
                }
            }
            else if(command.startsWith("pop")) {
               int number = stack.remove(stack.size()-1);
               maxStackList.remove(maxStackList.size() -1);
            }
            else if(command.startsWith("max")) {
                System.out.println(maxStackList.get(maxStackList.size() -1));
            }
        }


        scanner.close();
    }
}
