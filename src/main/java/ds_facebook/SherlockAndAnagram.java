package ds_facebook;

import java.util.*;



class ComboObjectHolder {
    private String anagram;
    private int i;
    private int j;

    public ComboObjectHolder(String anagram, int i, int j) {
        this.anagram = anagram;
        this.i = i;
        this.j = j;
    }

    public String getAnagram() {
        return anagram;
    }

    public void setAnagram(String anagram) {
        this.anagram = anagram;
    }

    public String toString() {
        return anagram/*+"-i:"+i+" -j:"+j*/;
    }
}


/**
 *  kkkk
 *  [k, k]      [(0,1),(0,2),(0,3),(1,2),(1,3),(2,3)] = 6
 *  [kk,kk]     [(0,1),(1,2)], [(0,1),(2,3)], [(1,2),(2,3)] = 3
 *  [kkk,kkk]   [(0,1,2), (1,2,3)]  = 1
 *
 *
 */
public class SherlockAndAnagram {

    static private Map<Integer, List<String>> anagramCombo = new HashMap<>();

    private static void printBinaryCombination(int[] input, int carry, int pos, String[] strings, List<String> stringCombos) {

        if(input[pos] == 0 && carry == 1) {
            input[pos] = 1;
            pos = input.length-1;
            carry = 0;
            displayArray(input, strings, stringCombos);
            return;
        }
        else if(input[pos] == 1 && carry == 1){
            input[pos] = 0;
            printBinaryCombination(input, 1, --pos, strings, stringCombos);
            return;
        }

        for(double j=Math.pow(2,input.length)-1;j>0;j--) {
            if(input[pos] == 0) {
                input[pos] = 1;
                displayArray(input, strings, stringCombos);
            }
            else {
                input[pos] = 0;
                printBinaryCombination(input, 1, pos-1, strings, stringCombos);
            }
        }
    }

    private static void displayArray(int[] array, String[] strings, List<String> stringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<array.length;i++) {
            if(array[i] == 1) {
                stringBuilder.append(strings[i]);
            }
            System.out.print(array[i]);
        }
        System.out.println(" "+stringBuilder.toString());

        if(anagramCombo.containsKey(stringBuilder.toString().hashCode())) {
            anagramCombo.get(stringBuilder.toString().hashCode()).add(stringBuilder.toString());
        }
        else {
            List<String> stringList1 = new ArrayList<>();
            stringList1.add(stringBuilder.toString());
            anagramCombo.put(stringBuilder.toString().hashCode(), stringList1);
        }
    }

    public static void anagram(String input) {
        String[] inputArray = input.split("");
        printBinaryCombination(new int[inputArray.length], 0, input.length()-1, inputArray, new ArrayList<>());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfTest = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<noOfTest;i++) {
            anagram(scanner.nextLine());
        }
        System.out.println(anagramCombo);
    }
}
