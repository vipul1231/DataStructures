import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bracket {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String[] input = scanner.nextLine().split("");

        List<String> bracketList = new ArrayList<>();
        List<Integer> index= new ArrayList<>();

        if(input.length == 1){
            System.out.println(count+1);
            return;
        }

        for(count=0;count<input.length;count++){
            if(input[count].equals("(") || input[count].equals("[") || input[count].equals("{")) {
                bracketList.add(input[count]);
                index.add(count);
            }
            else if(input[count].equals(")") || input[count].equals("]") || input[count].equals("}")) {
                if (bracketList.size() > 0 && match(bracketList.get(bracketList.size()-1), input[count])) {
                    bracketList.remove(bracketList.size()-1);
                    index.remove(index.size()-1);
                }
                else {
                    index.add(count);
                    break;
                }
            }
        }
        if(bracketList.size() == 0 && index.size() ==0){
            System.out.println("Success");
            return;
        }
        else {
            System.out.println(index.get(index.size()-1)+1);
        }


        scanner.close();
    }

    private static boolean match(String source, String target) {

        if(source.equals("(") && target.equals(")")) {
            return true;
        }
        else if(source.equals("{") && target.equals("}")) {
            return true;
        }
        else if(source.equals("[") && target.equals("]")) {
            return true;
        }
        return false;
    }
}
