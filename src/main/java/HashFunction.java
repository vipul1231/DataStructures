import java.util.ArrayList;
import java.util.Scanner;

public class HashFunction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBucket = Integer.parseInt(scanner.nextLine());
        ArrayList[] hashTable = new ArrayList[numberOfBucket];
        int numberOfQueries = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfQueries; i++) {
            String[] input = scanner.nextLine().split(" ");
            //System.out.print(input[0]+" "+input[1] +" =>");
            switch (input[0]) {
                case "add":
                    long place = hashFunctionComputation(input[1], numberOfBucket);
                    ArrayList chain = hashTable[(int) place];
                    if (chain == null) {
                        ArrayList<String> newList = new ArrayList<>();
                        newList.add(input[1]);
                        hashTable[(int) place] = newList;
                    } else {
                        if (!chain.contains(input[1]))
                            chain.add(0, input[1]);
                    }
                    break;
                case "del":
                    long placeToPerformDelete = hashFunctionComputation(input[1], numberOfBucket);
                    ArrayList chain_1 = hashTable[(int) placeToPerformDelete];
                    if (chain_1 != null) {
                        chain_1.remove(input[1]);
                    }
                    break;
                case "find":
                    long placeToPerformSearch = hashFunctionComputation(input[1], numberOfBucket);
                    ArrayList chain_2 = hashTable[(int) placeToPerformSearch];
                    if (chain_2 != null && chain_2.contains(input[1])) {
                        System.out.println("yes");
                        break;
                    }
                    System.out.println("no");
                    break;
                case "check":
                    ArrayList chain_3 = hashTable[Integer.parseInt(input[1])];

                    if (chain_3 == null || chain_3.size() == 0) {
                        System.out.println();
                    } else {
                        for (Object output : chain_3) {
                            System.out.print(output + " ");
                        }
                        System.out.println();
                    }
                    break;
            }
        }

        scanner.close();
    }


    private static long hashFunctionComputation(String inputArray, int bucketSize) {

        int x = 263;
        long p = 1000000007;
        long result = 0;
        long hash = 0;
        String[] s = inputArray.split("");
        for (int i = s.length-1;i>= 0;--i)
            hash = (hash * 263 + (int)inputArray.charAt(i)) % 1000000007;
        return (int)hash % bucketSize;
    }
}
